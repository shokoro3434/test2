package com.eitax.recall.front.domain;

import lombok.Data;

@Data
public class Lambda {
	private String jobName;
	private String triggerName;
	private String description;
	private String arn;
	private String modalId;
}
