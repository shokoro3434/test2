package com.eitax.recall.front.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@DynamoDBTable(tableName="lambda_description")
public class LambdaDescription {
	@DynamoDBAutoGeneratedKey
	@DynamoDBHashKey(attributeName = "lambda_description_id")
	private String lambdaDescriptionId;
	@DynamoDBAttribute(attributeName="function_name") 
	private String functionName;
	@DynamoDBAttribute(attributeName="description") 
	private String description;

}