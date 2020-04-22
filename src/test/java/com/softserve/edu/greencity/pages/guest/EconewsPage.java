package com.softserve.edu.greencity.pages.guest;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.data.Languages;

public class EconewsPage extends TopPart {

	public EconewsPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
	}

	// Page Object

	// Functional

	// Business Logic

	public EconewsPage switchLanguage(Languages language) {
		chooseLanguage(language);
		return new EconewsPage(driver);
	}
}
