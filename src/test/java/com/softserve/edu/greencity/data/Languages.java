package com.softserve.edu.greencity.data;

public enum Languages {
	UKRAINIAN("Укр"),
	RUSSIAN("Рус"),
	ENGLISH("Eng");
	//
	private String name;

	private Languages(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
