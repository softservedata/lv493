package com.softserve.edu.greencity.rest.data.myhabits;

public enum HabitRate {
	BAD("BAD"),
	NORMAL("NORMAL"),
	GOOD("GOOD"),
	DEFAULT("DEFAULT");
	//
	private String name;

	private HabitRate(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
