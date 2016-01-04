package com.eitax.recall.front.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Override
	public Profile findOne(String profileName) {
		AmazonDynamoDB client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider());
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		client.setEndpoint("https://dynamodb.ap-northeast-1.amazonaws.com");
		DynamoDBMapper mapper = new DynamoDBMapper(client);
	    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	    Map<String, Condition> scanFilter = new HashMap<String, Condition>();
	    Condition scanCondition = new Condition()
		        .withComparisonOperator(ComparisonOperator.EQ)
		        .withAttributeValueList(new AttributeValue().withS(profileName));
	    scanFilter.put("profile_name", scanCondition);
	    scanExpression.setScanFilter(scanFilter);
	    for (Profile p : mapper.scan(Profile.class,scanExpression)){
	    	return p;
	    }
		return null;
	}

}
