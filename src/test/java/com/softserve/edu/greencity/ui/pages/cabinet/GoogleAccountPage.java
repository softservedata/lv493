package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleAccountPage {

    private WebDriver driver;
    //
    private WebElement chosenGoogleAccountButton;
    private WebElement useAnotherAccountButton;
    private WebElement emailField;
    private WebElement emailNextButton;
    private WebElement forgotEmailLink;
    private WebElement passwordGoogleAccountField;
    private WebElement showPasswordGoogleAccountButton;
    private WebElement forgotPasswordGoogleAccountLink;
    private WebElement passwordNextButton;

    private String titleGoogleAccount;
//    private String emailGoogleAccount;
    private String TAG_ATTRIBUTE_VALUE = "data-initial-value";

    public GoogleAccountPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        titleGoogleAccount = driver.getTitle();
        emailField = driver.findElement(By.cssSelector("div[role='presentation'] #identifierId"));
        emailNextButton = driver.findElement(By.cssSelector("div[role='presentation'] #identifierNext"));
    }

    // Page Object
    // titleGoogleAccountField
    public String getTitleGoogleAccount() {
        return titleGoogleAccount;
    }

    // emailField
    public WebElement getEmailField() {
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
        return emailNextButton;
    }

    public String getEmailNextButtonText() {
        return getEmailNextButton().getText();
    }

    public void clickEmailNextButton() {
        if (isDisplayedEmailNextButton()) {
            getEmailNextButton().click();
        }
    }

    public boolean isDisplayedEmailNextButton() {
        return getEmailNextButton().isDisplayed();
    }

//           passwordGoogleAccountField
    public WebElement getPasswordGoogleAccountField() {
        passwordGoogleAccountField = driver
                .findElement(By.cssSelector("div#password input[name='password']"));
        return passwordGoogleAccountField;
    }

    public String getPasswordGoogleAccountFieldText() {
        return getPasswordGoogleAccountField()
                .getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearPasswordGoogleAccountField() {
        getPasswordGoogleAccountField().clear();
    }

    public void clickPasswordGoogleAccountField() {
        getPasswordGoogleAccountField().click();
    }

    public void setPasswordGoogleAccountField(String passwordGoogleAccount) {
        getPasswordGoogleAccountField().sendKeys(passwordGoogleAccount);
    }

    public boolean isDisplayedPasswordGoogleAccountField() {
        return getPasswordGoogleAccountField().isDisplayed();
    }

//           nextButton
    public WebElement getPasswordNextButton() {
        passwordNextButton = driver.findElement(By.cssSelector("div[role='presentation'] #passwordNext"));
        return passwordNextButton;
    }

    public String getNextButtonText() {
        return getPasswordNextButton().getText();
    }

    public void clickPasswordNextButton() {
        if (isDisplayedNextButton()) {
            getPasswordNextButton().click();
        }
    }

    public boolean isDisplayedNextButton() {
        return getPasswordNextButton().isDisplayed();
    }

    // Functional

}
