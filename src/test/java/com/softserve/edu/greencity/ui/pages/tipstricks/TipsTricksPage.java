package com.softserve.edu.greencity.ui.pages.tipstricks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.pages.map.MapPage;

public class TipsTricksPage extends TopPart {

    // Buttons on the TipsTricksPage
    private WebElement startHabitTop;
    private WebElement startHabitCenter;
    private WebElement startHabitBelow;
    private WebElement subscribeOnHome;

    // field for email for subscribe
    private WebElement enterEmailHome;

    // Text about amountPeople, quantityBags, quantityCups
    private WebElement amountPeople;
    private WebElement amountBags;
    private WebElement amountCups;
    // private WebElement qrCode;
    // link to MapPage
    private WebElement linkBags;
    private WebElement linkCups;

    public TipsTricksPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        startHabitTop = driver
                .findElement(By.xpath("//div[@id='header-left']//button[@class='button primary-global-button']"));
        startHabitCenter = driver
                .findElement(By.cssSelector(".stat-row-content.ng-star-inserted:nth-child(2)> div> button"));
        startHabitBelow = driver
                .findElement(By.cssSelector(".stat-row-content.ng-star-inserted:nth-child(1) > div >button"));
        subscribeOnHome = driver
                .findElement(By.xpath("//div[@id='form-wrapper']/button[@class='primary-global-button']"));
        enterEmailHome = driver.findElement(By.xpath("//input[@type='email']"));
        amountPeople = driver.findElement(By.cssSelector("#stats>h2"));
        amountBags = driver.findElement(By.xpath("//app-stat-row/div/div[2]/div/h3"));
        amountCups = driver.findElement(By.cssSelector(".stat-row-content.ng-star-inserted:nth-child(1) > div >h3"));
        // qrCode =
        // driver.findElement(By.xpath("//div[@id='qr-code-wrapper']/img"));
        // linkBags =
        // driver.findElement(By.cssSelector("app-stat-row:nth-child(1) > div >
        // div.stat-row-content.ng-star-inserted > div > div > a"));

        linkBags = driver.findElement(
                By.xpath(".//div[@class='stat-row-image ng-star-inserted']//following-sibling::div/div/div/a"));
        linkCups = driver.findElement(By.xpath(
                ".//div[@class='stat-row-image ng-star-inserted']//preceding-sibling::div[@class='stat-row-content ng-star-inserted']/div/div/a"));
    }

    // Page Object
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

    // ButtonCenter 'Start forming a habit'

    public WebElement getStartHabitCenter() {
        return startHabitCenter;
    }

    public void clickStartHabitCenter() {
        getStartHabitCenter().click();
    }

    public boolean isDisplayedStartHabitCenter() {
        return getStartHabitCenter().isDisplayed();
    }

    // ButtonBelow 'Start forming a habit'

    public WebElement getStartHabitBelow() {
        return startHabitBelow;
    }

    public void clickStartHabitBelow() {
        getStartHabitBelow().click();
    }

    public boolean isDisplayedStartHabitBelow() {
        return getStartHabitBelow().isDisplayed();
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

    public void writeEnterEmailHome(String email) {
        getEnterEmailHome().sendKeys(email);
    }

    // amount People

    public WebElement getAmountPeople() {
        return amountPeople;
    }

    public String textAmountPeople() {
        return getAmountPeople().getText();
    }

    public int getNumberAmountPeople() {
        return digits(textAmountPeople());
    }

    public boolean isDesplayedAmountPeople() {
        return getAmountPeople().isDisplayed();
    }

    // amount Bags

    public WebElement getAmountBags() {
        return amountBags;
    }

    public String textAmountBags() {
        return amountBags.getText();
    }

    public int getNumberAmountBags() {
        return digits(textAmountBags());
    }

    // amount Cups

    public WebElement getAmountCups() {
        return amountCups;
    }

    public String textAmountCups() {
        return amountCups.getText();
    }

    public int getNumberAmountCups() {
        return digits(textAmountCups());
    }

    // link bellow Bags to MapPage

    public WebElement getLinkBags() {
        return linkBags;
    }

    public void clickLinkBags() {
        getLinkBags().click();
    }

    // link bellow Bags to MapPage

    public WebElement getLinkCups() {
        return linkCups;
    }

    public void clickLinkCups() {
        getLinkCups().click();
    }
    // Functional

    private int digits(String text) {
        String regex = "\\d+";
        Pattern pattern = null;
        Matcher matcher = null;
        try {
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(text);
        } catch (PatternSyntaxException e) {
            e.getMessage();
        }
        if (matcher.find()) {
            text.substring(matcher.start(), matcher.end());
        }

        return Integer.valueOf(text.substring(matcher.start(), matcher.end()));
    }

    // Business Logic

    public TipsTricksPage switchLanguage(Languages language) {
        chooseLanguage(language);
        return new TipsTricksPage(driver);
    }

    public MyCabinetPage createHabitToMyCabinet() {
        clickStartHabitTop();
        return new MyCabinetPage(driver);
    }

    // public MyCabinetPage createHabitCenterToMyCabinet() {
    // clickStartHabitCenter();
    // return new MyCabinetPage(driver);
    // }

    // public MyCabinetPage createHabitBellowToMyCabinet() {
    // clickStartHabitBelow();
    // return new MyCabinetPage(driver);
    // }
    public MapPage moveBagsToMap() {
        clickLinkBags();
        return new MapPage(driver);
    }

    public MapPage moveCupsToMap() {
        clickLinkCups();
        return new MapPage(driver);

    }
}
