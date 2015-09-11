package com.eitax.recall.amazon.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eitax.recall.amazon.dao.AwsApiCallDAO;
import com.eitax.recall.amazon.model.AwsApi;
import com.eitax.recall.amazon.model.AwsApiCall;
import com.eitax.recall.amazon.repository.AwsApiCallRepository;


@Component
public class AwsApiCallDAOImpl implements AwsApiCallDAO {
    @Autowired
    private AwsApiCallRepository awsApiCallRepository;

	@Override
	public List<AwsApiCall> findByCallYyyymmdd(String yyyymmdd){
		return awsApiCallRepository.findByCallYyyymmdd(yyyymmdd);
	}

	@Override
	public AwsApiCall save(AwsApiCall aac) {
		// TODO Auto-generated method stub
		return awsApiCallRepository.save(aac);
	}

	@Override
	public void update(Integer awsApiCallId, Integer cnt) {
		// TODO Auto-generated method stub
		awsApiCallRepository.update(awsApiCallId, cnt);
	}

}
