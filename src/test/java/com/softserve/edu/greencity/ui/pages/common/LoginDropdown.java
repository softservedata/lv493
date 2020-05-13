package com.softserve.edu.greencity.ui.pages.common;

import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

import java.util.List;
import java.util.stream.Collectors;

public class LoginDropdown extends LoginPart {

	private final String EMAIL_XPATH = "//input[@id='email' and contains(@class,'successful-email-validation')]";
	private final String PASSWORD_XPATH = "//div[@class='password-input-btn-show-hide successful-password-validation']/input[@id='password']";
	private final String LOGIN_BUTTON_XPATH = "//button[@class='primary-global-button']";
	private final String GOOGLE_LOGIN_BUTTON_CLASS = "google-sign-in";
	private final String FORGOT_PASSWORD_LINK_CLASS = "forgot-password";
	private final String REGISTRATION_LINK_CLASS = "a.sign-up-link";
	private final String CLOSE_BUTTON_CLASS = "cross-btn";
	private final String ERROR_MASSAGE_CLASS = "alert-general-error ng-star-inserted";

	private WebElement closeButton;

	public LoginDropdown(WebDriver driver) {
		super(driver);
		initElements();
	}

	@Override
	public List<String> getErrorMassages() {
		return driver.findElements(By.className(ERROR_MASSAGE_CLASS))
				.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	private void initElements() {
		this.setCloseButton(driver.findElement(By.className(CLOSE_BUTTON_CLASS)))
				.setSignUpLink(driver.findElement(By.cssSelector(REGISTRATION_LINK_CLASS)))
				.setEmailField(driver.findElement(By.xpath(EMAIL_XPATH)))
				.setPasswordField(driver.findElement(By.xpath(PASSWORD_XPATH)))
				.setSignInButton(driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)))
				.setGoogleSignInButton(driver.findElement(By.className(GOOGLE_LOGIN_BUTTON_CLASS)))
				.setForgotPasswordLink(driver.findElement(By.className(FORGOT_PASSWORD_LINK_CLASS)));
	}

	private LoginDropdown setCloseButton(WebElement element) {
		this.closeButton = element;
		return this;
	}

	//Business Logic


	@Override
	public TopPart successfullyLogin(User user) {
		fillFieldsSubmit(user);
		return new TipsTricksPage(driver);
	}

	public LoginPage closeDropdown(){
		getCloseButton().click();
		return new LoginPage(driver);
	}

	public RegisterDropdown gotoRegisterDropdown() {
		getSignUpLink().click();
		return new RegisterDropdown(driver);
	}



}