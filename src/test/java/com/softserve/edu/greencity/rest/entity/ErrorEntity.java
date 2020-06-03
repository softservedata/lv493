package com.softserve.edu.greencity.rest.entity;

public class ErrorEntity {
	private String timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	//
	private int responsecode;

	public ErrorEntity() {
		timestamp = "";
		status = -1;
		error = "";
		message = "";
		path = "";
		responsecode = -1;
	}
	
	public ErrorEntity(String timestamp, int status,
			String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	public ErrorEntity(String timestamp, int status,
			String error, String message, String path, int responsecode) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.responsecode = responsecode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public int getResponsecode() {
		return responsecode;
	}
	
	@Override
	public String toString() {
		return "ErrorEntity [timestamp=" + timestamp
				+ ", status=" + status
				+ ", error=" + error
				+ ", message=" + message
				+ ", path=" + path + "]";
	}

}
