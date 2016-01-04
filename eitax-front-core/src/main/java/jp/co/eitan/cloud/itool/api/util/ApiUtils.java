package jp.co.eitan.cloud.itool.api.util;

import java.util.StringTokenizer;

import com.eitax.recall.front.domain.LambdaJson;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.ogis.cloudtool.lambda.core.ec2.common.EC2Request;

public class ApiUtils {
	public static String toPayload(String description) {
		try{
			ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
			LambdaJson json = mapper.readValue(description, LambdaJson.class);
			EC2Request req = new EC2Request();
			req.setProfileName(json.getSystem().getEc2().getProfileName());
			req.setRegion(json.getSystem().getEc2().getRegion());
			req.setInstanceIds(json.getSystem().getEc2().getInstanceIds());
			return mapper.writeValueAsString(req);
		}
		catch(Exception e){
			
		}
		return null;
	}

	
}
