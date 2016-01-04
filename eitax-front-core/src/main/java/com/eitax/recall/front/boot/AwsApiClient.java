package com.eitax.recall.front.boot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusRequest;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusResult;
import com.amazonaws.services.ec2.model.InstanceStatus;

//@Component
public class AwsApiClient implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello CLR");
		
//		ClientConfiguration conf = new ClientConfiguration();
//		conf.setProxyHost("192.168.99.200");
//		conf.setProxyPort(8000);
		
//        AmazonEC2Client ec2 = Region.getRegion(Regions.AP_NORTHEAST_1)
//                .createClient(AmazonEC2Client.class, null, null);
//        DescribeInstanceStatusRequest req = new DescribeInstanceStatusRequest()
//                .withInstanceIds("i-2fa0068a");
//        DescribeInstanceStatusResult res = ec2.describeInstanceStatus(req);
//        long c = res.getInstanceStatuses()
//        		.stream()
//        		.filter(st -> st.getInstanceState().getName().equals("running"))
//        		.filter(st->st.getInstanceStatus().getStatus().equals("ok"))
//        		.filter(st->st.getSystemStatus().getStatus().equals("ok"))
//        		.count();
//        System.out.println(c);		
//        for (InstanceStatus status : res.getInstanceStatuses()) {
//            System.out.println(status.getInstanceState());
//            System.out.println(status.getInstanceStatus());
//            System.out.println(status.getSystemStatus());
//        }
        //TerminateInstancesRequest terminateRequest = new TerminateInstancesRequest(Arrays.asList("i-2fa0068a"));
        //ec2.terminateInstances(terminateRequest);
    }

}
