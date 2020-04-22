package com.softserve.edu.greencity.pages.guest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.softserve.edu.greencity.data.Languages;

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
		closeAlertIfPresent();
		initElements();
	}
	
	private void closeAlertIfPresent() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//driver.switchTo().alert().accept();
		//Duration duration = Duration.ofSeconds(1);
		Duration duration = Duration.ofMillis(20L);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(duration)
	            .ignoring(TimeoutException.class);
		Alert alert = null;
		try {
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch(TimeoutException e) {
		}
		if(alert != null) {
			//driver.switchTo().alert().accept();
			alert.accept();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	private void initElements() {
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

	protected void setLanguageSwitcher(String text) {
		getLanguageSwitcher().selectByVisibleText(text);
	}

	protected void clickLanguageSwitcher() {
		getLanguageSwitcherWebElement().click();
	}

	// mainMenuDropdown
	
	public MainMenuDropdown getMainMenuDropdown() {
		return mainMenuDropdown;
	}
	
	// Functional

	protected void chooseLanguage(Languages language) {
		clickLanguageSwitcher();
		setLanguageSwitcher(language.toString());
	}
	
	// Business Logic
	
	public HomePage gotoHomePage() {
		getMainMenuDropdown().clickMenuHome();
		return new HomePage(driver);
	}

	public EconewsPage gotoEconewsPage() {
		getMainMenuDropdown().clickMenuEcoNews();
		return new EconewsPage(driver);
	}
}
