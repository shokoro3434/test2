package com.eitax.recall.front.service;

import java.util.List;

import com.eitax.recall.front.domain.LambdaDescription;

public interface LambdaDescriptionService {
	public void register(String functionName,String description);
	public void update(String functionName,String description);
	public void delete(String functionName,String description);
	public LambdaDescription findOne(String functionName);
	public List<LambdaDescription> findAll();

}
