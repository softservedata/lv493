package com.softserve.edu.greencity.rest.data;

public enum IgnoreError400 {

	BAD_PASSWORD("Bad password"),
	BAD_EMAIL("The user does not exist by this email"),
	BLANK_FIELD("must not be blank"),
	ALREADY_REGISTERED("User with this email is already registered");

	private String message;

	private IgnoreError400(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
