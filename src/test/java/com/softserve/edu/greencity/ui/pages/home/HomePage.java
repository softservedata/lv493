package com.softserve.edu.greencity.ui.pages.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class HomePage extends TopPart {

    private WebElement startHabitTop;
    private WebElement subscribeOnHome;
    private WebElement enterEmailHome;
    private WebElement leftPagination;
    private WebElement rightPagination;
    private WebElement amountPeople;
    private List<WebElement> amountBagsCups;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        startHabitTop = driver
                .findElement(By.xpath("//div[@id='header-left']//button[@class='button primary-global-button']"));
        subscribeOnHome = driver
                .findElement(By.xpath("//div[@id='form-wrapper']/button[@class='primary-global-button']"));
        enterEmailHome = driver
                .findElement(By.xpath("//div[@id='form-wrapper']/input[@class='ng-pristine ng-valid ng-touched']"));
        leftPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-left']/.."));
        rightPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-right']/.."));
        amountPeople = driver.findElement(By.xpath("//section[@id='stats']/h2"));
        amountBagsCups = driver.findElements(By.xpath("//div[@class='content-wrapper']/h3"));

    }

    // Page Object

    // Functional

    // Business Logic

    public HomePage switchLanguage(Languages language) {
        chooseLanguage(language);
        return new HomePage(driver);
    }

    // Button 'Start forming a habit'

    public WebElement getStartHabitTop() {
        return startHabitTop;
    }

    public void clickStartHabitTop() {
        getStartHabitTop().click();
    }

    public boolean isDisplayedStartHabitTop() {
        return getStartHabitTop().isDisplayed();
    }

    // Button 'Subscribe'

    public WebElement getSubscribeOnHome() {
        return subscribeOnHome;
    }

    public void clickSubscribeOnHome() {
        getSubscribeOnHome().click();

    }

    public boolean isDisplayedSubscribeOnHome() {
        return getSubscribeOnHome().isDisplayed();
    }

    // Enter email for Subscribe

    public WebElement getEnterEmailHome() {
        return enterEmailHome;
    }

    public void clickEnterEmailHome() {
        getEnterEmailHome().click();
    }

    // leftPagination

    public WebElement getleftPagination() {
        return leftPagination;
    }

    public void clickleftPagination() {
        getleftPagination().click();
    }

    // rightPagination

    public WebElement getRightPagination() {
        return rightPagination;
    }

    public void clickRightPagination() {
        getRightPagination().click();
    }

    // amountPeople

    public WebElement getAmountPeople() {
        return amountPeople;
    }

    public boolean isDesplayedAmountPeople() {
        return getAmountPeople().isDisplayed();
    }

}
