package com.eitax.cloud.aws.swf.host;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.eitax.cloud.aws.swf.activities.impl.SampleActivitiesImpl;

public class ActivityHost {

	public static void main(String[] args) throws Exception {
		AmazonSimpleWorkflow swf = AWSUtils.swfClient();
		ActivityWorker worker = new ActivityWorker(swf, AWSUtils.getSWFDomainName(), AWSUtils.getSWFTaskListName());
		worker.addActivitiesImplementation(new SampleActivitiesImpl());
		worker.start();
	}
	
}
