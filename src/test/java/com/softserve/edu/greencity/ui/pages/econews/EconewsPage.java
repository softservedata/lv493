package com.softserve.edu.greencity.ui.pages.econews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

/**
 * 
 * @author lv-493 Taqc/Java
 *
 */
public class EconewsPage extends TopPart {
	
	//filters
	private WebElement newsFilter;
	private WebElement eventsFilter;
	private WebElement courcesFilter;
	private WebElement initiativesFilter;
	private WebElement adsFilter;
	
	private WebElement createNewsButton;
	
	private WebElement gridViev;
	private WebElement listViev;
	
	private ItemsContainer itemsContainer;

	public EconewsPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		
		newsFilter = driver.findElement(By.xpath("//li[contains(text(), \"news\")]"));
		eventsFilter = driver.findElement(By.xpath("//li[contains(text(), \"events\")]"));
		courcesFilter = driver.findElement(By.xpath("//li[contains(text(), \"courses\")]"));
		initiativesFilter = driver.findElement(By.xpath("//li[contains(text(), \"initiatives\")]"));
		adsFilter = driver.findElement(By.xpath("//li[contains(text(), \"ads\")]"));
		
		createNewsButton = driver.findElement(By.id("create-button"));
		itemsContainer = new ItemsContainer(driver);
	}

	// Page Object

	// Functional

	// Business Logic

	public EconewsPage switchLanguage(Languages language) {
		chooseLanguage(language);
		return new EconewsPage(driver);
	}
}
