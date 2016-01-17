package com.eitax.recall.front.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "settings.lambda")
public class LambdaSettings {
	private String role;
	private String ec2Handler;
	private String rdsHandler;
	private String s3Backet;
	private String s3Key;
}
