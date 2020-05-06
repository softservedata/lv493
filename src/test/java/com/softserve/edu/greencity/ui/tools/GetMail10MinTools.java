package com.softserve.edu.greencity.ui.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class GetMail10MinTools {

    private WebDriver driver;
    //
    private WebElement tempEmailField;
    private WebElement deleteButton;
    private WebElement emailButton;
    private WebElement verifyEmailButton;

    private final String url = "https://www.minuteinbox.com/";
    private final String mailGeenCity = "mailgreencity1@gmail.com";

    public GetMail10MinTools(WebDriver driver) {
        initElements();
    }

    // init elements
    private void initElements() {
        deleteButton = driver.findElement(By.cssSelector(
                "ul[class*='nav-tabs'] li[class*='delete-tab'] a[href*='delete']"));
        tempEmailField = driver.findElement(By.id("email"));
        emailButton = driver.findElement(
                By.cssSelector("span:contains('" + mailGeenCity + "')"));
        verifyEmailButton = driver
                .findElement(By.xpath("//a[contains(text(), 'Verify Email')]"));
    }

    // Page Object
    // deleteButton
    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public void clickDeleteButton() {
        getDeleteButton().click();
    }

    public String getDeleteButtonText() {
        return getTempEmailField().getText();
    }

    public boolean isDisplayedDeleteButton() {
        return getDeleteButton().isDisplayed();
    }

//    tempEmailField
    public WebElement getTempEmailField() {
        return tempEmailField;
    }

    public void clickTempEmailField() {
        getTempEmailField().click();
    }

    public String getTempEmailFieldText() {
        return getTempEmailField().getText();
    }

    public boolean isDisplayedTempEmailField() {
        return getTempEmailField().isDisplayed();
    }

//    emailButton
    public WebElement getEmailButton() {
        return emailButton;
    }

    public void clickEmailButton() {
        getEmailButton().click();
    }

    public String getEmailButtonText() {
        return getEmailButton().getText();
    }

    public boolean isDisplayedEmailButton() {
        return getEmailButton().isDisplayed();
    }

//    verifyEmailButton
    public WebElement getVerifyEmailButton() {
        return verifyEmailButton;
    }

    public void clickVerifyEmailButton() {
        getVerifyEmailButton().click();
    }

    public String getVerifyEmailButtonText() {
        return getVerifyEmailButton().getText();
    }

    public boolean isDisplayedVerifyEmailButton() {
        return getVerifyEmailButton().isDisplayed();
    }

    // Functional
    public String getUrl() {
        return url;
    }

}
