package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.greencity.ui.pages.cabinet.GoogleAccountPage;

/**
 * Abstract class UserEnterPage for use in login and register classes.
 * @author Serg
 *
 */
public abstract class UserEnterPage extends TopPart {
    //
    protected WebDriver driver;
    //
    protected WebElement titleField;
    protected WebElement emailField;
    protected WebElement passwordField;
    protected WebElement showPasswordButton;
    protected WebElement signWithGoogleButton;
    //
    protected WebElement emailValidator;
    protected WebElement passwordValidator;
    //
    GoogleAccountPage googleAccountPage;

    public UserEnterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    protected void initElements() {
        titleField = null;
        emailField = null;
        passwordField = null;
        showPasswordButton = null;
        signWithGoogleButton = null;
        emailValidator = null;
        passwordValidator = null;
    }

//  titleField
    protected WebElement getTitleField() {
        return titleField;
    }

    public String getTitleFieldText() {
        return getTitleField().getText();
    }

    public boolean isDisplayedTitleField() {
        return getTitleField().isDisplayed();
    }

//  emailField
    protected WebElement getEmailField() {
        return emailField;
    }

    protected void clearEmailField() {
        getEmailField().clear();
    }

    protected void clickEmailField() {
        Actions action = new Actions(driver);
        action.contextClick(getEmailField()).sendKeys(Keys.LEFT);
        getEmailField().click();
    }

    protected void setEmailField(String email) {
        getEmailField().sendKeys(email);
    }

    protected boolean isDisplayedEmailField() {
        return getEmailField().isDisplayed();
    }

//  passwordField
    public WebElement getPasswordField() {
        return passwordField;
    }

    protected void clearPasswordField() {
        getPasswordField().clear();
    }

    protected void clickPasswordField() {
        Actions action = new Actions(driver);
        action.contextClick(getPasswordField()).sendKeys(Keys.LEFT);
        getPasswordField().click();
    }

    protected void setPasswordField(String password) {
        getPasswordField().sendKeys(password);
    }

    protected boolean isDisplayedPasswordField() {
        return getPasswordField().isDisplayed();
    }

//  showPasswordButton
    protected WebElement getShowPasswordButton() {
        return showPasswordButton;
    }

    protected void clickShowPasswordButton() {
        if (isDisplayedShowPasswordButton()) {
            getShowPasswordButton().click();
        }
    }

    protected boolean isDisplayedShowPasswordButton() {
        return getShowPasswordButton().isDisplayed();
    }

//  signWithGoogleButton
    protected WebElement getSignWithGoogleButton() {
        return signWithGoogleButton;
    }

    public String getSignWithGoogleButtonText() {
        return getSignWithGoogleButton().getText();
    }

    protected void clickSignWithGoogleButton() {
        if (isDisplayedSignWithGoogleButton()) {
            getSignWithGoogleButton().click();
        }
    }

    protected boolean isDisplayedSignWithGoogleButton() {
        return getSignWithGoogleButton().isDisplayed();
    }

//  emailValidator
    protected WebElement getEmailValidator() {
        return emailValidator;
    }

    protected String getEmailValidatorText() {
        return getEmailValidator().getText(); // Email is required
    }

    protected boolean isDisplayedEmailValidator() {
        return getEmailValidator().isDisplayed();
    }

    protected boolean sizeEmailValidator() {
        boolean result = false;
        return result;
    }

//  passwordValidator
    protected WebElement getPasswordValidator() {
        return passwordValidator;
    }

    protected String getPasswordValidatorText() {
        return getPasswordValidator().getText(); // Password is required
    }

    protected boolean isDisplayedPasswordValidator() {
        return getPasswordValidator().isDisplayed();
    }

    protected boolean sizePasswordValidator() {
        boolean result = false;
        return result;
    }

    // Functional
    // sign In/Up using Google account
    public GoogleAccountPage clickEmailGoogleAccountField() {
        String currentTab = driver.getWindowHandle();
        clickSignWithGoogleButton();
        for (String current : driver.getWindowHandles()) {
            System.out.println("TAB: " + current);
            if (!current.equals(currentTab)) {
                driver.switchTo().window(current);
                System.out.println("URL: " + driver.getCurrentUrl());
                break;
            }
        }
        return new GoogleAccountPage(driver);
    }

    // Business Logic

    // enter email
    public void enterEmail(String email) {
        if (isDisplayedEmailField()) {
            clickEmailField();
            clearEmailField();
            setEmailField(email);
        }
    }

    // enter password
    public void enterPassword(String password) {
        if (isDisplayedPasswordField()) {
            clickPasswordField();
            clearPasswordField();
            setPasswordField(password);
            clickShowPasswordButton();
        }
    }

//  emailError
    public String getEmailErrorText() {
        if (sizeEmailValidator() && isDisplayedEmailValidator()) {
            return getEmailValidatorText();
        }
        return "email error text not found";
    }

//  passwordError
    public String getPasswordErrorText() {
        if (sizePasswordValidator() && isDisplayedPasswordValidator()) {
            return getPasswordValidatorText();
        }
        return "password error text not found";
    }
}
