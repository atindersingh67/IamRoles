package com.example.demo.model;

public class Resource {

	private String resourceType;
	private String resourceName;
	private String resourceId;
	private String creationDate;

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Resource(String resourceType, String resourceName, String resourceId, String creationDate) {
		super();
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.resourceId = resourceId;
		this.creationDate = creationDate;
	}

}
