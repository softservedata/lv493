package com.softserve.edu.greencity.ui.pages.tipstricks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardComponent {
    //
    private WebDriver driver;
    private WebElement cardItem;

    private WebElement coffeeCups;
    private WebElement waterBottle;
    private WebElement spoonKnife;
    private WebElement paragraphCard;

    public CardComponent(WebDriver driver, WebElement cardItem) {
        this.driver = driver;
        this.cardItem = cardItem;

        initElements();
    }

    private void initElements() {
        // init elements

        coffeeCups = driver.findElement(By.cssSelector("img[src*='coffee-cup']"));
        waterBottle = driver.findElement(By.cssSelector("img[src*='water-bottle']"));
        spoonKnife = driver.findElement(By.cssSelector("img[src*='spoon-knife']"));
        paragraphCard = cardItem.findElement(By.cssSelector("div.tip-image-wrapper ~ p"));
    }

    // Page Object

    // for container

    public WebElement getCardItem() {
        return cardItem;
    }

    public WebElement getCoffeeCups() {
        return coffeeCups;
    }

    boolean isDesplayedCoffeeCups() {
        return getCoffeeCups().isDisplayed();
    }

    public WebElement getWaterBottles() {
        return waterBottle;
    }

    boolean isDesplayedWaterBottle() {
        return getWaterBottles().isDisplayed();
    }

    public WebElement getSpoonKnife() {
        return spoonKnife;
    }

    boolean isDesplayedSpoonKnife() {
        return getSpoonKnife().isDisplayed();
    }

    public WebElement getParagraphCard() {
        return paragraphCard;
    }

    public String getParagraphCardText() {
        return getParagraphCard().getText();
    }
    // Functional

    // Business Logic
}
