package com.softserve.edu.greencity.ui.pages.econews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author lv-493 Taqc/Java
 */
public class PreViewPage extends TopPart {

	private WebDriver driver;

	// news fields
	private List<WebElement> tagsFields;
	private WebElement titleField;
	private WebElement dateField;
	private WebElement authorField;
	private WebElement contentField;

	//img to share news
	private WebElement imgTwitterLink;
	private WebElement imgLinkedinLink;
	private WebElement imgFacebookLink;

	private WebElement backToEditingLink;

	public PreViewPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		titleField = driver.findElement(By.cssSelector("div.news-title"));
		tagsFields = driver.findElements(By.cssSelector("div.tags > div"));
		contentField = driver.findElement(By.cssSelector("div.news-text"));
		dateField = driver.findElement(By.cssSelector("div.news-info-date"));
		authorField = driver.findElement(By.cssSelector("div.news-info-author"));
		imgFacebookLink = driver.findElement(By.xpath("//img[contains(@src,'facebook.svg')]"));
		imgLinkedinLink = driver.findElement(By.xpath("//img[contains(@src,'linkedin.svg')]"));
		imgTwitterLink = driver.findElement(By.xpath("//img[contains(@src,'twitter.svg')]"));
		backToEditingLink = driver.findElement(By.cssSelector("div.button-text"));
}

	// Page Object

	// tagsFields;
	public List<WebElement> getTagsFields() {
		return tagsFields;
	} //todo

	//titleField;
	public WebElement getTitleField() {
		return titleField;
	}

	public String getTitleFieldText() {
		return getTitleField().getText();
	}

	//dateField;
	public WebElement getDateField() {
		return dateField;
	}

	public String getDateFieldText() {
		return getDateField().getText();
	}

	//authorField;
	public WebElement getAuthorField() {
		return authorField;
	}

	public String getAuthorFieldText() {
		return getAuthorField().getText();
	}

	//contentField
	public WebElement getContentField() {
		return contentField;
	}

	public String getContentFieldText() {
		return getContentField().getText();
	}

	//imgTwitterLink;
	public WebElement getImgTwitterLink() {
		return imgTwitterLink;
	}

	public void clickImgTwitterLink() {
		getImgTwitterLink().click();
	}

	//imgLinkedinLink;
	public WebElement getImgLinkedinLink() {
		return imgLinkedinLink;
	}

	public void clickImgLinkedinLink() {
		getImgLinkedinLink().click();
	}

	//imgFacebookLink;
	public WebElement getImgFacebookLink() {
		return imgFacebookLink;
	}

	public void clickImgFacebookLink() {
		getImgFacebookLink().click();
	}

	//backToEditingLink;
	public WebElement getBackToEditingLink() {
		return backToEditingLink;
	}

	public void clickBackToEditingLink() {
		getBackToEditingLink().click();
	} // return type: CreateNewsPage or WebElement

	// Functional

	// Business Logic
}