package com.softserve.edu.greencity.rest.entity;

public class ResponseCodeEntity {

	private int responsecode;

	public ResponseCodeEntity() {
		responsecode = -1;
	}
	
	public ResponseCodeEntity(int responsecode) {
		this.responsecode = responsecode;
	}

	public int getResponsecode() {
		return responsecode;
	}

	@Override
	public String toString() {
		return "SimpleEntity [responsecode=" + responsecode + "]";
	}

}
