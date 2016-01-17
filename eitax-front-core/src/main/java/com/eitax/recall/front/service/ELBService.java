package com.eitax.recall.front.service;

import java.util.Map;

public interface ELBService {
	public Map<String,String> describeLoadBalancers(String profileName,String region);

}
