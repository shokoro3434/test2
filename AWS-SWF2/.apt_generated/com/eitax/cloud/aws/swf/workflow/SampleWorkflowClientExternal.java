/**
 * This code was generated from {@link com.eitax.cloud.aws.swf.workflow.SampleWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.eitax.cloud.aws.swf.workflow;

import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClientExternal;

public interface SampleWorkflowClientExternal extends WorkflowClientExternal
{
    void workflow();
    void workflow(StartWorkflowOptions optionsOverride);
}