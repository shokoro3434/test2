package com.eitax.recall.front.boot;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class Finalizer implements ExitCodeGenerator{

	@Override
	public int getExitCode() {
		// TODO Auto-generated method stub
		int ret = 0;
		System.out.println("rt:"+ret);
		return ret;
	}
	
}
