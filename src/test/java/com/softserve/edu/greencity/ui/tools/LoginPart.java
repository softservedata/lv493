package com.softserve.edu.greencity.ui.tools;

import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.cabinet.RegisterComponent;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterPage;

public abstract class LoginPart {

    protected WebElement emailField;
    protected WebElement passwordField;
    protected WebElement signInButton;
    protected WebElement googleSigningButton;
    protected WebElement forgotPasswordLink;
    protected WebElement signUpLink; // author Serge

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

    public abstract ForgotPasswordPart gotoForgotPassword();
//    public RegisterDropdown gotoRegister(WebDriver driver) { //fix
//        this.getRegisterLink().click();
//        return new RegisterDropdown(driver);
//    }


//    public LoginPart loginByGoogleAccount() {
//        clickGoogleLoginButton();
//        // TODO
//        return this;
//    }

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

 // Sign Up link
    public abstract RegisterPart gotoRegister();

    // ------author Serge
    /**
     * getSignUoLink
     * @return WebElement
     */
    protected WebElement getSignUpLink() {
        return signUpLink;
    }

    /**
     * getSignInLinkText
     * @return String
     */
    protected String getSignUpLinkText() {
        return getSignUpLink().getText();
    }

    /**
     * clickSignInLink
     * @return LoginPart
     */
    public LoginPart clickSignUpLink() {
        if (isDisplayedSignUpLink()) {
            this.getSignUpLink().click();
        }
        return this;
    }

    /**
     * setSignUpLink
     * @param signUpLink WebElement
     * @return LoginPart class
     */
    public LoginPart setSignUpLink(WebElement signUpLink) {
        this.signUpLink = signUpLink;
        return this;
    }

    /**
     * isDisplayedSignUpLink
     * @return boolean
     */
    protected boolean isDisplayedSignUpLink() {
        return getSignUpLink().isDisplayed();
    }
}
