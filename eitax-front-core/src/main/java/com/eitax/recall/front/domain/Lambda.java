package com.eitax.recall.front.domain;

import lombok.Data;

@Data
public class Lambda {
	private String jobId;
	private String awsName;
	private String actionName;
	private String triggerName;
	private String description;
	private String arn;
	private String modalId;
	private String modModalId;
}
