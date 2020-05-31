package com.softserve.edu.greencity.rest.data;
public enum IgnoreError404 {

	SOME_MESSAGE("?");

	private String message;

	private IgnoreError404(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}