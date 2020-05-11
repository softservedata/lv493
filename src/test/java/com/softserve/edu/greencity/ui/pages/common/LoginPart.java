package com.softserve.edu.greencity.ui.pages.common;

import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

import java.util.List;

public abstract class LoginPart {

    protected WebElement emailField;
    protected WebElement passwordField;
    protected WebElement signInButton;
    protected WebElement googleSigningButton;
    protected WebElement forgotPasswordLink;
    protected WebElement singUpLink;

    protected WebDriver driver;

    public LoginPart(WebDriver driver) {
        this.driver = driver;
    }

    public abstract List<String> getErrorMassages();

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getGoogleSigningButton() {
        return googleSigningButton;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getSignUpLink() {
        return singUpLink;
    }

    public LoginPart setSignUpLink(WebElement singUpLink) {
        this.singUpLink = singUpLink;
        return this;
    }

    public LoginPart setEmailField(WebElement emailField) {
        this.emailField = emailField;
        return this;
    }

    public LoginPart setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
        return this;
    }

    public LoginPart setSignInButton(WebElement signInButton) {
        this.signInButton = signInButton;
        return this;
    }

    public LoginPart setGoogleSignInButton(WebElement googleSigningButton) {
        this.googleSigningButton = googleSigningButton;
        return this;
    }

    public LoginPart setForgotPasswordLink(WebElement forgotPasswordLink) {
        this.forgotPasswordLink = forgotPasswordLink;
        return this;
    }

    
    // Functional

    public LoginPart inputEmail(String email) {
        this.getEmailField().sendKeys(email);
        return this;
    }

    public LoginPart inputPassword(String password) {
        this.getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPart clickLoginButton() {
        this.getSignInButton().click();
        return this;
    }

    public LoginPart clickGoogleLoginButton() {
        this.getGoogleSigningButton().click();
        return this;
    }


    protected void fillFields(User user) {
        inputEmail(user.getEmail())
            .inputPassword(user.getPassword());
    }
    
    protected void fillFieldsSubmit(User user) {
        fillFields(user);
        clickLoginButton();
    }

    // Business Logic

    public MyCabinetPage successfullyLogin(User user) {
        fillFields(user);
        clickLoginButton();
        return new MyCabinetPage(driver);
    }

    public LoginPart unsuccessfullyLogin(User user) {
        fillFields(user);
        clickLoginButton();
        return this;
    }


}
