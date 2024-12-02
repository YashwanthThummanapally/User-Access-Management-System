package com.naresh.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SoftwareBean implements Serializable {
	private int softwareId;
	private String softwareName, description, accessLevels;
	
	public SoftwareBean() {}

	public int getSoftwareId() {
		return softwareId;
	}

	public void setSoftwareId(int softwareId) {
		this.softwareId = softwareId;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccessLevels() {
		return accessLevels;
	}

	public void setAccessLevels(String accessLevels) {
		this.accessLevels = accessLevels;
	}	
}
