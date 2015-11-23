package com.eitax.cloud.aws.lamda.ec2;

import junit.framework.TestCase;

public class EC2HandlerTest extends TestCase{
	public void testShutdown(){
		EC2HandlerInput json = new EC2HandlerInput();
		json.setInstanceId("i-3a8c0e9f");
		json.setAccessKey("AKIAIBCKC7U7KFRUZ3ZA");
		json.setSecretKey("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");
		json.setUseKey(true);
		EC2HandlerResult result = new EC2Handler ().shutdown(json, null);
		assertEquals(0, result.getCode());
		
	}
}


