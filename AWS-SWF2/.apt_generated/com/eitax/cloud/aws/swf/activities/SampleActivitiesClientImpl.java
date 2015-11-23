/**
 * This code was generated from {@link com.eitax.cloud.aws.swf.activities.SampleActivities}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.eitax.cloud.aws.swf.activities;

import com.amazonaws.services.simpleworkflow.flow.ActivitiesClientBase;
import com.amazonaws.services.simpleworkflow.flow.ActivitySchedulingOptions;
import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericActivityClient;
import com.amazonaws.services.simpleworkflow.model.ActivityType;

public class SampleActivitiesClientImpl extends ActivitiesClientBase implements SampleActivitiesClient {

	public SampleActivitiesClientImpl() {
        this(null, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public SampleActivitiesClientImpl(GenericActivityClient genericClient) {
        this(genericClient, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }
    
    public SampleActivitiesClientImpl(GenericActivityClient genericClient, 
            DataConverter dataConverter, ActivitySchedulingOptions schedulingOptions) {
            
        super(genericClient, dataConverter, schedulingOptions);
    }
    
    @Override
    public final Promise<Void> activity() {
        return activityImpl((ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> activity(Promise<?>... waitFor) {
        return activityImpl((ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> activity(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return activityImpl(optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> activityImpl(final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType activityType = new ActivityType();
		activityType.setName("example.SNSActivities.notifyOperationComplete");
		activityType.setVersion("2.0");

        Promise[] _input_ = new Promise[0];

        return (Promise)scheduleActivity(activityType, _input_, optionsOverride, Void.class, waitFor);
    }

}