package com.eitax.recall.front.domain;

import lombok.Data;

@Data
public class SG {
	private String profileName;
	private String region;
	private String groupId;
	private String ipProtocol;
	private int port;
	private String cidr;
}
