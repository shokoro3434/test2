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
	@NotEmpty(message="JobIDは必須入力です。")
	@Size(max=4, message="JobIDは {max} 文字以内で入力してください。")
	private String jobId;
	@NotEmpty(message="AWSは必須入力です。")
	private String awsName;
	@NotEmpty(message="Actionは必須入力です。")
	private String actionName;
	@NotEmpty(message="Regionは必須入力です。")
	private String region;
	@NotEmpty(message="Triggerは必須入力です。")
	private String triggerName;
	private System system;
}
