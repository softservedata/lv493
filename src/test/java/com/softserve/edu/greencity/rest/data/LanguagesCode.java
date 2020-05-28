package com.softserve.edu.greencity.rest.data;

public enum LanguagesCode {
	UKRAINIAN("uk"),
	RUSSIAN("ru"),
	ENGLISH("en");
	//
	private String name;

	private LanguagesCode(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
