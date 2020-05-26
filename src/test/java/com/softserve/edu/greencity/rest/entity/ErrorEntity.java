package com.softserve.edu.greencity.rest.entity;

public class ErrorEntity {
	private String timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	private String name;
	private String responsecode;

	public ErrorEntity() {
		timestamp = "";
		status = -1;
		error = "";
		message = "";
		path = "";
		name = "";
	}
	
	public ErrorEntity(String timestamp, int status,
			String error, String message, String path, String name) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.name = name;
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
	
	public String getName() {
        return name;
    }

	@Override
	public String toString() {
		return "ErrorEntity [timestamp=" + timestamp
				+ ", status=" + status
				+ ", error=" + error
				+ ", message=" + message
				+ ", path=" + path 
				+ ", name=" + name + "]";
	}

}
