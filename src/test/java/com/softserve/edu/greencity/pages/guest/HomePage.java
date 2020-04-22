package com.softserve.edu.greencity.pages.guest;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.data.Languages;

public class HomePage extends TopPart {

	public HomePage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
	}

	// Page Object

	// Functional

	// Business Logic
	
	public HomePage switchLanguage(Languages language) {
		chooseLanguage(language);
		return new HomePage(driver);
	}
}
