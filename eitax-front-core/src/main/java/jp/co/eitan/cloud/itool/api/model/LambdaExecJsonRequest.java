package jp.co.eitan.cloud.itool.api.model;

import javax.validation.Valid;

import com.eitax.recall.front.domain.LambdaJson;

import lombok.Data;

@Data
public class LambdaExecJsonRequest {
	@Valid
	private LambdaJson description;
	private String arn;
}
