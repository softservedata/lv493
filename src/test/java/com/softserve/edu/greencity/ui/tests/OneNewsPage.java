package com.softserve.edu.greencity.ui.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.pages.econews.ItemsContainer;

public class OneNewsPage extends TopPart {
	
	//there will be also functionality follow us - is not implemented
	private WebDriver driver;
	private WebElement editNewsButton;  // isn't working yet tags
	private List<WebElement> filtersList;
	private WebElement title;
	private WebElement date;
	private WebElement author;
	private WebElement picture;
	private WebElement desciption;
	private ItemsContainer itemsContainer;

	public OneNewsPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		
		editNewsButton = driver.findElement(By.cssSelector("div.button-text"));
		filtersList = driver.findElements(By.cssSelector("div.tags > div"));
		title = driver.findElement(By.cssSelector("div.news-content > div.news-text-container > div.news-title"));
		date = driver.findElement(By.cssSelector("div.news-info > div.news-info-date"));
		author = driver.findElement(By.cssSelector("div.news-info > div.news-info-author"));
		picture = driver.findElement(By.cssSelector("div.news-image > img.news-image-img"));
		desciption = driver.findElement(By.cssSelector("div.news-text"));
		itemsContainer  = new ItemsContainer(driver);
	}

}
