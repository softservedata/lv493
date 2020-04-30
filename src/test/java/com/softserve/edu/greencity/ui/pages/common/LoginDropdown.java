package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.cabinet.GoogleAccountPage;

public class LoginDropdown {

    private WebDriver driver;
    //
    private WebElement titleField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement showPasswordButton;
    private WebElement forgotPasswordLink;
    private WebElement loginButton;
    private WebElement signInGoogleButton;
    private WebElement signUpLink;
    //
    private WebElement emailValidator;
    private WebElement passwordValidator;
    //
    private String TAG_ATTRIBUTE_VALUE = "placeholder";
    //
    RegisterDropdown registerDropdown;
    GoogleAccountPage googleAccountPage;

    public LoginDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        titleField = driver.findElement(By.cssSelector("div[class='right-side'] h1"));
        emailField = driver.findElement(By.cssSelector("app-sign-in-new form label[for='email'] + input"));
        passwordField = driver.findElement(By.cssSelector("app-sign-in-new form div[class*='password-input'] input"));
        showPasswordButton = driver.findElement(By.cssSelector("img[class*='show-hide-password']"));
        forgotPasswordLink = driver.findElement(By.cssSelector("a[class='forgot-password']"));
        loginButton = driver.findElement(By.cssSelector("button[class='primary-global-button']"));
        signInGoogleButton = driver.findElement(By.cssSelector("button[class='google-sign-in']"));
        signUpLink = driver.findElement(By.cssSelector("a[class='sign-up-link']"));

        // init Validators
//        emailValidator = driver.findElement(By.xpath("//form[contains(@class,'ng-touched')]/div[contains(@class,'email-error')]/div"));
//        passwordValidator = driver.findElement(By.xpath("//form[contains(@class,'ng-touched')]/div[contains(@class,'password-error')]/div"));
    }

    // Page Object
//  titleField
    public WebElement getTitleField() {
        return titleField;
    }

    public String getTitleFieldText() {
        return getTitleField().getText();
    }

    public void clickTitleField() {
        if (isDisplayedTitleField()) {
            getTitleField().click();
        }
    }

    public boolean isDisplayedTitleField() {
        return getTitleField().isDisplayed();
    }

//  emailField
    public WebElement getEmailField() {
        return emailField;
    }

    public String getEmailFieldText() {
        return getEmailField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearEmailField() {
        getEmailField().clear();
    }

    public void clickEmailField() {
        getEmailField().click();
    }

    public void setEmailField(String text) {
        getEmailField().sendKeys(text);
    }

    public boolean isDisplayedEmailField() {
        return getEmailField().isDisplayed();
    }

//  passwordField
    public WebElement getPasswordField() {
        return passwordField;
    }

    public String getPasswordFieldText() {
        return getPasswordField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearPasswordField() {
        getPasswordField().clear();
    }

    public void clickPasswordField() {
        getPasswordField().click();
    }

    public void setPasswordField(String text) {
        getPasswordField().sendKeys(text);
    }

    public boolean isDisplayedPasswordField() {
        return getPasswordField().isDisplayed();
    }

//  showPasswordButton
    public WebElement getShowPasswordButton() {
        return showPasswordButton;
    }

    public String getShowPasswordButtonText() {
        return getShowPasswordButton().getText();
    }

    public void clickShowPasswordButton() {
        if (isDisplayedShowPasswordButton()) {
            getShowPasswordButton().click();
        }
    }

    public boolean isDisplayedShowPasswordButton() {
        return getShowPasswordButton().isDisplayed();
    }

//  forgotPasswordLink
    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public String getForgotPasswordLinkText() {
        return getForgotPasswordLink().getText();
    }

    public void clickForgotPasswordLink() {
        if (isDisplayedForgotPasswordLink()) {
            getForgotPasswordLink().click();
        }
    }

    public boolean isDisplayedForgotPasswordLink() {
        return getForgotPasswordLink().isDisplayed();
    }

//  loginButton
    public WebElement getLoginButton() {
        return loginButton;
    }

    public String getLoginButtonText() {
        return getLoginButton().getText();
    }

    public void clickLoginButton() {
        if (isDisplayedLoginButton()) {
            getLoginButton().click();
        }
    }

    public boolean isDisplayedLoginButton() {
        return getLoginButton().isDisplayed();
    }

//  signInGoogleButton
    public WebElement getSignInGoogleButton() {
        return signInGoogleButton;
    }

    public String getSignInGoogleButtonText() {
        return getSignInGoogleButton().getText();
    }

    public void clickSignInGoogleButton() {
        if (isDisplayedSignInGoogleButton()) {
            getSignInGoogleButton().click();
        }
    }

    public boolean isDisplayedSignInGoogleButton() {
        return getSignInGoogleButton().isDisplayed();
    }

//  signUpLink
    public WebElement getSignUpLink() {
        return signUpLink;
    }

    public String getSignUpLinkText() {
        return getSignUpLink().getText();
    }

    public void clickSignUpLink() {
        if (isDisplayedSignUpLink()) {
            getSignUpLink().click();
        }
    }

    public boolean isDisplayedSignUpLink() {
        return getSignUpLink().isDisplayed();
    }

//  emailValidator
    public WebElement getEmailValidator() {
        return emailValidator;
    }

    public String getEmailValidatorText() {
        return getEmailValidator().getText();
    }

    public void clickEmailValidator() {
        if (isDisplayedEmailValidator()) {
            getEmailValidator().click();
        }
    }

    public boolean isDisplayedEmailValidator() {
        return getEmailValidator().isDisplayed();
    }

//  passwordValidator
    public WebElement getPasswordValidator() {
        return passwordValidator;
    }

    public String getPasswordValidatorText() {
        return getPasswordValidator().getText();
    }

    public void clickPasswordValidator() {
        if (isDisplayedPasswordValidator()) {
            getPasswordValidator().click();
        }
    }

    public boolean isDisplayedPasswordValidator() {
        return getPasswordValidator().isDisplayed();
    }

    // Functional
 // a Google window opens and switches to it
    public GoogleAccountPage clickEmailGoogleAccountField() {
        String currentTab = driver.getWindowHandle();
        clickSignInGoogleButton();
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
}
