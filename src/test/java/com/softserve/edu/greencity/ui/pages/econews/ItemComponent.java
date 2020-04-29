package com.softserve.edu.greencity.ui.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ItemComponent {
	
	private WebDriver driver;
	private WebElement newsItem;
	private List<WebElement> typeOfNews;
	private WebElement header;
	private WebElement description;
	private WebElement dateOfCreation;
	private WebElement author;
	

	public ItemComponent(WebDriver driver, WebElement newsItem) {
		//this.container = container; // change name
		this.driver = driver;
		this.newsItem = newsItem;
	
		initElements();
	}
	
	protected void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.bottom-part")));
		}
	
	private void initElements() {
		scrollDown();
		WebDriverWait wait = new WebDriverWait(driver, 60); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, \"list\")]/li[20]"))) ;
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bottom-part")));
		//typeOfNews = container.findElements(By.xpath(".div[@id=\"list-gallery-content\"]//div[@class=\"filter-tag\"]/div"));
		typeOfNews = newsItem.findElements(By.cssSelector("div.filter-tag div"));
		//header = container.findElement(By.xpath(".div[@id=\"list-gallery-content\"]//div[@class=\"title-list\"]/p"));
		header = newsItem.findElement(By.cssSelector("div.title-list p"));
		//description = container.findElement(By.xpath(".div[@id=\"list-gallery-content\"]//div[@class=\"list-text\"]/p"));
		description = newsItem.findElement(By.cssSelector("div.list-text p"));
		//dateOfCreation = container.findElement(By.xpath(".img[@alt=\"calendar icon\"]/.."));
		dateOfCreation = newsItem.findElement(By.cssSelector("div.user-data-added-news > p:nth-child(1)"));
		author = newsItem.findElement(By.cssSelector("div.user-data-added-news > p:nth-child(2)"));
		//author = container.findElement(By.xpath(".img[@alt=\"user icon\"]/.."));
	}

	// Page Object
	
	//typeOfNews
	public List<WebElement> getTypeOfNews() {
		return typeOfNews;
	}
	
	public List<String> getTypeOfNewsText() {
		List<WebElement> ls = getTypeOfNews();
		List<String> str = new ArrayList<String>();
		for(WebElement elem : ls ) {
			str.add(elem.getText());
		}
		return  str;
	}

	//container
	public WebElement getNewsItem() {
		return newsItem;
	}

	//header
	public WebElement getHeader() {
		return header;
	}

	public String getHeaderText() {
		return getHeader().getText();
	}

	public void clickHeader() {
		getHeader().click();
	}

	// description
	public WebElement getDescription() {
		return description;
	}

	public String getDescriptionText() {
		return getDescription().getText();
	}
	
	public void clickDescription() {
		getDescription().click();
	}
	
	// dateOfCreation
	
	public WebElement getDateOfCreation() {
		return dateOfCreation;
	}

	public String getDateOfCreationText() {
		return getDateOfCreation().getText();
	}

	//author
	
	public WebElement getAuthor() {
		return author;
	}

	public String getAuthorText() {
		return getAuthor().getText();
	}


	// Functional

	// Business Logic
}
