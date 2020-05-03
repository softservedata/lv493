package com.softserve.edu.greencity.ui.data;

public enum Tag {
	
	NEWS("News"),
	EVENTS("Events"),
	COURCES("Courses"),
	INITIATIVES("Initiatives"),
	ADS("Ads");
	
	private String nameOfFilter;
	
	private Tag(String nameOfFilter) {
		this.nameOfFilter = nameOfFilter;
	}
	
	@Override
	public String toString() {
		return nameOfFilter;
	}
	
	
}
