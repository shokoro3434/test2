package com.eitax.cloud.aws.lamda.ec2;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusRequest;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusResult;
import com.amazonaws.services.ec2.model.InstanceStatus;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class EC2Handler {
	
    public EC2HandlerResult shutdown(EC2HandlerInput json, Context context) {
        //LambdaLogger logger = context.getLogger();
//        logger.log("received : " + json);
        
    	AmazonEC2Client ec2 = null;
    	if (json.isUseKey()){
    		AWSCredentials credentials = new BasicAWSCredentials(json.getAccessKey(), json.getSecretKey());
            ec2 = new AmazonEC2Client(credentials);
            ec2.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
    	}
    	else{
            ec2 = new AmazonEC2Client();
            ec2.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
    	}
    	
        DescribeInstanceStatusRequest req = new DescribeInstanceStatusRequest()
                .withInstanceIds(json.getInstanceId());
        DescribeInstanceStatusResult res = ec2.describeInstanceStatus(req);
        long c = res.getInstanceStatuses()
        		.stream()
        		.filter(st -> st.getInstanceState().getName().equals("running"))
        		.filter(st->st.getInstanceStatus().getStatus().equals("ok"))
        		.filter(st->st.getSystemStatus().getStatus().equals("ok"))
        		.count();
        System.out.println(c);		
        for (InstanceStatus status : res.getInstanceStatuses()) {
            System.out.println(status.getInstanceState());
            System.out.println(status.getInstanceStatus());
            System.out.println(status.getSystemStatus());
        }
        StopInstancesRequest sir = new StopInstancesRequest().withInstanceIds(json.getInstanceId());
        ec2.stopInstances(sir);

        EC2HandlerResult result = new EC2HandlerResult ();
        result.setCode(0);
        return result;
    }

}
