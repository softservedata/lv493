package com.softserve.edu.greencity.ui.data;

public abstract class MapData {
	private String name;
	public static String requestStr="pravda";
	public static String requestInt="10";
	private MapData (String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
