package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * GoogleAccountPage class.
 * @author Serg
 */
public class GoogleAccountPage {

    private WebDriver driver;
    //
//    private WebElement chosenGoogleAccountButton;
//    private WebElement useAnotherAccountButton;
    private WebElement emailField;
    private WebElement emailNextButton;
//    private WebElement forgotEmailLink;
    private WebElement passwordField;
//    private WebElement showPasswordGoogleAccountButton;
//    private WebElement forgotPasswordGoogleAccountLink;
    private WebElement passwordNextButton;

    private String titleGoogleAccount;
//    private String emailGoogleAccount;

    /**
     * GoogleAccountPage constructor.
     * @param driver
     */
    public GoogleAccountPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        titleGoogleAccount = driver.getTitle();
        emailField = driver.findElement(
                By.cssSelector("div[role='presentation'] #identifierId"));
//        emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailNextButton = driver.findElement(
                By.cssSelector("div[role='presentation'] #identifierNext"));
    }

    // Page Object
    /**
     * Get title Google Account page.
     * @return String
     */
    public String getTitleGoogleAccount() {
        return titleGoogleAccount;
    }

    // emailField
    private WebElement getEmailField() {
        return emailField;
    }

    private void clearEmailField() {
        getEmailField().clear();
    }

    private void clickEmailField() {
        if (isDisplayedEmailField()) {
            Actions action = new Actions(driver);
            action.contextClick(getEmailField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
            getEmailField().click();
        }
    }

    private void setEmailField(String emailGoogleAccount) {
        getEmailField().sendKeys(emailGoogleAccount);
    }

    private boolean isDisplayedEmailField() {
        return getEmailField().isDisplayed();
    }

    // emailNextButton
    private WebElement getEmailNextButton() {
        return emailNextButton;
    }

    private String getEmailNextButtonText() {
        return getEmailNextButton().getText();
    }

    private void clickEmailNextButton() {
        if (isDisplayedEmailNextButton()) {
            getEmailNextButton().click();
        }
    }

    private boolean isDisplayedEmailNextButton() {
        return getEmailNextButton().isDisplayed();
    }

//           passwordGoogleAccountField
    private WebElement getPasswordField() {
        passwordField = driver.findElement(
                By.cssSelector("div#password input[name='password']"));
        return passwordField;
    }

    private void clearPasswordField() {
        getPasswordField().clear();
    }

    private void clickPasswordField() {
        getPasswordField().click();
    }

    private void setPasswordField(String passwordGoogleAccount) {
        getPasswordField().sendKeys(passwordGoogleAccount);
    }

    private boolean isDisplayedPasswordField() {
        return getPasswordField().isDisplayed();
    }

//           nextButton
    private WebElement getPasswordNextButton() {
        passwordNextButton = driver.findElement(
                By.cssSelector("div[role='presentation'] #passwordNext"));
        return passwordNextButton;
    }

    private String getPasswordNextButtonText() {
        return getPasswordNextButton().getText();
    }

    private void clickPasswordNextButton() {
        if (isDisplayedPasswordNextButton()) {
            getPasswordNextButton().click();
        }
    }

    private boolean isDisplayedPasswordNextButton() {
        return getPasswordNextButton().isDisplayed();
    }

    // Functional

    // Business Logic

    /**
     * Enter an email.
     * @param email
     * @return GoogleAccountPage
     */
    public GoogleAccountPage enterEmail(String email) {
        if (isDisplayedEmailField()) {
            clickEmailField();
            clearEmailField();
            System.out.println("----Email page. Entered email: " + email);
            setEmailField(email);
        }
        return this;
    }

    /**
     * Click on "Next" button on the email page.
     * @return GoogleAccountPage
     */
    public GoogleAccountPage clickEmailNext() {
        if (isDisplayedEmailNextButton()) {
            System.out.println("----Email page. Click on "
                    + getEmailNextButtonText() + " button");
            clickEmailNextButton();
        }
        return this;
    }

    /**
     * Enter a password.
     * @param password
     * @return GoogleAccountPage
     */
    public GoogleAccountPage enterPassword(String password) {
        if (isDisplayedPasswordField()) {
            clickPasswordField();
            clearPasswordField();
            System.out.println(
                    "----Password page. Entered a password: " + password);
            setPasswordField(password);
        }
        return this;
    }

    /**
     * Click on "Next" button on the password page.
     * @return GoogleAccountPage
     */
    public GoogleAccountPage clickPasswordNext() {
        if (isDisplayedPasswordNextButton()) {
            System.out.println("----Password page. Click on "
                    + getPasswordNextButtonText() + " button");
            clickPasswordNextButton();
        }
        return this;
    }
}
