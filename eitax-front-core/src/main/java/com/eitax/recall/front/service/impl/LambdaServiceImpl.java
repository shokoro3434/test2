package com.eitax.recall.front.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.DescribeSnapshotsRequest;
import com.amazonaws.services.ec2.model.DescribeSnapshotsResult;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.amazonaws.services.ec2.model.Snapshot;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.CreateFunctionRequest;
import com.amazonaws.services.lambda.model.DeleteFunctionRequest;
import com.amazonaws.services.lambda.model.FunctionCode;
import com.amazonaws.services.lambda.model.FunctionConfiguration;
import com.amazonaws.services.lambda.model.GetFunctionRequest;
import com.amazonaws.services.lambda.model.GetFunctionResult;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ListFunctionsResult;
import com.amazonaws.services.lambda.model.Runtime;
import com.amazonaws.services.lambda.model.UpdateFunctionConfigurationRequest;
import com.amazonaws.services.lambda.model.UpdateFunctionConfigurationResult;
import com.eitax.recall.front.boot.LambdaSettings;
import com.eitax.recall.front.boot.NotificationSettings;
import com.eitax.recall.front.boot.SystemSettings;
import com.eitax.recall.front.domain.Lambda;
import com.eitax.recall.front.domain.LambdaDescription;
import com.eitax.recall.front.domain.LambdaJson;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.AWSMasterDataService;
import com.eitax.recall.front.service.LambdaService;
import com.eitax.recall.front.service.ProfileService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.eitan.cloud.itool.api.model.LambdaScheduleRequest;
import jp.co.eitan.cloud.itool.api.util.ApiUtils;
import jp.co.ogis.cloudtool.lambda.core.common.JobResult;
import com.eitax.recall.front.service.LambdaDescriptionService;

@Service
public class LambdaServiceImpl implements LambdaService {
	@Autowired
	private AWSMasterDataService aWSMasterDataService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private SystemSettings settings;
	@Autowired
	private NotificationSettings notificationSettings;
	@Autowired
	private LambdaDescriptionService lambdaDescriptionService;
	@Autowired
	private LambdaSettings lambdaSettings;
	@Override
	public Map<String, String> retrieveLambdaList(Profile p) {
		Map<String,String> ret = new HashMap<String,String> ();
		for (Lambda lambda : retrieveLambda(p)){
			ret.put(lambda.getJobId(), lambda.getJobId()+":"+lambda.getAwsName()+":"+lambda.getActionName());
		}
		return ret;
	}

	@Override
	public Map<String,String> requestSchedule(String accessKey, String secretKey, String email,String payload) {
		try {
			ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
			LambdaScheduleRequest json = mapper.readValue(payload, LambdaScheduleRequest.class);
			String body = ApiUtils.createBody(settings.getTemplate(),new HashMap<String,String>(){{
				put("jobId",json.getJobId());
				put("time",json.getTime());
				put("cronType",json.getCronType());
				put("note",json.getNote());
				put("sender",email);
			}});
			ApiUtils.sendMail(accessKey, secretKey, settings.getEmail(),
					settings.getCloudDivEmail(), settings.getSubject(), body);
			return Collections.emptyMap();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public Map<String, String> delete(String accessKey, String secretKey, String arn) {
		AWSLambda client = null;
		if (System.getProperty("useProxy") != null) {
//			ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
//					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
//					.withProxyUsername(System.getProperty("proxyUsername"))
//					.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
//					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AWSLambdaClient(new BasicAWSCredentials(accessKey, secretKey), conf);
		} else {
			ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AWSLambdaClient(new BasicAWSCredentials(accessKey, secretKey), conf);
		}
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		try{
			client.deleteFunction(new DeleteFunctionRequest()
					.withFunctionName(arn));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return Collections.emptyMap();
	}

	@Override
	public Map<String, String> create(String accessKey, String secretKey, String payload) {
		AWSLambda client = null;
		if (System.getProperty("useProxy") != null) {
			ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AWSLambdaClient(new BasicAWSCredentials(accessKey, secretKey), conf);
		} else {
			ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AWSLambdaClient(new BasicAWSCredentials(accessKey, secretKey), conf);
		}
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		try {
			ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
			LambdaJson json = mapper.readValue(payload, LambdaJson.class);
			String functionName = json.getActionName()+"_"+RandomStringUtils.randomAlphanumeric(12);
			String actionName = json.getActionName();
			String handler = actionName.startsWith("rds-") ? lambdaSettings.getRdsHandler() : lambdaSettings.getEc2Handler();
			client.createFunction(new CreateFunctionRequest()
					.withDescription("")
					.withRole(lambdaSettings.getRole())
					.withFunctionName(functionName)
					.withHandler(handler+"::"+ApiUtils.toMethod(json.getActionName()))
					.withRuntime(Runtime.Java8).withTimeout(300).withMemorySize(512).withCode(new FunctionCode()
							.withS3Bucket(lambdaSettings.getS3Backet()).withS3Key(lambdaSettings.getS3Key())));
			lambdaDescriptionService.register(functionName, payload);
			return Collections.emptyMap();
		} catch (AmazonServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AmazonClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String update(String accessKey, String secretKey, String arn, String payload) {
		// TODO Auto-generated method stub
		AWSLambda client = null;
		if (System.getProperty("useProxy") != null) {
			ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AWSLambdaClient(new BasicAWSCredentials(accessKey, secretKey), conf);
		} else {
			ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AWSLambdaClient(new BasicAWSCredentials(accessKey, secretKey), conf);
		}

		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		try {
			UpdateFunctionConfigurationResult result = client.updateFunctionConfiguration(
					new UpdateFunctionConfigurationRequest()
					.withDescription("")
					.withFunctionName(arn));
			lambdaDescriptionService.update(ApiUtils.toFunctionName(arn), payload);

		} catch (AmazonServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AmazonClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String invoke(String accessKey, String secretKey, String sender,String arn, String payload) {
		// TODO Auto-generated method stub
		AWSLambda client = null;
		if (System.getProperty("useProxy") != null) {
			ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AWSLambdaClient(new BasicAWSCredentials(accessKey, secretKey), conf);
		} else {
			ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AWSLambdaClient(new BasicAWSCredentials(accessKey, secretKey), conf);
		}

		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		InvokeResult ir = client.invoke(new InvokeRequest().withFunctionName(arn).withPayload(payload)
				.withSdkClientExecutionTimeout(1000 * 300).withSdkRequestTimeout(1000 * 300));
		System.out.println(ir);
		String resp = new String(ir.getPayload().array());
		System.err.println(resp);
		
		try {
//			LambdaJson req = new ObjectMapper().readValue(payload, LambdaJson.class);
			final JobResult json = new ObjectMapper().readValue(resp, JobResult.class);
			String body = ApiUtils.createBody(notificationSettings.getTemplate(),new HashMap<String,String>(){{
				put("jobId","under construction");
				put("message",json != null ? json.getMessage() : "none");
				put("startDateTime",json.getStartDateTime());
				put("endDateTime",json.getEndDateTime());
			}});
			ApiUtils.sendMail(accessKey, secretKey, notificationSettings.getEmail(),
					notificationSettings.getEmail(), notificationSettings.getSubject(), body);
			return resp;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e){
			
		}
		return resp;
	}

	private LambdaDescription find(List<LambdaDescription> src,String functionName){
		for (LambdaDescription ld : src){
			if (ld.getFunctionName().equals(functionName)){
				return ld;
			}
		}
		return null;
	}
	
	public List<Lambda> retrieveLambda(Profile p) {
		AWSLambda client = null;
		if (System.getProperty("useProxy") != null) {
			ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword"));
			client = new AWSLambdaClient(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
		} else {
			client = new AWSLambdaClient(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()));
		}
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));

		List<Lambda> ret = new ArrayList<Lambda>();
		ListFunctionsResult result = client.listFunctions();
		Map<String, String> aws = aWSMasterDataService.retrieveAwsNames();
		Map<String, String> actions = aWSMasterDataService.retrieveActions();
		List<LambdaDescription> desc = this.lambdaDescriptionService.findAll();
		for (FunctionConfiguration fc : result.getFunctions()) {
			String arn = fc.getFunctionArn();
			try {
				GetFunctionResult gfr = client.getFunction(new GetFunctionRequest().withFunctionName(arn));
				FunctionConfiguration config = gfr.getConfiguration();
				Lambda lambda = new Lambda();
				
				LambdaDescription ld = find(desc,config.getFunctionName());
				String description = ld != null ? ld.getDescription() : config.getDescription();
				LambdaJson json = new ObjectMapper().readValue(description, LambdaJson.class);
				lambda.setJobId(json.getJobId());
				lambda.setAwsName(aws.get(json.getAwsName()));
				lambda.setActionName(actions.get(json.getActionName()));
				lambda.setArn(config.getFunctionArn());
//				lambda.setDescription(config.getDescription());
				lambda.setDescription(description);
				
				lambda.setTriggerName(json.getTriggerName());
				lambda.setModalId(json.getSys().getModalId());
				lambda.setModModalId(json.getSys().getModModalId());
				
				
				ret.add(lambda);
				//System.err.println("success : " + arn);
			} catch (Exception e) {
				//e.printStackTrace();
				System.err.println("failed : " + arn);
				System.err.println("msg : " + e.getMessage());
			}
		}
		Collections.sort(ret, new BeanComparator("description"));
		return ret;
	}


	
}
