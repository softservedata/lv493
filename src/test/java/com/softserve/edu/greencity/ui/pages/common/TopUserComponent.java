package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopUserComponent {
	private final String TAG_ATTRIBUTE_CLASS = "class";
	//
	private WebDriver driver;
	//
	private WebElement profileButton;
	private WebElement userNameButton;

	public TopUserComponent(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
		profileButton = driver.findElement(By.cssSelector("div#user-avatar-wrapper > ul"));
		userNameButton = driver.findElement(By.cssSelector("div#user-avatar-wrapper li.tertiary-global-button > a"));
	}

	// Page Object

	// profileButton

	public WebElement getProfileButton() {
		return profileButton;
	}

	// userNameButton

	public WebElement getUserNameButton() {
		return userNameButton;
	}

	public String getUserNameButtonText() {
		return getUserNameButton().getText();
	}

	public void clickUserNameButton() {
		getUserNameButton().click();
	}

	public boolean isDisplayedUserNameButton() {
		return getUserNameButton().isDisplayed();
	}

	// Functional

	public boolean isExpanded() {
		return getProfileButton().getAttribute(TAG_ATTRIBUTE_CLASS)
				.equals("add-shadow");
	}
	
	//public void openProfile
	
	// Business Logic
}