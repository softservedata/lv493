package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class LoginPage extends TopPart{

	private LoginComponent loginComponent;

	public LoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		loginComponent = new LoginComponent(driver);
	}

	public LoginComponent getLoginComponent() {
		return loginComponent;
	}

	// proxy methods

	public LoginPage inputEmail(String email) {
		this.getLoginComponent().getEmailField().sendKeys(email);
		return this;
	}

	public LoginPage inputPassword(String password) {
		this.getLoginComponent().getPasswordField().sendKeys(password);
		return this;
	}

	public LoginPage clickLoginButton() {
		this.getLoginComponent().getSignInButton().click();
		return this;
	}

	public LoginPage clickGoogleLoginButton() {
		this.getLoginComponent().getGoogleSigningButton().click();
		return this;
	}

}
