package com.softserve.edu.greencity.rest.entity;

public class Error400Entity {
	private String name;
	private String message;
	//
	private int responsecode;

	public Error400Entity(String name, String message, int responsecode) {
		this.name = name;
		this.message = message;
		this.responsecode = responsecode;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public int getResponsecode() {
		return responsecode;
	}

	@Override
	public String toString() {
		return "Error400Entity [name=" + name
				+ ", message=" + message
				+ ", responsecode=" + responsecode
				+ "]";
	}

	
}
