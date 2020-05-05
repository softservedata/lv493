package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.greencity.ui.pages.common.RegisterPart;

/**
 * RegisterComponent class
 * @author Serg
 */
public class RegisterComponent extends RegisterPart {

    //
    private WebDriver driver;
    //
    protected WebElement registrationValidator;
    private WebElement lastNameField;
    private WebElement firstNameValidator;
//    private WebElement lastNameValidator; // not exist
    //
    private final String EMAIL_VALIDATOR_SELECTOR = "//div[@id='validation-error']/div";
    private final String REGISTRATION_VALIDATOR_SELECTOR = "app-sign-up input#email + div";
    private final String FIRST_NAME_VALIDATOR_SELECTOR = "div[class='field-wrapper-left'] div[class='ng-star-inserted']";
//    private final String LAST_NAME_VALIDATOR_SELECTOR = ""; // not exist
    private final String PASSWORD_VALIDATOR_SELECTOR = "div.password-wrapper + div";
    private final String PASSWORD_CONFIRM_VALIDATOR_SELECTOR = "app-sign-up form div#img-confirm + div[class*='validation-error'] div";

    /**
     * RegisterComponent constructor.
     * @param driver WebDriver
     */
    public RegisterComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        // init elements
        titleField = driver
                .findElement(By.cssSelector("form[name='inputform'] h1"));
        firstNameField = driver.findElement(
                By.cssSelector("form label[for='first-name'] + input"));
        lastNameField = driver.findElement(
                By.cssSelector("form label[for='last-name'] + input"));
        emailField = driver
                .findElement(By.cssSelector("form label[for='email'] + input"));
        passwordField = driver
                .findElement(By.cssSelector("div.password-wrapper input"));
        showPasswordButton = driver
                .findElement(By.cssSelector("div.password-wrapper div"));
        passwordConfirmField = driver.findElement(By.cssSelector(
                "form label[for='password'] + input#password-confirm"));
        showPasswordConfirmButton = driver
                .findElement(By.cssSelector("div.img-confirm"));
        signUpButton = driver.findElement(
                By.xpath("//form[@name='inputform']/button[@type='submit']"));
        signInLink = driver.findElement(By.cssSelector("a[href*='/auth']"));
        googleSignUpButton = driver
                .findElement(By.cssSelector("button[class='google']"));

        this.setTitleField(titleField).setEmailField(emailField)
                .setFirstNameField(firstNameField)
                .setGoogleSignUpButton(googleSignUpButton)
                .setPasswordConfirmField(passwordConfirmField)
                .setPasswordField(passwordField)
                .setShowPasswordButton(showPasswordButton)
                .setShowPasswordConfirmButton(showPasswordConfirmButton)
                .setSignInLink(signInLink).setSignUpButton(signUpButton);
    }

    // Page Object
//  lastNameField
    /**
     * getLastNameField
     * @return WebElement
     */
    protected WebElement getLastNameField() {
        return lastNameField;
    }

    /**
     * inputLastName
     * @param lastName String
     * @return RegisterComponent
     */
    public RegisterComponent inputLastName(String lastName) {
        this.getLastNameField().sendKeys(lastName);
        return this;
    }

    /**
     * clearLastName
     * @return RegisterComponent
     */
    public RegisterComponent clearLastName() {
        this.getLastNameField().clear();
        return this;
    }

    /**
     * clickLastName
     * @param driver WebDriver
     * @return RegisterComponent
     */
    protected RegisterComponent clickLastName(WebDriver driver) {
        if (isDisplayedFirstNameField()) {
            this.getLastNameField().click();
            Actions action = new Actions(driver);
            action.contextClick(getLastNameField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * setLastNameField
     * @param lastNameField WebElement
     * @return RegisterComponent
     */
    public RegisterComponent setLastNameField(WebElement lastNameField) {
        this.lastNameField = lastNameField;
        return this;
    }

    /**
     * isDisplayedLastNameField
     * @return boolean
     */
    protected boolean isDisplayedLastNameField() {
        return getLastNameField().isDisplayed();
    }

//  firstNameValidator
    /**
     * setFirstNameValidator
     * @param firstNameValidator WebElement
     * @return RegisterPart
     */
    protected RegisterPart setFirstNameValidator(
            WebElement firstNameValidator) {
        this.firstNameValidator = firstNameValidator;
        return this;
    }

    /**
     * getFirstNameValidator
     * @return WebElement
     */
    protected WebElement getFirstNameValidator() {
        firstNameValidator = driver
                .findElement(By.cssSelector(FIRST_NAME_VALIDATOR_SELECTOR));
        return firstNameValidator;
    }

    /**
     * getFirstNameValidatorText
     * @return String
     */
    protected String getFirstNameValidatorText() {
        return getFirstNameValidator().getText();
    }

    /**
     * isDisplayedFirstNameValidator
     * @return boolean
     */
    protected boolean isDisplayedFirstNameValidator() {
        return getFirstNameValidator().isDisplayed();
    }

    /**
     * sizeFirstNameValidator
     * @return boolean
     */
    protected boolean sizeFirstNameValidator() {
        return driver
                .findElements(By.cssSelector(FIRST_NAME_VALIDATOR_SELECTOR))
                .size() != 0;
    }

//  lastNameValidator

//  registrationValidator
    /**
     * setRegistrationValidator
     * @param registrationValidator WebElement
     * @return RegisterPart
     */
    protected RegisterPart setRegistrationValidator(WebElement registrationValidator) {
        this.registrationValidator = registrationValidator;
        return this;
    }

    /**
     * getEmailValidator
     * @return WebElement
     */
    protected WebElement getRegistrationValidator() {
        registrationValidator = driver.findElement(By.cssSelector(REGISTRATION_VALIDATOR_SELECTOR));
        return registrationValidator;
    }

    /**
     * getEmailValidatorText
     * @return String
     */
    public String getRegistrationValidatorText() {
        return getRegistrationValidator().getText();
    }

    /**
     * isDisplayedEmailValidator
     * @return boolean
     */
    public boolean isDisplayedRegistrationValidator() {
        return getRegistrationValidator().isDisplayed();
    }

    /**
     * sizeEmailValidator
     * @return boolean
     */
    protected boolean sizeRegistrationValidator() {
        return driver.findElements(By.cssSelector(REGISTRATION_VALIDATOR_SELECTOR))
                .size() != 0;
    }
    
//  emailValidator
    @Override
    protected WebElement getEmailValidator() {
        emailValidator = driver.findElement(By.xpath(EMAIL_VALIDATOR_SELECTOR));
        return emailValidator;
    }

    @Override
    protected boolean sizeEmailValidator() {
        return driver.findElements(By.xpath(EMAIL_VALIDATOR_SELECTOR))
                .size() != 0;
    }

//  passwordValidator
    @Override
    protected WebElement getPasswordValidator() {
        passwordValidator = driver
                .findElement(By.cssSelector(PASSWORD_VALIDATOR_SELECTOR));
        return passwordValidator;
    }

    @Override
    protected boolean sizePasswordValidator() {
        return driver.findElements(By.cssSelector(PASSWORD_VALIDATOR_SELECTOR))
                .size() != 0;
    }

//  passwordConfirmValidator
    @Override
    protected WebElement getPasswordConfirmValidator() {
        passwordConfirmValidator = driver.findElement(
                By.cssSelector(PASSWORD_CONFIRM_VALIDATOR_SELECTOR));
        return passwordConfirmValidator;
    }

    @Override
    protected boolean sizePasswordConfirmValidator() {
        return driver
                .findElements(
                        By.cssSelector(PASSWORD_CONFIRM_VALIDATOR_SELECTOR))
                .size() != 0;
    }

    // Functional
    @Override
    protected GoogleAccountPage clickSignUpGoogleAccountButton() {
        String currentTab = driver.getWindowHandle();
        clickGoogleLoginButton();
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

    public LoginPage gotoLoginPage() {
        return new LoginPage(driver);
    }
}
