package com.softserve.edu.greencity.ui.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.pages.econews.ItemsContainer;

public class OneNewsPage extends TopPart {
	
	//there will be also functionality follow us - is not implemented
	//private WebElement editNewsButton;  // isn't working yet tags
	private WebElement  goToNews;
	private List<WebElement> filtersList;
	private WebElement title;
	private WebElement data;
	private WebElement author;
	private WebElement picture;
	private WebElement desciption;
	private ItemsContainer itemsContainer;

	public OneNewsPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goToNews = driver.findElement(By.cssSelector("div.back-button"));
		filtersList = driver.findElements(By.cssSelector("div.tags > div"));
		title = driver.findElement(By.cssSelector("div.news-content > div.news-text-container > div.news-title"));
		data = driver.findElement(By.cssSelector("div.news-info > div.news-info-date"));
		author = driver.findElement(By.cssSelector("div.news-info > div.news-info-author"));
		picture = driver.findElement(By.cssSelector("div.news-image > img.news-image-img"));
		desciption = driver.findElement(By.cssSelector("div.news-text"));
		itemsContainer  = new ItemsContainer(driver);
	}
	
	//Page Object
	
	//goToNews 
	
	protected WebElement getGoToNews () {
        return goToNews ;
    }

    protected String getGoToNewsText() {
        return getGoToNews().getText();
    }
    
    protected void clickGoToNewsButton() {
        getGoToNews().click();
    }
    
    //filtersList
    
	protected List<WebElement> getfiltersList() {
        return filtersList;
    }

   //title
    
	protected WebElement getTitle() {
        return title;
    }

    protected String getTitleText() {
        return getTitle().getText().trim();   //should we use trim?
    }
    
    //data
    
    protected WebElement getData() {
        return data;
    }

    protected String getDataText() {
        return getData().getText();
    }
    
    //author
    
    protected WebElement getAuthor() {
        return author;
    }

    protected String getAuthorText() {
        return getAuthor().getText();
    }
    
    //desciption
    
    protected WebElement getDesciption() {
        return desciption;
    }

    protected String getDesciptionText() {
        return getDesciption().getText();
    }
}
