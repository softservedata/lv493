package com.softserve.edu.greencity.ui.pages.tipstricks;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class TipsTricksPage extends TopPart {

	public TipsTricksPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
	}

	// Page Object

	// Functional

	// Business Logic
	
	public TipsTricksPage switchLanguage(Languages language) {
		chooseLanguage(language);
		return new TipsTricksPage(driver);
	}
}
