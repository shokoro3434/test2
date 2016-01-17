package com.eitax.recall.front.service;

import java.util.Map;

public interface EC2Service {
	public Map<String,String> describeInstances(String profileName,String region);
	public Map<String,String> describeImages(String profileName,String region);
	public Map<String,String> describeSnapshots(String profileName,String region);
	public Map<String,String> describeSG(String profileName, String region);
}
