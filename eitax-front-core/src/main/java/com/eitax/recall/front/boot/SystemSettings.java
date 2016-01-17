package com.eitax.recall.front.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "settings")
public class SystemSettings {
	private String email;
	private String subject;
	private String cloudDivEmail;
	private String template;
}
