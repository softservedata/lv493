package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleAccountPage {

    private WebDriver driver;
    //
    private WebElement titleGoogleAccountField;
    private WebElement chosenGoogleAccountButton;
    private WebElement useAnotherAccountButton;
    private WebElement emailField;
    private WebElement emailNextButton;
    private WebElement forgotEmailLink;
    private WebElement enterPasswordGoogleAccountField;
    private WebElement showPasswordGoogleAccountButton;
    private WebElement forgotPasswordGoogleAccountLink;
    private WebElement nextButton;

    private String emailGoogleAccount;
    private String TAG_ATTRIBUTE_VALUE = "data-initial-value";

    public GoogleAccountPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        driver.switchTo().window(
                "https://accounts.google.com/signin/oauth/identifier?redirect_uri=storagerelay%3A%2F%2Fhttps%2Fita-social-projects.github.io%3Fid%3Dauth57815&response_type=permission%20id_token&scope=email%20profile%20openid&openid.realm&client_id=129513550972-eu9ej46rviv1ac8q14at62t2k5qon1pu.apps.googleusercontent.com&ss_domain=https%3A%2F%2Fita-social-projects.github.io&fetch_basic_profile=true&gsiwebsdk=2&o2v=1&as=uCXnMRhBe9coP5_-ytb7Dg&flowName=GeneralOAuthFlow");
//        titleGoogleAccountField = driver.findElement(By.id("#headingText"));
//        chosenGoogleAccountButton = driver.findElement(
//                By.cssSelector("div[data-email='" + emailGoogleAccount + "']"));
//        useAnotherAccountButton = driver.findElement(
//                By.xpath("//div[contains(text(), 'Use another account')]"));
//        emailField = driver.findElement(By.id("#identifierId"));
//        emailNextButton = driver.findElement(By.id("#identifierNext"));
//        forgotEmailLink = driver.findElement(By.id(""));
//        enterPasswordGoogleAccountField = driver
//                .findElement(By.cssSelector("input[name='password']"));
//        showPasswordGoogleAccountButton = driver
//                .findElement(By.cssSelector("#password div[role='button']"));
//        forgotPasswordGoogleAccountLink = driver
//                .findElement(By.id("#forgotPassword"));
//        nextButton = driver.findElement(By.id("#passwordNext"));
    }

    // Page Object
    // titleGoogleAccountField
    public WebElement getTitleGoogleAccountField() {
//        titleGoogleAccountField = driver.findElement(By.id("#headingText"));
        return titleGoogleAccountField;
    }

    public String getTitleFieldText() {
        return getTitleGoogleAccountField().getText(); // Welcome back!
    }

    public boolean isDisplayedTitleField() {
        return getTitleGoogleAccountField().isDisplayed();
    }

//           chosenGoogleAccountField
    public WebElement getChosenGoogleAccountButton() {
        return chosenGoogleAccountButton;
    }

    public String getChosenGoogleAccountButtonText() {
        return getChosenGoogleAccountButton().getText();
    }

    public void clickChosenGoogleAccountButton() {
        if (isDisplayedChosenGoogleAccountButton()) {
            getChosenGoogleAccountButton().click();
        }
    }

    public boolean isDisplayedChosenGoogleAccountButton() {
        return getChosenGoogleAccountButton().isDisplayed();
    }

    // useAnotherAccountButton
    public WebElement getUseAnotherAccountButton() {
        return useAnotherAccountButton;
    }

    public String getUseAnotherAccountButtonText() {
        return getUseAnotherAccountButton().getText();
    }

    public void clickUseAnotherAccountButton() {
        if (isDisplayedUseAnotherAccountButton()) {
            getUseAnotherAccountButton().click();
        }
    }

    public boolean isDisplayedUseAnotherAccountButton() {
        return getUseAnotherAccountButton().isDisplayed();
    }

    // emailField
    public WebElement getEmailField() {
        emailField = driver
                .findElement(By.id("#identifierId"));
        return emailField;
    }

    public String getEmailFieldText() {
        return getEmailField().getText();
    }

    public void clearEmailField() {
        getEmailField().clear();
    }

    public void clickEmailField() {
        getEmailField().click();
    }

    public void setEmailField(String emailGoogleAccount) {
        getEmailField().sendKeys(emailGoogleAccount);
    }

    public boolean isDisplayedEmailField() {
        return getEmailField().isDisplayed();
    }
    
    // emailNextButton
    public WebElement getEmailNextButton() {
        emailNextButton = driver.findElement(By.id("#identifierNext"));
        return emailNextButton;
    }

    public String getEmailNextButtonText() {
        return getEmailNextButton().getText();
    }

    public void clickEmailNextButton() {
        if (isDisplayedUseAnotherAccountButton()) {
            getEmailNextButton().click();
        }
    }

    public boolean isDisplayedEmailNextButton() {
        return getEmailNextButton().isDisplayed();
    }

//           enterPasswordGoogleAccountField
    public WebElement getEnterPasswordGoogleAccountField() {
        enterPasswordGoogleAccountField = driver
                .findElement(By.cssSelector("input[name='password']"));
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
        showPasswordGoogleAccountButton = driver
                .findElement(By.cssSelector("#password div[role='button']"));
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
        forgotPasswordGoogleAccountLink = driver
                .findElement(By.id("#forgotPassword"));
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
        nextButton = driver.findElement(By.id("#passwordNext"));
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
