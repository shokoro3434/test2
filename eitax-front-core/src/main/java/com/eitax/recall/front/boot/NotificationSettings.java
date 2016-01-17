package com.eitax.recall.front.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "settings.notification.invoke")
public class NotificationSettings {
	private String email;
	private String subject;
	private String template;
}
