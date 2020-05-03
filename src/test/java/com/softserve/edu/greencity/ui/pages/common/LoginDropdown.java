package com.softserve.edu.greencity.ui.pages.common;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;
import com.softserve.edu.greencity.ui.tools.ForgotPasswordPart;
import com.softserve.edu.greencity.ui.tools.LoginPart;
import com.softserve.edu.greencity.ui.tools.RegisterPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDropdown extends LoginPart {

	private final String EMAIL_ID = "email";
	private final String PASSWORD_ID = "password";
	private final String LOGIN_BUTTON_XPATH = "//button[@type='submit' and @class='primary-global-button']";
	private final String GOOGLE_LOGIN_BUTTON_CLASS = "google-sign-in";
	private final String FORGOT_PASSWORD_LINK_CLASS = "forgot-password";
	private final String REGISTRATION_LINK_CLASS = "sign-up-link";
	private final String CLOSE_BUTTON_CLASS = "cross-btn";

	private WebElement closeButton;
	private WebElement signUpLink;

	private WebDriver driver;

	public LoginDropdown(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	public LoginDropdown setCloseButton(WebElement closeButton) {
		this.closeButton = closeButton;
		return this;
	}

	public LoginDropdown setSignUpLink(WebElement signUpLink) {
		this.signUpLink = signUpLink;
		return this;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getSignUpLink() {
		return signUpLink;
	}

	private void initElements() {
		this.setCloseButton(driver.findElement(By.className(CLOSE_BUTTON_CLASS)))
				.setSignUpLink(driver.findElement(By.className(REGISTRATION_LINK_CLASS)))
				.setEmailField(driver.findElement(By.id(EMAIL_ID)))
				.setPasswordField(driver.findElement(By.id(PASSWORD_ID)))
				.setSignInButton(driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)))
				.setGoogleSignInButton(driver.findElement(By.className(GOOGLE_LOGIN_BUTTON_CLASS)))
				.setForgotPasswordLink(driver.findElement(By.className(FORGOT_PASSWORD_LINK_CLASS)));
	}

	public TipsTricksPage closeDropdown(){
		getCloseButton().click();
		return new TipsTricksPage(driver);
	}

	@Override
	public ForgotPasswordPart gotoForgotPassword() {
		forgotPasswordLink.click();
		return new ForgotPasswordDropdown(driver);
	}


	public RegisterDropdown gotoRegisterDropdown() {
		getSignUpLink().click();
	    return new RegisterDropdown(driver);
	}
}
