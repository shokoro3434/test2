package com.eitax.cloud.aws.swf.boot;

import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.eitax.cloud.aws.swf.host.AWSUtils;
import com.eitax.cloud.aws.swf.workflow.SampleWorkflowClientExternal;
import com.eitax.cloud.aws.swf.workflow.SampleWorkflowClientExternalFactory;
import com.eitax.cloud.aws.swf.workflow.SampleWorkflowClientExternalFactoryImpl;

public class ExecutionStarter {

	public static void main(String[] args) {
		AmazonSimpleWorkflow swf = AWSUtils.swfClient();
		SampleWorkflowClientExternalFactory factory = new SampleWorkflowClientExternalFactoryImpl(
				swf, AWSUtils.getSWFDomainName());
		SampleWorkflowClientExternal external = factory.getClient();

		external.workflow();
	}
	
  public static void main2(String[] args) {
    String domain = "sample-maven";
    if (args.length > 0) {
      domain = args[0];
    }

    AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(new AWSCredentialsProviderChain(new InstanceProfileCredentialsProvider(), new ClasspathPropertiesFileCredentialsProvider()));

    SampleWorkflowClientExternalFactory factory = new SampleWorkflowClientExternalFactoryImpl(service, domain);
    SampleWorkflowClientExternal sampleWorkflowClientExternal = factory.getClient();
    sampleWorkflowClientExternal.workflow();
  }
}
