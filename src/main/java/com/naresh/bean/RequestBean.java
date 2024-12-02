package com.naresh.bean;

public class RequestBean {
	private int requestId, userId, softwareId;
	private String accessType, reason, status;
	
	public RequestBean() {}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSoftwareId() {
		return softwareId;
	}

	public void setSoftwareId(int softwareId) {
		this.softwareId = softwareId;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RequestBean [requestId=" + requestId + ", userId=" + userId + ", softwareId=" + softwareId
				+ ", accessType=" + accessType + ", reason=" + reason + ", status=" + status + "]";
	}	
}
