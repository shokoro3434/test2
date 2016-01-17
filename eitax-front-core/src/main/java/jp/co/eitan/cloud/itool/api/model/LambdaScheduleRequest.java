package jp.co.eitan.cloud.itool.api.model;

import lombok.Data;

@Data
public class LambdaScheduleRequest {
	private String jobId;
	private String time;
	private String cronType;
	private String note;
}
