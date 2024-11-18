package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;



@Configuration
public class AwsConfig {
	
	//Should pick credentials from env variable 
	@Bean
	public IamClient iamClient() {
		Region region = Region.AWS_GLOBAL;
		 IamClient iam = IamClient.builder()
	                .region(region)
	                .build();
		return iam;
	}

}
