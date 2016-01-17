package com.eitax.recall.front.service;

import java.util.Map;

public interface RDSService {
	public Map<String,String> describeInstances(String profileName,String region);
	public Map<String,String> describeSnapshots(String profileName,String region);
}
