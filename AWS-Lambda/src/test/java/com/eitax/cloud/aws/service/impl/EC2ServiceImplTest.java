package com.eitax.cloud.aws.service.impl;

import junit.framework.TestCase;

public class EC2ServiceImplTest extends TestCase{
	public void testShutdown(){
		EC2ServiceInput json = new EC2ServiceInput();
		json.setAccessKey("AKIAIBCKC7U7KFRUZ3ZA");
		json.setSecretKey("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");
//		json.setTopicArn("arn:aws:sns:ap-northeast-1:960795461263:topic");
		json.setUseKey(true);
		String result = new EC2ServiceImpl ().shutdown(json, null);
		assertEquals("200", result);
		
	}
}
