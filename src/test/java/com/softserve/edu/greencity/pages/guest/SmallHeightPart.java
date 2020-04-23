package com.softserve.edu.greencity.pages.guest;

import org.openqa.selenium.WebDriver;

public class SmallHeightPart extends TopPart {

	public SmallHeightPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
	}

	// Page Object

	// Functional

	// Business Logic

	@Override
	public HomePage navigateMenuHome() {
		scrollDown();
		if (isMenuClickable()) {
			return super.navigateMenuHome();
		}
		getMainMenuDropdown().closeNaviconButton();
		getMainMenuDropdown().clickFooterHome();
		return new HomePage(driver);
	}

	@Override
	public EconewsPage navigateMenuEconews() {
		scrollDown();
		if (isMenuClickable()) {
			return super.navigateMenuEconews();
		}
		getMainMenuDropdown().closeNaviconButton();
		getMainMenuDropdown().clickFooterEcoNews();
		return new EconewsPage(driver);
	}

	@Override
	public HomePage navigateMenuTipsTricks() {
		scrollDown();
		if (isMenuClickable()) {
			return super.navigateMenuTipsTricks();
		}
		getMainMenuDropdown().closeNaviconButton();
		getMainMenuDropdown().clickFooterTipsTricks();
		return new HomePage(driver);
	}

	@Override
	public MapPage navigateMenuMap() {
		scrollDown();
		if (isMenuClickable()) {
			return super.navigateMenuMap();
		}
		getMainMenuDropdown().closeNaviconButton();
		getMainMenuDropdown().clickFooterMap();
		return new MapPage(driver);
	}

	@Override
	public MyCabinetPage navigateMenuMyCabinet() {
		scrollDown();
		if (isMenuClickable()) {
			return super.navigateMenuMyCabinet();
		}
		getMainMenuDropdown().closeNaviconButton();
		// getMainMenuDropdown().clickFooterMyCabinet();
		// TODO delete
		driver.get("https://ita-social-projects.github.io/GreenCityClient/#/auth");
		return new MyCabinetPage(driver);
	}

	@Override
	public AboutPage navigateMenuAbout() {
		scrollDown();
		if (isMenuClickable()) {
			return super.navigateMenuAbout();
		}
		getMainMenuDropdown().closeNaviconButton();
		getMainMenuDropdown().clickFooterAbout();
		return new AboutPage(driver);
	}
}
