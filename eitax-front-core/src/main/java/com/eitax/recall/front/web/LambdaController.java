package com.eitax.recall.front.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.FunctionConfiguration;
import com.amazonaws.services.lambda.model.GetFunctionConfigurationRequest;
import com.amazonaws.services.lambda.model.GetFunctionConfigurationResult;
import com.amazonaws.services.lambda.model.GetFunctionRequest;
import com.amazonaws.services.lambda.model.GetFunctionResult;
import com.amazonaws.services.lambda.model.ListFunctionsResult;
import com.eitax.recall.front.domain.Lambda;
import com.eitax.recall.front.domain.Profile;

import jp.co.eitan.cloud.itool.api.model.ApiProfile;

@Controller
@RequestMapping("lambda")
public class LambdaController {
	@Autowired
	private ApiProfile apiProfile;

    @ModelAttribute
    CustomerForm setUpForm() {
        return new CustomerForm();
    }
	public Profile findProfile(){
		ClientConfiguration conf = new ClientConfiguration();
		AmazonDynamoDB client = new AmazonDynamoDBClient(conf);
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		
		
		client.setEndpoint("https://dynamodb.ap-northeast-1.amazonaws.com");

		DynamoDBMapper mapper = new DynamoDBMapper(client);
	    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

	    Map<String, Condition> scanFilter = new HashMap<String, Condition>();
	    Condition scanCondition = new Condition()
		        .withComparisonOperator(ComparisonOperator.EQ)
		        .withAttributeValueList(new AttributeValue().withS("user2"));
	    scanFilter.put("profile_name", scanCondition);
	    scanExpression.setScanFilter(scanFilter);
        
	    for (Profile p : mapper.scan(Profile.class,scanExpression)){
	    	System.out.println(p.getAccessKey());
	    	System.out.println(p.getSecretKey());
	    	return p;
	    }
	    return null;
	}

	private List<Lambda> findLambdaList(Profile p){
		ClientConfiguration conf = new ClientConfiguration();
		AWSLambda client = new AWSLambdaClient(new BasicAWSCredentials(p.getAccessKey(),p.getSecretKey()),conf);
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		
		List<Lambda> ret = new ArrayList<Lambda>();
		ListFunctionsResult result = client.listFunctions();
		for (FunctionConfiguration fc : result.getFunctions()){
			String arn = fc.getFunctionArn();
			System.out.println(arn);
			try{
				//System.out.println("policy : "+client.getPolicy(new GetPolicyRequest().withFunctionName(arn)).getPolicy());
				GetFunctionResult gfr = client.getFunction(new GetFunctionRequest().withFunctionName(arn));
				GetFunctionConfigurationResult gfcr = client.getFunctionConfiguration(new GetFunctionConfigurationRequest().withFunctionName(arn));
				
				Lambda lambda = new Lambda ();
				lambda.setArn(gfcr.getFunctionArn());
				lambda.setDescription(gfcr.getDescription());
				ret.add(lambda);
			}
			catch(Exception e){
				//e.printStackTrace();
			}
		}
		return ret;
	}
	
    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        Profile profiile = findProfile();
        List<Lambda> lambdaList = this.findLambdaList(profiile);
        System.err.println(lambdaList);
        this.apiProfile.setAccessKey(profiile.getAccessKey());
        this.apiProfile.setSecretKey(profiile.getSecretKey());
        return "customers/list";
    }



}
