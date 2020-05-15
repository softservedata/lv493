package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class MyCabinetPage extends TopPart {
    private WebElement newHabit;
    
	public MyCabinetPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements

	   newHabit = driver.findElement(By.cssSelector("app-button"));
	}



 

	// Page Object
public WebElement getNewHabit() {
    return newHabit;
}

public boolean isDisplayedNewHabit() {
    return getNewHabit().isDisplayed();
}
	// Functional

	// Business Logic
}