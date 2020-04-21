package com.softserve.edu.greencity.pages.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainMenuDropdown {

	private WebDriver driver;
	//
	private WebElement naviconButton;
	private WebElement menuHome;

	public MainMenuDropdown(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
		naviconButton = driver.findElement(By.cssSelector("span.navicon"));
		menuHome = driver.findElement(By.cssSelector("label.menu-icon + ul > li:first-child > a[href*='welcome']"));
	}

	// Page Object
	
	// naviconButton
	public WebElement getNaviconButton() {
        return naviconButton;
    }

    public String getNaviconButtonText() {
        return getNaviconButton().getText();
    }

    public void clickNaviconButton() {
        getNaviconButton().click();
    }
    
    public boolean isDisplayedNaviconButton() {
        return getNaviconButton().isDisplayed();
    }
    
    // menuHome
    
    public WebElement getMenuHome() {
        return menuHome;
    }

    public String getMenuHomeText() {
        return getMenuHome().getText();
    }

    public void clearMenuHome() {
        getMenuHome().clear();
    }

    public void clickMenuHome() {
    	getMenuHome().click();
    }

    public boolean isDisplayedMenuHome() {
        return getMenuHome().isDisplayed();
    }
    
	// Functional

	// Business Logic
}
