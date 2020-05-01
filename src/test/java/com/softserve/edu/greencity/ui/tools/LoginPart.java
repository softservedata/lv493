package com.softserve.edu.greencity.ui.tools;

import org.openqa.selenium.WebElement;

public abstract class LoginPart {

    protected WebElement emailField;
    protected WebElement passwordField;
    protected WebElement loginButton;
    protected WebElement googleLoginButton;
    protected WebElement forgotPasswordLink;
    protected WebElement registerLink;

    public LoginPart inputEmail(String email) {
        this.getEmailField().sendKeys(email);
        return this;
    }

    public LoginPart inputPassword(String password) {
        this.getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPart clickLoginButton() {
        this.getLoginButton().click();
        return this;
    }

    public LoginPart clickGoogleLoginButton() {
        this.getGoogleLoginButton().click();
        return this;
    }

    public LoginPart loginByEmail(String email, String password){
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
        return this;
    }

    public LoginPart loginByGoogleAccount() {
        clickGoogleLoginButton();
        // TODO
        return this;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getGoogleLoginButton() {
        return googleLoginButton;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getRegisterLink() {
        return registerLink;
    }

    public LoginPart setEmailField(WebElement emailField) {
        this.emailField = emailField;
        return this;
    }

    public LoginPart setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
        return this;
    }

    public LoginPart setLoginButton(WebElement loginButton) {
        this.loginButton = loginButton;
        return this;
    }

    public LoginPart setGoogleLoginButton(WebElement googleLoginButton) {
        this.googleLoginButton = googleLoginButton;
        return this;
    }

    public LoginPart setForgotPasswordLink(WebElement forgotPasswordLink) {
        this.forgotPasswordLink = forgotPasswordLink;
        return this;
    }

    public LoginPart setRegisterLink(WebElement registerLink) {
        this.registerLink = registerLink;
        return this;
    }
}

