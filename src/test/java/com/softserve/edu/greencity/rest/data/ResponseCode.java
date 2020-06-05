package com.softserve.edu.greencity.rest.data;

public enum ResponseCode {
	RESPONSE200(200);

	private int code;

	private ResponseCode(int code) {
		this.code = code;
	}

	public int getValue() {
        return code;
    }

}
