package com.eitax.cloud.aws.service.impl;

import lombok.Data;

@Data
public class EC2ServiceInput {
	private String accessKey;
	private String secretKey;
	private String topicArn;
	private boolean useKey;
}
