package com.softserve.edu.greencity.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class TopPart {

	protected WebDriver driver;
	//
	private WebElement registerLink;
	private WebElement signinLink;
	private Select languageSwitcher;
	//
	private MainMenuDropdown mainMenuDropdown;
	private LoginDropdown loginDropdown;
	private RegisterDropdown registerDropdown;
	
	public TopPart(WebDriver driver) {
		this.driver = driver;
		initElements();
	}
	
	private void initElements() {
		// init elements
		registerLink = driver.findElement(By.cssSelector("span#text-before + span > a"));
		signinLink = driver.findElement(By.cssSelector("span#text-within + span > a"));
		languageSwitcher = new Select(driver.findElement(By.id("language-switcher")));
		mainMenuDropdown = new MainMenuDropdown(driver);
	}

	// Page Object
	
	// registerLink
	
	public WebElement getRegisterLink() {
        return registerLink;
    }

    public String getRegisterLinkText() {
        return getRegisterLink().getText();
    }
    
    public void clickRegisterLink() {
        getRegisterLink().click();
    }
    
	// signinLink
    
	public WebElement getSigninLink() {
        return signinLink;
    }

    public String getSigninLinkText() {
        return getSigninLink().getText();
    }
    
    public void clickSigninLink() {
        getSigninLink().click();
    }
    
	// languageSwitcher
    
    public Select getLanguageSwitcher() {
		return languageSwitcher;
	}

	public WebElement getLanguageSwitcherWebElement() {
		return getLanguageSwitcher().getWrappedElement();
	}

	public String getLanguageSwitcherText() {
		return getLanguageSwitcher().getFirstSelectedOption().getText();
	}

	public void setLanguageSwitcher(String text) {
		getLanguageSwitcher().selectByVisibleText(text);
	}

	public void clickLanguageSwitcher() {
		getLanguageSwitcherWebElement().click();
	}

	
	
	// Functional

	// Business Logic

}
