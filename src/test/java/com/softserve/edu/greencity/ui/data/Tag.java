package com.softserve.edu.greencity.ui.data;

import org.openqa.selenium.WebElement;

public enum Tag {
	
	NEWS("news"), 
	EVENTS("events"), 
	COURCES("courses"), 
	INITIATIVES("initiatives"), 
	ADS("ads");
	
	private String nameOfTag;
	
	private Tag(String nameOfTag) {
		this.nameOfTag = nameOfTag;
	}
	
	@Override
	public String toString() {
		return nameOfTag;
	}
	
	
}
