package com.eitax.cloud.aws.lamda.sns;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class SNSHandler {
	public String publish (SNSHandlerInput json,Context ctx){
		AmazonSNSClient sns = null;
    	if (json.isUseKey()){
    		AWSCredentials credentials = new BasicAWSCredentials(json.getAccessKey(), json.getSecretKey());
            sns = new AmazonSNSClient(credentials);
            sns.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
    	}
    	else{
            sns = new AmazonSNSClient();
            sns.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
    	}
    	String msg = "日本語 My text published to SNS topic with email endpoint";
    	PublishRequest publishRequest = new PublishRequest(json.getTopicArn(), msg);
    	PublishResult publishResult = sns.publish(publishRequest);
    	//print MessageId of message published to SNS topic
    	System.out.println("MessageId - " + publishResult.getMessageId());
		return "OK";
	}
}
