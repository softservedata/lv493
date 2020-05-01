package com.softserve.edu.greencity.ui.pages.cabinet;

import com.softserve.edu.greencity.ui.tools.LoginPart;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import org.openqa.selenium.WebElement;

public class LoginPage extends TopPart{

	LoginCabinet loginCabinet;

	public LoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		loginCabinet = new LoginCabinet();
	}

}
