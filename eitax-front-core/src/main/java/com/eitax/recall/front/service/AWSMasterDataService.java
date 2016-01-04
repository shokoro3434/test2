package com.eitax.recall.front.service;

import java.util.Map;

public interface AWSMasterDataService {
	public Map<String,String> retrieveRegions ();
	public Map<String,String> retrieveLambdaTriggers ();
	public Map<String,String> retrieveActions ();
	public Map<String,String> retrieveAwsNames ();
}
