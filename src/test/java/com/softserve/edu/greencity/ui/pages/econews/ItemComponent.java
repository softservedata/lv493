package com.softserve.edu.greencity.ui.pages.econews;

//import java.util.ArrayList;
//import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemComponent {
    //
    private WebDriver driver;
    private WebElement cardItem;

    // private List<WebElement> tipsCard;
    // // img
    // private List<WebElement> coffeeCups;
    // private List<WebElement> waterBottle;
    // private List<WebElement> spoonKnife;
    // // text cards
    // private List<WebElement> paragraphCard;
    private WebElement coffeeCups;
    private WebElement waterBottle;
    private WebElement spoonKnife;
    private WebElement paragraphCard;

    public ItemComponent(WebDriver driver, WebElement cardItem) {
        this.driver = driver;
        this.cardItem = cardItem;

        initElements();
    }

    private void initElements() {
        // init elements
        // tipsCard = driver.findElements(By.xpath("//app-tips-card"));
        // coffeeCups =
        // driver.findElements(By.cssSelector("img[src*='coffee-cup']"));
        // waterBottle =
        // driver.findElements(By.cssSelector("img[src*='water-bottle']"));
        // spoonKnife =
        // driver.findElements(By.cssSelector("img[src*='spoon-knife']"));
        // paragraphCard =
        // driver.findElements(By.cssSelector("div.tip-image-wrapper ~ p"));
        coffeeCups = driver.findElement(By.cssSelector("img[src*='coffee-cup']"));
        waterBottle = driver.findElement(By.cssSelector("img[src*='water-bottle']"));
        spoonKnife = driver.findElement(By.cssSelector("img[src*='spoon-knife']"));
        paragraphCard = driver.findElement(By.cssSelector("div.tip-image-wrapper ~ p"));
    }

    // Page Object

    // coffeeCups

    // public List<WebElement> getCoffeeCups() {
    // return coffeeCups;
    // }

    // waterBottle

    // public List<WebElement> getWaterBottle() {
    // return waterBottle;
    // }

    // spoonKnife

    // public List<WebElement> getSpoonKnife() {
    // return spoonKnife;
    // }

    // textCard

    // public List<WebElement> getParagraphCard() {
    // return paragraphCard;
    // }

    // public List<String> getParagraphCardText() {
    // List<String> str = new ArrayList<String>();
    // for(WebElement elem : getParagraphCard() ) {
    // str.add(elem.getText());
    // }
    // return str;
    // }

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
