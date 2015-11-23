package com.eitax.cloud.aws.service.impl;


import com.eitax.cloud.aws.service.EC2Service;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvocationType;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.runtime.Context;


public class EC2ServiceImpl implements EC2Service{

	@Override
	public String shutdown(EC2ServiceInput json,Context ctx) {
		// TODO Auto-generated method stub
		AWSLambdaClient lambda = null;
    	if (json.isUseKey()){
    		AWSCredentials credentials = new BasicAWSCredentials(json.getAccessKey(), json.getSecretKey());
            lambda = new AWSLambdaClient(credentials);
            lambda.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
    	}
    	else{
            lambda = new AWSLambdaClient();
            lambda.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
    	}
		InvokeRequest ir = new InvokeRequest ()
				.withFunctionName("java")
				.withInvocationType(InvocationType.RequestResponse)
				.withPayload("{\"instanceId\" : \"i-3a8c0e9f\",\"useKey\" : false}");
		InvokeResult result = lambda.invoke(ir);
		String code = String.valueOf(result.getStatusCode());

		InvokeRequest ir2 = new InvokeRequest ()
				.withFunctionName("sns")
				.withInvocationType(InvocationType.RequestResponse)
				.withPayload("{\"topicArn\" : \"arn:aws:sns:ap-northeast-1:960795461263:topic\",\"useKey\" : false}");
		InvokeResult result2 = lambda.invoke(ir2);
		String code2 = String.valueOf(result2.getStatusCode());
		return code2;
	}
	
}
