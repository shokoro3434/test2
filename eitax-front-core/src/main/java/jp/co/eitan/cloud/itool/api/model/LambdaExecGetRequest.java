package jp.co.eitan.cloud.itool.api.model;

import lombok.Data;

@Data
public class LambdaExecGetRequest {
	private String description;
	private String arn;
}
