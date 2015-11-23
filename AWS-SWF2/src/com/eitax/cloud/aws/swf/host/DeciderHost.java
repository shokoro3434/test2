package com.eitax.cloud.aws.swf.host;


import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import com.eitax.cloud.aws.swf.workflow.impl.SampleWorkflowImpl;

public class DeciderHost {
	public static void main(String[] args) throws Exception {
		AmazonSimpleWorkflow swf = AWSUtils.swfClient();
		WorkflowWorker worker = new WorkflowWorker(swf, AWSUtils.getSWFDomainName(), AWSUtils.getSWFTaskListName());
		worker.addWorkflowImplementationType(SampleWorkflowImpl.class);
		worker.start();
	}
}
