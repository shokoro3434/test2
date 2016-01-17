package com.eitax.recall.front.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sys {
	private String modalId;
	private String modModalId;
	private String rh;
	private String mail;
	private EC2 ec2;
	private RDS rds;
	private ELB elb;
	private EBS ebs;
	private SG sg;
}
