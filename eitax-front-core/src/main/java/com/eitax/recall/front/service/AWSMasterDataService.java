package com.eitax.recall.front.service;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;


public interface AWSMasterDataService {
	public Map<String,String> retrieveRegions ();
	public Map<String,String> retrieveLambdaTriggers ();
	public Map<String,String> retrieveActions ();
	public Map<String,String> retrieveActions (String filter);
	public Map<String,String> retrieveAwsNames ();
	public Map<String,String> retrieveAwsNames (String filter);
	public Map<String,String> retrieveCronTypes ();
	public Map<String,String> retrieveIpProtocols ();
	public JsonNode retrieveActionSysRel ();
}
