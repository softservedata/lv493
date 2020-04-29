package com.softserve.edu.greencity.ui.pages.tipstricks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.econews.ItemComponent;

public class TipsCardsContainer {
    
    private List<WebElement> tipsCard;
	//
	private WebDriver driver;
	//
	private List<ItemComponent> itemComponents;

	public TipsCardsContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
	    tipsCard = driver.findElements(By.xpath("//app-tips-card"));
	}

	// Page Object

	
	
	// Functional

	// Business Logic
}
