package com.softserve.edu.greencity.ui.data;

import org.openqa.selenium.WebElement;

public enum NewsFilter {
	
	NEWS("news"), 
	EVENTS("events"), 
	COURCES("courses"), 
	INITIATIVES("initiatives"), 
	ADS("ads");
	
	private String nameOfFilter;
	
	private NewsFilter(String nameOfFilter) {
		this.nameOfFilter = nameOfFilter;
	}
	
	@Override
	public String toString() {
		return nameOfFilter;
	}
	
	
}
