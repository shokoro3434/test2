package com.eitax.recall.front.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class System {
	private String modalId;
	private String responseHandler;
	private String arn;
	private EC2 ec2;
}
