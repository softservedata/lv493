package com.softserve.edu.greencity.ui.pages.econews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkNewsComponent {
    private WebElement mainNews;
    
    private WebDriver driver;
    

    public LinkNewsComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        mainNews = driver.findElement(By.cssSelector("div.news-content"));
    }
    
    public WebElement getMainNews() {
        return mainNews;
    }
    public boolean isDespleyedMainNews() {
        return getMainNews().isDisplayed();
    }
    public String getMainNewsText() {
        return getMainNews().getText().trim();
    }
    

}
