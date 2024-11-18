package com.example.demo.common;

public class Constants {

	public static final String AWS_CLOUD_PROVIDER = "aws";
	
	public static final String CSV_FILE_NAME = "resource.csv";
	
	public static final String IDENTETY_TYPE= "Identity";
	public static final String ROLE_TYPE= "Identity";
	
	public enum ResourceType {
		IDENTITY("identity"),
		ROLE("role"),
		GROUP("group"),
		POLICY("Policy");
		
		private final String value;
		ResourceType(String value){
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}

}
