package com.eitax.cloud.aws.swf.workflow.impl;

import com.eitax.cloud.aws.swf.activities.SampleActivitiesClient;
import com.eitax.cloud.aws.swf.activities.SampleActivitiesClientImpl;
import com.eitax.cloud.aws.swf.workflow.SampleWorkflow;

public class SampleWorkflowImpl implements SampleWorkflow {

  private SampleActivitiesClient sampleActivitiesClient = new SampleActivitiesClientImpl();

  @Override
  public void workflow() {
    System.out.println("workflow called");
    sampleActivitiesClient.activity();
  }

}
