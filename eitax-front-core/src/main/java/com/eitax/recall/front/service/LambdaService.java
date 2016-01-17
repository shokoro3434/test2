package com.eitax.recall.front.service;

import java.util.List;
import java.util.Map;

import com.eitax.recall.front.domain.Lambda;
import com.eitax.recall.front.domain.Profile;

public interface LambdaService {
	public List<Lambda> retrieveLambda(Profile p);
	public Map<String,String> retrieveLambdaList(Profile p);

	public String invoke(String accessKey,String secretKey,String sender,String arn,String payload);
	public String update(String accessKey,String secretKey,String arn,String payload);
	public Map<String, String> create(String accessKey,String secretKey,String payload);
	public Map<String,String> requestSchedule(String accessKey,String secretKey,String email,String payload);
	public Map<String, String> delete(String accessKey,String secretKey,String arn);

}
