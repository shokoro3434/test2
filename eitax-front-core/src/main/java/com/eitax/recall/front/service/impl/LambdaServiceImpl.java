package com.eitax.recall.front.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.FunctionConfiguration;
import com.amazonaws.services.lambda.model.GetFunctionRequest;
import com.amazonaws.services.lambda.model.GetFunctionResult;
import com.amazonaws.services.lambda.model.ListFunctionsResult;
import com.eitax.recall.front.domain.Lambda;
import com.eitax.recall.front.domain.LambdaJson;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.LambdaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LambdaServiceImpl implements LambdaService{
	public List<Lambda> retrieveLambda(Profile p){
		AWSLambda client = new AWSLambdaClient(new BasicAWSCredentials(p.getAccessKey(),p.getSecretKey()));
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		
		List<Lambda> ret = new ArrayList<Lambda>();
		ListFunctionsResult result = client.listFunctions();
		for (FunctionConfiguration fc : result.getFunctions()){
			String arn = fc.getFunctionArn();
			try{
				GetFunctionResult gfr = client.getFunction(new GetFunctionRequest().withFunctionName(arn));
				FunctionConfiguration config = gfr.getConfiguration();
				Lambda lambda = new Lambda ();
				LambdaJson json = new ObjectMapper().readValue(config.getDescription(), LambdaJson.class);
				lambda.setArn(config.getFunctionArn());
				lambda.setDescription(config.getDescription());
				StringBuffer sb = new StringBuffer ();
				sb.append(json.getJobId()+":");
				sb.append(json.getAwsName()+":");
				sb.append(json.getRegion()+":");
				sb.append(json.getActionName()+":");
				lambda.setJobName(sb.toString());
				lambda.setTriggerName(json.getTriggerName());
				lambda.setModalId(json.getSystem().getModalId());
				ret.add(lambda); 
				System.err.println("success : "+arn);
			}
			catch(Exception e){
				//e.printStackTrace();
				System.err.println("failed : "+arn);
				System.err.println("msg : "+e.getMessage());
			}
		}
		Collections.sort(ret, new BeanComparator("description"));
		return ret;
	}
}
