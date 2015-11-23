package com.eitax.cloud.aws.lamda.sns;

import lombok.Data;

@Data
public class SNSHandlerInput {
	private String accessKey;
	private String secretKey;
	private String topicArn;
	private boolean useKey;
}
