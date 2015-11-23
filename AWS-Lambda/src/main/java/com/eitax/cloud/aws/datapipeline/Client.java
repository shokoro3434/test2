package com.eitax.cloud.aws.datapipeline;

import java.util.Arrays;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.datapipeline.DataPipelineClient;
import com.amazonaws.services.datapipeline.model.ActivatePipelineRequest;
import com.amazonaws.services.datapipeline.model.ActivatePipelineResult;
import com.amazonaws.services.datapipeline.model.DeactivatePipelineRequest;
import com.amazonaws.services.datapipeline.model.DeactivatePipelineResult;
import com.amazonaws.services.datapipeline.model.SetStatusRequest;

public class Client {
	public static void main(String[] args) throws Exception {
		// ClasspathPropertiesFileCredentialsProvider()
		AWSCredentialsProvider credentialsProvider = null;
		try {
			credentialsProvider = new InstanceProfileCredentialsProvider();
			credentialsProvider.getCredentials();
		} catch (AmazonClientException e) {
			credentialsProvider = new ClasspathPropertiesFileCredentialsProvider();
			credentialsProvider.getCredentials();
		}
		DataPipelineClient client = new DataPipelineClient();
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));

		String id = "df-03426842S6ZZJSQ0L44I";

//		SetStatusRequest ssr = new SetStatusRequest();
//		ssr.setPipelineId("df-101492333QVVP0UNMMPE");
//		ssr.setStatus("RERUN");
//		ssr.setObjectIds(Arrays.asList(new String[]{}));
//		client.setStatus(ssr);

		ActivatePipelineRequest aplr = new ActivatePipelineRequest();
		aplr.setPipelineId(id);
		ActivatePipelineResult result = client.activatePipeline(aplr);
		System.out.println(result);
		
//		DeactivatePipelineRequest r = new DeactivatePipelineRequest();
//		r.setPipelineId("df-101492333QVVP0UNMMPE");
//		client.deactivatePipeline(r);
//		DeactivatePipelineResult result2 = client.deactivatePipeline(r);
//		System.out.println(result2);
		
		
	}

}
