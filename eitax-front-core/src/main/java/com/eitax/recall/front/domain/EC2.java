package com.eitax.recall.front.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EC2 {
	private String profileName;
	private String region;
	private List<String> instanceIds;
}
