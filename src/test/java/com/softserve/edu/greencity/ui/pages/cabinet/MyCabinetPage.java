package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.pages.common.SmallHeightPart;

public class MyCabinetPage extends SmallHeightPart {

	public MyCabinetPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
	}

	// Page Object

	// Functional
	/**
	 * gotoLoginPage
	 * @return LoginPage
	 */
	public LoginPage gotoLoginPage() {
	    return new LoginPage(driver);
	}
	
	/**
	 * gotoRegisterPage
	 * @return RegisterPage
	 */
	public RegisterPage gotoRegisterPage() {
	    return new RegisterPage(driver);
	}

	// Business Logic
}