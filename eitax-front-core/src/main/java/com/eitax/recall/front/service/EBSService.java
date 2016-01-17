package com.eitax.recall.front.service;

import java.util.Map;

public interface EBSService {
	public Map<String,String> describeVolumes(String profileName,String region);

}
