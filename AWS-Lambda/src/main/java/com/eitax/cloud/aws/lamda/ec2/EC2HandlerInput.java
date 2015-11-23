package com.eitax.cloud.aws.lamda.ec2;

import lombok.Data;

@Data
public class EC2HandlerInput {
	private String instanceId;
	private String accessKey;
	private String secretKey;
	private boolean useKey;
}
