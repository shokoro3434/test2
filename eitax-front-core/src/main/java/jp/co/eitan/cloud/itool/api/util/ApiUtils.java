package jp.co.eitan.cloud.itool.api.util;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.Tag;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailAddressRequest;
import com.eitax.recall.front.domain.LambdaJson;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.ogis.cloudtool.lambda.core.ec2.common.EC2Request;
import jp.co.ogis.cloudtool.lambda.core.rds.common.model.RdsRequest;

public class ApiUtils {
	
	public static String toMethod(String action){
		return action.substring("ec2-".length());
	}
	public static String toFunctionName (String arn){
		return arn.substring(arn.lastIndexOf(":")+":".length());
	}
	public static String toPayload(String description) {
		try {
			ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
			LambdaJson json = mapper.readValue(description, LambdaJson.class);
			String actionName = json.getActionName();
			if (actionName.startsWith("rds-")){
				RdsRequest req = new RdsRequest();
				req.setProfileName(json.getSys().getRds().getProfileName());
				req.setRegion(json.getSys().getRds().getRegion());
				req.setInstanceId(json.getSys().getRds().getInstanceId());
				req.setSnapshotId(json.getSys().getRds().getSnapshotId());
				return mapper.writeValueAsString(req);
			}
			else if(actionName.startsWith("ec2-")){
				EC2Request req = new EC2Request();
				req.setProfileName(json.getSys().getEc2().getProfileName());
				req.setRegion(json.getSys().getEc2().getRegion());
				req.setInstanceIds(json.getSys().getEc2().getInstanceIds());
				return mapper.writeValueAsString(req);
			}
			else if (actionName.startsWith("elb-")){
				EC2Request req = new EC2Request();
				req.setProfileName(json.getSys().getElb().getProfileName());
				req.setRegion(json.getSys().getElb().getRegion());
				req.setLoadBalancerName(json.getSys().getElb().getName());
				req.setInstanceId(json.getSys().getElb().getInstanceId());
				return mapper.writeValueAsString(req);
			}
			else if (actionName.startsWith("ebs-")){
				EC2Request req = new EC2Request();
				req.setProfileName(json.getSys().getEbs().getProfileName());
				req.setRegion(json.getSys().getEbs().getRegion());
				req.setVolumeId(json.getSys().getEbs().getVolumeId());
				return mapper.writeValueAsString(req);
			}
			else if (actionName.startsWith("sg_-")){
				EC2Request req = new EC2Request();
				req.setProfileName(json.getSys().getSg().getProfileName());
				req.setRegion(json.getSys().getSg().getRegion());
				req.setGroupId(json.getSys().getSg().getGroupId());
				req.setIpProtocol(json.getSys().getSg().getIpProtocol());
				req.setPort(json.getSys().getSg().getPort());
				req.setCidr(json.getSys().getSg().getCidr());
				return mapper.writeValueAsString(req);
			}
		} catch (Exception e) {

		}
		return null;
	}

	public static String toName(List<Tag> tags) {
		for (Tag tag : tags) {
			if (tag.getKey().equals("Name")) {
				return tag.getValue();
			}
		}
		return "";
	}

	public static void sendMail(String accessKey,String secretKey,final String fromEmail, final String toEmail, final String subject,
			final String emailBody) {

		SendEmailRequest request = new SendEmailRequest().withSource(fromEmail);

		List<String> toAddresses = new ArrayList<String>();
		toAddresses.add(toEmail);
		Destination dest = new Destination().withToAddresses(toAddresses);

		// set fromEmail as BCC
		List<String> toBccAddresses = new ArrayList<String>();
		toBccAddresses.add(fromEmail);
		dest.setBccAddresses(toBccAddresses);
		request.setDestination(dest);

		Content subjContent = new Content().withData(subject);
		Message msg = new Message().withSubject(subjContent);

		// Include a body in HTML formats.
		Content textContent = new Content().withData(emailBody);
		Body body = new Body().withText(textContent);
		msg.setBody(body);

		request.setMessage(msg);

		AmazonSimpleEmailService client = null;
		
		if (System.getProperty("useProxy") != null){
			ClientConfiguration conf = new ClientConfiguration()
					.withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword"))
					.withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AmazonSimpleEmailServiceClient(new BasicAWSCredentials(accessKey,secretKey),conf);
		}
		else{
			ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
					.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
			client = new AmazonSimpleEmailServiceClient(new BasicAWSCredentials(accessKey,secretKey),conf);
		}

		client.verifyEmailAddress(new VerifyEmailAddressRequest().withEmailAddress(fromEmail));
		client.verifyEmailAddress(new VerifyEmailAddressRequest().withEmailAddress(toEmail));
		client.setRegion(Region.getRegion(Regions.US_WEST_2));

		// Call Amazon SES to send the message.
		try {
			client.sendEmail(request);

		} catch (AmazonClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String createBody(String template,Map<String,String> data) {
		// Properties props = new Properties();
		// props.setProperty("resource.loader", "wepapp");
		// props.setProperty("webapp.resource.loader.class",
		// "org.apache.velocity.tools.view.WebappResourceLoader");
		// props.setProperty("webapp.resource.loader.path",
		// "/WEB-INF/mailtemplates/");

		// VelocityEngine ve = new VelocityEngine();
		// ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		// ve.setProperty("classpath.resource.loader.class",
		// ClasspathResourceLoader.class.getName());
		// ve.init();
		// Velocity.init();
		// Properties p = new Properties();
		// p.setProperty("resource.loader", "class");
		// p.setProperty("class.resource.loader.class",
		// "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		// p.setProperty("class.resource.loader.path", "classpath:vm/");
		// p.setProperty("input.encoding", "UTF-8");

		// VelocityEngine velocityEngine = new VelocityEngine();
		// velocityEngine.setProperty("resource.loader", "class");
		// velocityEngine.setProperty("class.resource.loader.class",
		// "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		// velocityEngine.setProperty("input.encoding", "UTF-8");
		// velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "file,class");
		// velocityEngine.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH,
		// "classpath:vm/");
		// velocityEngine.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "");
		// velocityEngine.init();

		Properties properties = new Properties();
		properties.setProperty("resource.loader", "class");
		properties.setProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		VelocityEngine velocityEngine = new VelocityEngine(properties);

		// vmファイルに出力する値を設定
		VelocityContext context = new VelocityContext();
		for (String key : data.keySet()){
			context.put(key, data.get(key));
		}
		// context.put("price", "1000");

		// テンプレートの作成
		// Template template = Velocity.getTemplate("vm/rds-reboot.vm");

		// テンプレートへ値を出力します。
		StringWriter sw = new StringWriter();
		velocityEngine.mergeTemplate(template, "utf-8", context, sw);
		// template.merge(context,sw);
		sw.flush();

		System.out.println(sw.toString());
		return sw.toString();
	}

}
