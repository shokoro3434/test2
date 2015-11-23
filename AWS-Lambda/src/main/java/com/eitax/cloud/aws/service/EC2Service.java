package com.eitax.cloud.aws.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.eitax.cloud.aws.service.impl.EC2ServiceInput;

public interface EC2Service {
	public String shutdown(EC2ServiceInput json,Context ctx);
}
