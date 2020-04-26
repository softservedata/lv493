package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleAccountPage {

    private WebDriver driver;
    //
    private WebElement titleGoogleAccountField;
    private WebElement chosenGoogleAccountField;
    private WebElement enterPasswordGoogleAccountField;
    private WebElement showPasswordGoogleAccountButton;
    private WebElement forgotPasswordGoogleAccountLink;
    private WebElement nextButton;

    private String emailGoogleAccount;
    private String TAG_ATTRIBUTE_VALUE = "data-initial-value";

    public GoogleAccountPage(WebDriver driver, String emailGoogleAccount) {
        this.driver = driver;
        this.emailGoogleAccount = emailGoogleAccount;
        initElements();
    }

    private void initElements() {
        // init elements
        titleGoogleAccountField = driver.findElement(By.id("#headingText"));
        chosenGoogleAccountField = driver.findElement(
                By.cssSelector("div[data-email='" + emailGoogleAccount + "']"));
        enterPasswordGoogleAccountField = driver
                .findElement(By.cssSelector("input[name='password']"));
        showPasswordGoogleAccountButton = driver
                .findElement(By.cssSelector("#password div[role='button']"));
        forgotPasswordGoogleAccountLink = driver
                .findElement(By.id("#forgotPassword"));
        nextButton = driver.findElement(By.id("#passwordNext"));
    }

    // Page Object
    // titleGoogleAccountField
    public WebElement getTitleGoogleAccountField() {
        return titleGoogleAccountField;
    }

    public String getTitleFieldText() {
        return getTitleGoogleAccountField().getText(); // Welcome back!
    }

    public boolean isDisplayedTitleField() {
        return getTitleGoogleAccountField().isDisplayed();
    }

//           chosenGoogleAccountField
    public WebElement getChosenGoogleAccountField() {
        return chosenGoogleAccountField;
    }

    public String getChosenGoogleAccountFieldText() {
        return getChosenGoogleAccountField().getText();
    }

    public void clickChosenGoogleAccountField() {
        if (isDisplayedChosenGoogleAccountField()) {
            getChosenGoogleAccountField().click();
        }
    }

    public boolean isDisplayedChosenGoogleAccountField() {
        return getChosenGoogleAccountField().isDisplayed();
    }

//           enterPasswordGoogleAccountField
    public WebElement getEnterPasswordGoogleAccountField() {
        return enterPasswordGoogleAccountField;
    }

    public String getEnterPasswordGoogleAccountFieldText() {
        return getEnterPasswordGoogleAccountField()
                .getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearEnterPasswordGoogleAccountField() {
        getEnterPasswordGoogleAccountField().clear();
    }

    public void clickEnterPasswordGoogleAccountField() {
        getEnterPasswordGoogleAccountField().click();
    }

    public void setEnterPasswordGoogleAccountField(String text) {
        getEnterPasswordGoogleAccountField().sendKeys(text);
    }

    public boolean isDisplayedEnterPasswordGoogleAccountField() {
        return getEnterPasswordGoogleAccountField().isDisplayed();
    }

//           showPasswordGoogleAccountButton
    public WebElement getShowPasswordGoogleAccountButton() {
        return showPasswordGoogleAccountButton;
    }

    public void clickShowPasswordGoogleAccountButton() {
        getShowPasswordGoogleAccountButton().click();
    }

    public boolean isDisplayedShowPasswordGoogleAccountButton() {
        return getShowPasswordGoogleAccountButton().isDisplayed();
    }

//           forgotPasswordGoogleAccountLink
    public WebElement getForgotPasswordGoogleAccountLink() {
        return forgotPasswordGoogleAccountLink;
    }

    public String getForgotPasswordGoogleAccountLinkText() {
        return getForgotPasswordGoogleAccountLink().getText();
    }

    public void clickForgotPasswordGoogleAccountLink() {
        if (isDisplayedForgotPasswordGoogleAccountLink()) {
            getForgotPasswordGoogleAccountLink().click();
        }
    }

    public boolean isDisplayedForgotPasswordGoogleAccountLink() {
        return getForgotPasswordGoogleAccountLink().isDisplayed();
    }

//           nextButton
    public WebElement getNextButton() {
        return nextButton;
    }

    public String getNextButtonText() {
        return getNextButton().getText();
    }

    public void clickNextButton() {
        if (isDisplayedNextButton()) {
            getNextButton().click();
        }
    }

    public boolean isDisplayedNextButton() {
        return getNextButton().isDisplayed();
    }

    // Functional

}
