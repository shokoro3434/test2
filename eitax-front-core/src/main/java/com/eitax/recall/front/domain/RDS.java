package com.eitax.recall.front.domain;

import lombok.Data;

@Data
public class RDS {
	private String profileName;
	private String instanceId;
	private String snapshotId;
	private String region;
}
