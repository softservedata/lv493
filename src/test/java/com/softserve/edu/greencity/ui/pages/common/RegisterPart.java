package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.greencity.ui.pages.cabinet.GoogleAccountPage;
import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;

/**
 * RegisterPart class.
 * @author Serg
 */
public abstract class RegisterPart {
    //
    protected WebElement titleField;
    protected WebElement firstNameField;
    protected WebElement emailField;
    protected WebElement passwordField;
    protected WebElement showPasswordButton;
    protected WebElement passwordConfirmField;
    protected WebElement showPasswordConfirmButton;
    protected WebElement signUpButton;
    protected WebElement googleSignUpButton;
    protected WebElement signInLink;
    //
    protected WebElement emailValidator;
    protected WebElement passwordValidator;
    protected WebElement passwordConfirmValidator;
    //
//    ValidatorMessages validatorMessages;

    // titleField
    /**
     * setTitleField
     * @param titleField WebElement
     * @return RegisterPart
     */
    protected RegisterPart setTitleField(WebElement titleField) {
        this.titleField = titleField;
        return this;
    }

    /**
     * getTitleField
     * @return WebElement
     */
    protected WebElement getTitleField() {
        return titleField;
    }

    /**
     * getTitleFieldText()
     * @return String
     */
    public String getTitleFieldText() {
        return getTitleField().getText();
    }

    /**
     * isDisplayedTitleField
     * @return boolean
     */
    protected boolean isDisplayedTitleField() {
        return getTitleField().isDisplayed();
    }

    // first name field
    /**
     * setFirstNameField
     * @param firstNameField WebElement
     * @return RegisterPart
     */
    public RegisterPart setFirstNameField(WebElement firstNameField) {
        this.firstNameField = firstNameField;
        return this;
    }

    /**
     * getFirstNameField
     * @return WebElement
     */
    protected WebElement getFirstNameField() {
        return firstNameField;
    }

    /**
     * inputFirstName
     * @param String firstName
     * @return RegisterPart
     */
    public RegisterPart inputFirstName(String firstName) {
        this.getFirstNameField().sendKeys(firstName);
        return this;
    }

    /**
     * clearFirstName
     * @return RegisterPart
     */
    public RegisterPart clearFirstName() {
        this.getFirstNameField().clear();
        return this;
    }

    /**
     * clickFirstName field
     * @param driver WebDriver
     * @return RegisterPart
     */
    public RegisterPart clickFirstName(WebDriver driver) {
        if (isDisplayedFirstNameField()) {
            this.getFirstNameField().click();
            Actions action = new Actions(driver);
            action.contextClick(getFirstNameField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * isDisplayedFirstNameField
     * @return boolean
     */
    protected boolean isDisplayedFirstNameField() {
        return getFirstNameField().isDisplayed();
    }

    // email field
    /**
     * getEmailField
     * @return WebElement
     */
    protected WebElement getEmailField() {
        return emailField;
    }

    /**
     * input in Email field
     * @param email String
     * @return RegisterPart
     */
    public RegisterPart inputEmail(String email) {
        this.getEmailField().sendKeys(email);
        return this;
    }

    /**
     * clearEmail
     * @return RegisterPart
     */
    public RegisterPart clearEmail() {
        this.getEmailField().clear();
        return this;
    }

    /**
     * click in Email field
     * @param driver WebDriver
     * @return RegisterPart
     */
    public RegisterPart clickEmail(WebDriver driver) {
        if (isDisplayedEmailField()) {
            this.getEmailField().click();
            Actions action = new Actions(driver);
            action.contextClick(getEmailField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * setEmailField
     * @param emailField WebElement
     * @return RegisterPart
     */
    public RegisterPart setEmailField(WebElement emailField) {
        this.emailField = emailField;
        return this;
    }

    /**
     * isDisplayedEmailField
     * @return boolean
     */
    protected boolean isDisplayedEmailField() {
        return getEmailField().isDisplayed();
    }

    // password field
    /**
     * getPasswordField
     * @return WebElement
     */
    protected WebElement getPasswordField() {
        return passwordField;
    }

    /**
     * inputPassword
     * @param password String
     * @return RegisterPart
     */
    public RegisterPart inputPassword(String password) {
        this.getPasswordField().sendKeys(password);
        return this;
    }

    /**
     * clearPasswordField
     * @return RegisterPart
     */
    public RegisterPart clearPasswordField() {
        this.getPasswordField().clear();
        return this;
    }

    /**
     * clickPasswordField
     * @param driver WebDriver
     * @return RegisterPart
     */
    public RegisterPart clickPasswordField(WebDriver driver) {
        if (isDisplayedPasswordField()) {
            this.getPasswordField().click();
            Actions action = new Actions(driver);
            action.contextClick(getPasswordField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * setPasswordField
     * @param passwordField WebElement
     * @return RegisterPart
     */
    public RegisterPart setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
        return this;
    }

    /**
     * isDisplayedPasswordField
     * @return boolean
     */
    protected boolean isDisplayedPasswordField() {
        return getPasswordField().isDisplayed();
    }

    // showPasswordButton
    /**
     * getShowPasswordButton
     * @return WebElement
     */
    protected WebElement getShowPasswordButton() {
        return showPasswordButton;
    }

    /**
     * clickShowPasswordButton
     * @return RegisterPart
     */
    public RegisterPart clickShowPasswordButton() {
        if (isDisplayedShowPasswordButton()) {
            this.getShowPasswordButton().click();
        }
        return this;
    }

    /**
     * setShowPasswordButton
     * @param showPasswordButton WebElement
     * @return RegisterPart
     */
    public RegisterPart setShowPasswordButton(WebElement showPasswordButton) {
        this.showPasswordButton = showPasswordButton;
        return this;
    }

    /**
     * isDisplayedShowPasswordButton
     * @return boolean
     */
    protected boolean isDisplayedShowPasswordButton() {
        return getShowPasswordButton().isDisplayed();
    }

    // password confirm field
    /**
     * getPasswordConfirmField
     * @return WebElement
     */
    protected WebElement getPasswordConfirmField() {
        return passwordConfirmField;
    }

    /**
     * inputPasswordConfirm
     * @param passwordConfirm String
     * @return RegisterPart
     */
    public RegisterPart inputPasswordConfirm(String passwordConfirm) {
        this.getPasswordConfirmField().sendKeys(passwordConfirm);
        return this;
    }

    /**
     * clearPasswordConfirmField
     * @return RegisterPart
     */
    public RegisterPart clearPasswordConfirmField() {
        this.getPasswordConfirmField().clear();
        return this;
    }

    /**
     * clickPasswordConfirmField
     * @param driver WebDriver
     * @return RegisterPart
     */
    public RegisterPart clickPasswordConfirmField(WebDriver driver) {
        if (isDisplayedPasswordConfirmField()) {
            this.getPasswordConfirmField().click();
            Actions action = new Actions(driver);
            action.contextClick(getPasswordConfirmField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * setPasswordConfirmField
     * @param passwordConfirmField WebElement
     * @return RegisterPart
     */
    public RegisterPart setPasswordConfirmField(
            WebElement passwordConfirmField) {
        this.passwordConfirmField = passwordConfirmField;
        return this;
    }

    /**
     * isDisplayedPasswordConfirmField
     * @return boolean
     */
    protected boolean isDisplayedPasswordConfirmField() {
        return getPasswordConfirmField().isDisplayed();
    }

    // showPasswordConfirmButton
    /**
     * getShowPasswordConfirmButton
     * @return WebElement
     */
    protected WebElement getShowPasswordConfirmButton() {
        return showPasswordConfirmButton;
    }

    /**
     * clickShowPasswordConfirmButton
     * @return RegisterPart
     */
    public RegisterPart clickShowPasswordConfirmButton() {
        if (isDisplayedShowPasswordConfirmButton())
            this.getShowPasswordConfirmButton().click();
        return this;
    }

    /**
     * setShowPasswordConfirmButton
     * @param showPasswordConfirmButton
     * @return RegisterPart
     */
    public RegisterPart setShowPasswordConfirmButton(
            WebElement showPasswordConfirmButton) {
        this.showPasswordConfirmButton = showPasswordConfirmButton;
        return this;
    }

    /**
     * isDisplayedShowPasswordConfirmButton
     * @return boolean
     */
    protected boolean isDisplayedShowPasswordConfirmButton() {
        return getShowPasswordConfirmButton().isDisplayed();
    }

    // Sign Up button
    /**
     * getSignUpButton
     * @return WebElement
     */
    protected WebElement getSignUpButton() {
        return signUpButton;
    }

    /**
     * clickRegisterButton
     * @return RegisterPart
     */
    public RegisterPart clickRegisterButton() {
        if (isDisplayedSignUpButton()) {
            this.getSignUpButton().click();
        }
        return this;
    }

    /**
     * setSignUpButton
     * @param signUpButton WebElement
     * @return RegisterPart
     */
    public RegisterPart setSignUpButton(WebElement signUpButton) {
        this.signUpButton = signUpButton;
        return this;
    }

    /**
     * isDisplayedSignUpButton
     * @return boolean
     */
    protected boolean isDisplayedSignUpButton() {
        return getSignUpButton().isDisplayed();
    }

    /**
     * getSignUpButtonText
     * @return String
     */
    protected String getSignUpButtonText() {
        return getSignUpButton().getText();
    }

//    public boolean isClickablSignUpButton() {
//        return new WebDriverWait().until(ExpectedConditions.elementToBeClickable(getSignUpButton())) != null;
//    }

    // Sign Up with Google button
    /**
     * getGoogleSignUpButton
     * @return WebElement
     */
    protected WebElement getGoogleSignUpButton() {
        return googleSignUpButton;
    }

    /**
     * clickGoogleLoginButton
     * @return RegisterPart
     */
    protected RegisterPart clickGoogleLoginButton() {
        if (isDisplayedGoogleSignUpButton()) {
            this.getGoogleSignUpButton().click();
        }
        return this;
    }

    /**
     * setGoogleSignUpButton
     * @param googleSignUpButton WebElement
     * @return RegisterPart
     */
    public RegisterPart setGoogleSignUpButton(WebElement googleSignUpButton) {
        this.googleSignUpButton = googleSignUpButton;
        return this;
    }

    /**
     * isDisplayedGoogleSignUpButton
     * @return boolean
     */
    protected boolean isDisplayedGoogleSignUpButton() {
        return getGoogleSignUpButton().isDisplayed();
    }

    /**
     * getGoogleSignUpButtonText
     * @return String
     */
    protected String getGoogleSignUpButtonText() {
        return getGoogleSignUpButton().getText();
    }

    /**
     * getSignInLink
     * @return WebElement
     */
    protected WebElement getSignInLink() {
        return signInLink;
    }

    /**
     * getSignInLinkText
     * @return String
     */
    protected String getSignInLinkText() {
        return getSignInLink().getText();
    }

    /**
     * clickSignInLink
     * @return RegisterPart
     */
    public RegisterPart clickSignInLink() {
        if (isDisplayedSignInLink()) {
            this.getSignInLink().click();
        }
        return this;
    }

    /**
     * setSignInLink
     * @param signInLink WebElement
     * @return RegisterPart class
     */
    public RegisterPart setSignInLink(WebElement signInLink) {
        this.signInLink = signInLink;
        return this;
    }

    /**
     * isDisplayedSignInLink
     * @return boolean
     */
    protected boolean isDisplayedSignInLink() {
        return getSignInLink().isDisplayed();
    }

//  emailValidator
    /**
     * setEmailValidator
     * @param emailValidator WebElement
     * @return RegisterPart
     */
    protected RegisterPart setEmailValidator(WebElement emailValidator) {
        this.emailValidator = emailValidator;
        return this;
    }

    /**
     * getEmailValidator
     * @return WebElement
     */
    protected abstract WebElement getEmailValidator();

    /**
     * getEmailValidatorText
     * @return String
     */
    public String getEmailValidatorText() {
        return getEmailValidator().getText();
    }

    /**
     * isDisplayedEmailValidator
     * @return boolean
     */
    public boolean isDisplayedEmailValidator() {
        return getEmailValidator().isDisplayed();
    }

    /**
     * sizeEmailValidator
     * @return boolean
     */
    protected abstract boolean sizeEmailValidator();

//  passwordValidator
    /**
     * setPasswordValidator
     * @param passwordValidator WebElement
     * @return RegisterPart
     */
    protected RegisterPart setPasswordValidator(WebElement passwordValidator) {
        this.passwordValidator = passwordValidator;
        return this;
    }

    /**
     * getPasswordValidator
     * @return WebElement
     */
    protected abstract WebElement getPasswordValidator();

    /**
     * getPasswordValidatorText
     * @return String
     */
    public String getPasswordValidatorText() {
        return getPasswordValidator().getText();
    }

    /**
     * isDisplayedPasswordValidator
     * @return boolean
     */
    public boolean isDisplayedPasswordValidator() {
        return getPasswordValidator().isDisplayed();
    }

    /**
     * sizePasswordValidator
     * @return boolean
     */
    protected abstract boolean sizePasswordValidator();

//  passwordConfirmValidator
    /**
     * setPasswordConfirmValidator
     * @param passwordConfirmValidator WebElement
     * @return RegisterPart
     */
    protected RegisterPart setPasswordConfirmValidator(
            WebElement passwordConfirmValidator) {
        this.passwordConfirmValidator = passwordConfirmValidator;
        return this;
    }

    /**
     * getPasswordConfirmValidator
     * @return WebElement
     */
    protected abstract WebElement getPasswordConfirmValidator();

    /**
     * getPasswordConfirmValidatorText
     * @return String
     */
    public String getPasswordConfirmValidatorText() {
        return getPasswordConfirmValidator().getText();
    }

    /**
     * isDisplayedPasswordConfirmValidator
     * @return boolean
     */
    public boolean isDisplayedPasswordConfirmValidator() {
        return getPasswordConfirmValidator().isDisplayed();
    }

    /**
     * sizePasswordConfirmValidator
     * @return boolean
     */
    protected abstract boolean sizePasswordConfirmValidator();

    // Functional
    /**
     * Click SignUp with Google Account button and a Google window opens and switches to it.
     * @return GoogleAccountPage
     */
    protected abstract GoogleAccountPage clickSignUpGoogleAccountButton();
}
