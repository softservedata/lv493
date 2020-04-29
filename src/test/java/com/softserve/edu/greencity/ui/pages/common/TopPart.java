package com.softserve.edu.greencity.ui.pages.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;
import com.softserve.edu.greencity.ui.pages.econews.EconewsPage;

import com.softserve.edu.greencity.ui.pages.map.MapPage;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

/**
 * Base Abstract Class of Header and Footer.
 * @author Lv-493.Taqc/Java
 */
public abstract class TopPart {
	private final int WINDOW_WIDTH_TO_SCROLL = 1024;
	private final int WINDOW_HEIGHT_TO_CLICK_FOOTER = 480;
	//
    //protected final String TAG_ATTRIBUTE_VALUE = "value";
    //protected final String TAG_ATTRIBUTE_SRC = "src";
	//
	protected WebDriver driver;
	//
	private Select languageSwitcher;
	private WebElement copyright;
	//
	private MainMenuDropdown mainMenuDropdown;
	private TopGuestComponent topGuestComponent;
	private TopUserComponent topUserComponent;
	//
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
		languageSwitcher = new Select(driver.findElement(By.cssSelector("select.language-switcher")));
		mainMenuDropdown = new MainMenuDropdown(driver);
		copyright = driver.findElement(By.cssSelector("div.bottom-part"));
	}

	// Page Object
	
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

	// copyright

	public WebElement getCopyright() {
		return copyright;
	}

	public String getCopyrightText() {
		return getCopyright().getText();
	}

	public void clickCopyright() {
		getCopyright().click();
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
	
	protected void scrollDown() {
		//System.out.println("driver.manage().window().getSize()" + driver.manage().window().getSize());
		if (driver.manage().window().getSize().width < WINDOW_WIDTH_TO_SCROLL) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", getCopyright());
		}
	}
	
	protected boolean isMenuClickable() {
		return driver.manage().window().getSize().height > WINDOW_HEIGHT_TO_CLICK_FOOTER;
	}
	
	// Business Logic
	
	public EconewsPage navigateMenuEconews() {
		getMainMenuDropdown().clickMenuEcoNews();
		return new EconewsPage(driver);
	}
	
	public TipsTricksPage navigateMenuTipsTricks() {
		getMainMenuDropdown().clickMenuTipsTricks();
		return new TipsTricksPage(driver);
	}
	
	public MapPage navigateMenuMap() {
		getMainMenuDropdown().clickMenuMap();
		return new MapPage(driver);
	}
	
	public MyCabinetPage navigateMenuMyCabinet() {
		getMainMenuDropdown().clickMenuMyCabinet();
		return new MyCabinetPage(driver);
	}
	
	public AboutPage navigateMenuAbout() {
		getMainMenuDropdown().clickMenuAbout();
		return new AboutPage(driver);
	}

	public LoginDropdown gotoLoginDropdown() {
		topGuestComponent = new TopGuestComponent(driver);
		topGuestComponent.clickSigninLink();
		return new LoginDropdown(driver);
	}
	
	public RegisterDropdown gotoRegisterDropdown() {
		topGuestComponent = new TopGuestComponent(driver);
		topGuestComponent.clickSignupLink();
		return new RegisterDropdown(driver);
	}
}