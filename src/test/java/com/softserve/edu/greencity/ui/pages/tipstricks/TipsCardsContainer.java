package com.softserve.edu.greencity.ui.pages.tipstricks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.greencity.ui.pages.tipstricks.CardComponent;

public class TipsCardsContainer {

    private WebDriver driver;

    private List<CardComponent> cardComponents;

    // button pagination

    private WebElement leftPagination;
    private WebElement rightPagination;

    public TipsCardsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements() {

        // init elements

        cardComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath("//app-tips-card"))) {
            cardComponents.add(new CardComponent(driver, current));
        }

        leftPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-left']/.."));
        rightPagination = driver.findElement(By.xpath("//i[@class='arrow fas fa-chevron-right']/.."));

    }

    // Page Object

    // leftPagination

    public WebElement getleftPagination() {
        scrollTo(leftPagination);
        return leftPagination;
    }

    public void clickleftPagination() {
        getleftPagination().click();
    }

    // rightPagination

    public WebElement getRightPagination() {
        scrollTo(rightPagination);
        return rightPagination;
    }

    public void clickRightPagination() {
        getRightPagination().click();
    }

    // cardComponents

    public List<CardComponent> getCardComponents() {
        return cardComponents;
    }

    // Functional

    /**
     * @param scroll
     *            to WebElement element
     */
    private void scrollTo(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    /**
     * @return number CardComponents is displayed
     */
    public int getCardComponentsCount() {
        return getCardComponents().size();
    }

    public List<WebElement> checkActiveCards() {
        List<WebElement> activeCards = new ArrayList<>();
        for (CardComponent curr : getCardComponents()) {
            curr.getCardItem().getAttribute("class").contains("slide-duplicate-active");
        }
        return activeCards;
    }
    // Business Logic
}
