package com.eitax.recall.front.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LambdaJson {
	@NotEmpty(message="JobIdは必須入力です。")
	@Size(max=4, message="JobIdは {max} 文字以内で入力してください。")
	private String jobId;
	@NotEmpty(message="AWSは必須入力です。")
	private String awsName;
	@NotEmpty(message="Actionは必須入力です。")
	private String actionName;
	@NotEmpty(message="Triggerは必須入力です。")
	private String triggerName;
	private Sys sys;
}
