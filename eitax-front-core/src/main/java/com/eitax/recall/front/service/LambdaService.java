package com.eitax.recall.front.service;

import java.util.List;

import com.eitax.recall.front.domain.Lambda;
import com.eitax.recall.front.domain.Profile;

public interface LambdaService {
	public List<Lambda> retrieveLambda(Profile p);

}
