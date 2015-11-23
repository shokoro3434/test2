/**
 * This code was generated from {@link com.eitax.cloud.aws.swf.activities.SampleActivities}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.eitax.cloud.aws.swf.activities;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.ActivitiesClient;
import com.amazonaws.services.simpleworkflow.flow.ActivitySchedulingOptions;

public interface SampleActivitiesClient extends ActivitiesClient
{
    Promise<Void> activity();
    Promise<Void> activity(Promise<?>... waitFor);
    Promise<Void> activity(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor);
}