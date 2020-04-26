package com.softserve.edu.greencity.ui.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class ItemComponent {

	private WebElement container;
	private List<WebElement> typeOfNews;
	private WebElement header;
	private WebElement description;
	private WebElement dateOfCreation;
	private WebElement author;

	public ItemComponent(WebElement container) {
		this.container = container;
		initElements();
	}

	private void initElements() {

		typeOfNews = container.findElements(By.xpath(".div[@id=\"list-gallery-content\"]//div[@class=\"filter-tag\"]/div"));
		header = container.findElement(By.xpath(".div[@id=\"list-gallery-content\"]//div[@class=\"title-list\"]/p"));
		description = container.findElement(By.xpath(".div[@id=\"list-gallery-content\"]//div[@class=\"list-text\"]/p"));
		dateOfCreation = container.findElement(By.xpath("//img[@alt=\"calendar icon\"]/.."));
		author = container.findElement(By.xpath("//img[@alt=\"user icon\"]/.."));
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
	public WebElement getContainer() {
		return container;
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
