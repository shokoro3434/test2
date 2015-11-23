package com.eitax.cloud.aws.swf.workflow;

import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

@Workflow
@WorkflowRegistrationOptions(defaultExecutionStartToCloseTimeoutSeconds = 100)
public interface SampleWorkflow {

	@Execute(version = "2.0", name = "example.GrayScaleConvertWorkflow.execute")
	public void workflow();
}
