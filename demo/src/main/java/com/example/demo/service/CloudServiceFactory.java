package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.common.Constants;
import com.example.demo.common.ExceptionMessage;

@Component
public class CloudServiceFactory {
	
	@Autowired
	@Qualifier("awsServiceImpl")
	private CloudService awsService;
	
	public CloudService getService(String cloudProvider) throws Exception {
		if(Constants.AWS_CLOUD_PROVIDER.equalsIgnoreCase(cloudProvider)) {
			return awsService;
		}
		//add more provider 
		throw new Exception(ExceptionMessage.INVALID_CLOUD_PROVIDER);
		
		
	}

}
