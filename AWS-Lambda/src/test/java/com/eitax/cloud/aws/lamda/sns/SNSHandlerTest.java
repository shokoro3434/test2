package com.eitax.cloud.aws.lamda.sns;

import junit.framework.TestCase;

public class SNSHandlerTest extends TestCase{
	public void testShutdown(){
		SNSHandlerInput json = new SNSHandlerInput();
		json.setAccessKey("AKIAIBCKC7U7KFRUZ3ZA");
		json.setSecretKey("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");
		json.setTopicArn("arn:aws:sns:ap-northeast-1:960795461263:topic");
		json.setUseKey(true);
		String result = new SNSHandler ().publish(json, null);
		assertEquals("OK", result);
		
	}
}


