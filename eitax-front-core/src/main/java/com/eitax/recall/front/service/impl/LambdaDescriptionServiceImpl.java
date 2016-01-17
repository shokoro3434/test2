package com.eitax.recall.front.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.ClientConfiguration;
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
import com.eitax.recall.front.domain.LambdaDescription;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.LambdaDescriptionService;

@Service
public class LambdaDescriptionServiceImpl implements LambdaDescriptionService {

	@Override
	public void register(String functionName, String description) {
		AmazonDynamoDB client = null;
		if (System.getProperty("useProxy") != null){
			ClientConfiguration conf = new ClientConfiguration()
					.withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword"));
			client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider(),conf);
		}
		else{
			client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider());
		}

		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		LambdaDescription rec = new LambdaDescription();
		rec.setFunctionName(functionName);
		rec.setDescription(description);
		mapper.save(rec);    
	}

	@Override
	public void update(String functionName, String description) {
		AmazonDynamoDB client = null;
		if (System.getProperty("useProxy") != null){
			ClientConfiguration conf = new ClientConfiguration()
					.withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword"));
			client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider(),conf);
		}
		else{
			client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider());
		}
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		LambdaDescription ld = this.findOne(functionName);
		ld.setDescription(description);
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		mapper.save(ld);
	}

	@Override
	public void delete(String functionName, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LambdaDescription findOne(String functionName) {
		// TODO Auto-generated method stub
		AmazonDynamoDB client = null;
		if (System.getProperty("useProxy") != null){
			ClientConfiguration conf = new ClientConfiguration()
					.withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword"));
			client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider(),conf);
		}
		else{
			client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider());
		}

		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		DynamoDBMapper mapper = new DynamoDBMapper(client);
	    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	    Map<String, Condition> scanFilter = new HashMap<String, Condition>();
	    Condition scanCondition = new Condition()
		        .withComparisonOperator(ComparisonOperator.EQ)
		        .withAttributeValueList(new AttributeValue().withS(functionName));
	    scanFilter.put("function_name", scanCondition);
	    scanExpression.setScanFilter(scanFilter);
	    for (LambdaDescription ld : mapper.scan(LambdaDescription.class,scanExpression)){
	    	return ld;
	    }
		return null;
	}
	@Override
	public List<LambdaDescription> findAll() {
		// TODO Auto-generated method stub
		AmazonDynamoDB client = null;
		if (System.getProperty("useProxy") != null){
			ClientConfiguration conf = new ClientConfiguration()
					.withProxyHost(System.getProperty("proxyHost"))
					.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
					.withProxyUsername(System.getProperty("proxyUsername"))
					.withProxyPassword(System.getProperty("proxyPassword"));
			client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider(),conf);
		}
		else{
			client = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider());
		}

		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		DynamoDBMapper mapper = new DynamoDBMapper(client);
	    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	    Map<String, Condition> scanFilter = new HashMap<String, Condition>();
	    Condition scanCondition = new Condition();
//		        .withComparisonOperator(ComparisonOperator.EQ)
//		        .withAttributeValueList(new AttributeValue().withS(functionName));
//	    scanFilter.put("function_name", scanCondition);
	    scanExpression.setScanFilter(scanFilter);
	    return mapper.scan(LambdaDescription.class,scanExpression);
	}

}
