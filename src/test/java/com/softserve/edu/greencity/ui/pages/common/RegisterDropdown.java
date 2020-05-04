package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.pages.cabinet.GoogleAccountPage;
import com.softserve.edu.greencity.ui.tools.LoginPart;
import com.softserve.edu.greencity.ui.tools.RegisterPart;

/**
 * RegisterDropdown class.
 * @author Serg
 */
public class RegisterDropdown extends RegisterPart {

    private WebDriver driver;
    private WebDriverWait wait;
    //
    private WebElement closeRegisterDropdownButton;
    //
    private final String EMAIL_VALIDATOR_SELECTOR = "app-new-sign-up input[name='email'] + div div";
    private final String REGISTRATION_VALIDATOR_SELECTOR = "app-new-sign-up input[name='email'] + div div";
//    private final String FIRST_NAME_VALIDATOR_SELECTOR = ""; // not exist
    private final String PASSWORD_VALIDATOR_SELECTOR = "app-new-sign-up input[name='fistName'] + label.content-label + div + div div";
    private final String PASSWORD_CONFIRM_VALIDATOR_SELECTOR = "app-new-sign-up label.content-label.under-error + div + div div";
    //

    /**
     * RegisterDropdown constructor
     * @param driver WebDriver
     */
    public RegisterDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        // init elements
        titleField = driver.findElement(By.cssSelector("h1[title-text]"));
        emailField = driver.findElement(By.cssSelector("input[name='email']"));
        firstNameField = driver
                .findElement(By.cssSelector("input[name='fistName']"));
        passwordField = driver.findElement(
                By.cssSelector("input[name='form-control password']"));
        showPasswordButton = driver.findElement(
                By.xpath("//input[@name='form-control password']/../span/img"));
        passwordConfirmField = driver.findElement(
                By.cssSelector("input[name='form-control password-confirm']"));
        showPasswordConfirmButton = driver.findElement(By.xpath(
                "//input[@name='form-control password-confirm']/../span/img"));
        signUpButton = driver.findElement(By.cssSelector(
                "div[class='form-content-container'] button[class*='global-button']"));
        signInLink = driver.findElement(By.cssSelector("div.exist-account a"));
        googleSignUpButton = driver.findElement(By.cssSelector(
                "div[class='form-content-container'] button[class*='button-google']"));
        closeRegisterDropdownButton = driver.findElement(
                By.cssSelector("app-new-sign-up div.close-btn-img a"));
        wait = new WebDriverWait(driver, 2);
    }

    // Page Object

//  signInLink
    @Override
    public LoginPart gotoLogin() {
        return new LoginDropdown(driver);
    }

    // closeRegisterDropdownButton
    private WebElement getCloseRegisterDropdownButton() {
        return closeRegisterDropdownButton;
    }

    private void clickCloseRegisterDropdownButton() {
        if (isDisplayedCloseRegisterDropdownButton()) {
            getCloseRegisterDropdownButton().click();
        }
    }

    private boolean isDisplayedCloseRegisterDropdownButton() {
        return getCloseRegisterDropdownButton().isDisplayed();
    }

//  registrationValidator
    @Override
    protected WebElement getRegistrationValidator() {
        registrationValidator = driver
                .findElement(By.cssSelector(REGISTRATION_VALIDATOR_SELECTOR));
        return registrationValidator;
    }

    @Override
    protected boolean sizeRegistrationValidator() {
        return driver
                .findElements(By.cssSelector(REGISTRATION_VALIDATOR_SELECTOR))
                .size() != 0;
    }

//  emailValidator
    @Override
    protected WebElement getEmailValidator() {
        emailValidator = driver
                .findElement(By.cssSelector(EMAIL_VALIDATOR_SELECTOR));
        return emailValidator;
    }

    @Override
    protected boolean sizeEmailValidator() {
        return driver.findElements(By.cssSelector(EMAIL_VALIDATOR_SELECTOR))
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
    // a Google window opens and switches to it
    @Override
    public GoogleAccountPage clickSignUpGoogleAccountButton() {
        String currentTab = driver.getWindowHandle();
        clickGoogleLoginButton();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
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

    /**
     * enterEmail
     * @param email String
     * @return RegisterDropdown
     */
    private RegisterDropdown enterEmail(String email) {
        this.clickEmail(driver).clearEmail().setEmailField(emailField)
                .inputEmail(email);
        return this;
    }

    /**
     * enterFirstName
     * @param firstName String
     * @return RegisterDropdown
     */
    private RegisterDropdown enterFirstName(String firstName) {
        this.clickFirstName(driver).clearFirstName()
                .setFirstNameField(firstNameField).inputFirstName(firstName);
        return this;
    }

    /**
     * enterPassword
     * @param password String
     * @return RegisterDropdown
     */
    private RegisterDropdown enterPassword(String password) {
        this.clickPasswordField(driver).clearPasswordField()
                .setPasswordField(passwordField).inputPassword(password)
                .clickShowPasswordButton();
        return this;
    }

    /**
     * enterPasswordConfirm
     * @param passwordConfirm String
     * @return RegisterDropdown
     */
    private RegisterDropdown enterPasswordConfirm(String passwordConfirm) {
        this.clickPasswordConfirmField(driver).clearPasswordConfirmField()
                .setPasswordConfirmField(passwordConfirmField)
                .inputPasswordConfirm(passwordConfirm)
                .clickShowPasswordConfirmButton();
        return this;
    }

    // FIXME
    /**
     * clickSignUpButton
     * @return RegisterDropdown
     */
    private TopPart clickSignUpButton() {
        this.clickRegisterButton();
        return new TopPart(driver) {
        };
    }

//  registrationError
    /**
     * getRegistrationErrorText
     * @return String
     */
    public String getRegistrationErrorText() {
        if (sizeRegistrationValidator() && isDisplayedRegistrationValidator()) {
            return getRegistrationValidatorText();
        }
        return "registration error text not found";
    }

//  emailError
    /**
     * getEmailErrorText
     * @return String
     */
    public String getEmailErrorText() {
        if (sizeEmailValidator() && isDisplayedEmailValidator()) {
            return getEmailValidatorText();
        }
        return "email error text not found";
    }

//  passwordError
    /**
     * getPasswordErrorText
     * @return String
     */
    public String getPasswordErrorText() {
        if (sizePasswordValidator() && isDisplayedPasswordValidator()) {
            return getPasswordValidatorText();
        }
        return "password error text not found";
    }

    // passwordConfirmError
    /**
     * getPasswordConfirmErrorText
     * @return String
     */
    public String getPasswordConfirmErrorText() {
        if (sizePasswordConfirmValidator()
                && isDisplayedPasswordConfirmValidator()) {
            return getPasswordConfirmValidatorText();
        }
        return "password confirm error text not found";
    }

    private void setValidatorMessages() {
//        new ValidatorMessages(getEmailErrorText(), getPasswordErrorText(),
//                getPasswordConfirmErrorText(), getRegistrationErrorText());
    }

//    public ValidatorMessages getErrorMessages(){
//        return ValidatorMessages();
//    }

    // ---!!!! (generic)
    // close register dropdown
    /**
     * closeRegisterDropdown
     */
    private TopPart closeRegisterDropdown() {
        clickCloseRegisterDropdownButton();
        return new TopPart(driver) {
        };
    }

// Business Logic

    /**
     * click on SignIn link and go to the login page
     * @return LoginPart
     */
    public LoginPart gotoLoginPageUsingLink() {
        return this.clickSignInLink().gotoLogin();
    }

    // completion of user registration
    /**
     * Filling all fields on RegisterDropdown page and click on SingUp button.
     * @param userData object with user's credentials
     * @return TopPart page
     */
    public TopPart registrationNewUser(UserData userData) {
        enterEmail(userData.getEmail()).enterFirstName(userData.getFirstName())
                .enterPassword(userData.getPassword())
                .enterPasswordConfirm(userData.getPassword());
        setValidatorMessages();
        return clickSignUpButton();
    }

    /**
     * Filling all fields on RegisterDropdown page without registration (without
     * click on SingUp button) and close RegisterDropdown page.
     * @param userData object with user's credentials
     * @return TopPart page
     */
    public TopPart fillFieldsWithoutRegistration(UserData userData) {
        enterEmail(userData.getEmail()).enterFirstName(userData.getFirstName())
                .enterPassword(userData.getPassword())
                .enterPasswordConfirm(userData.getPassword());
        setValidatorMessages();
        return closeRegisterDropdown();
    }

    /**
     * Filling all fields on RegisterDropdown page without registration, click
     * on SingIn link and go to Login page.
     * @param userData object with user's credentials
     * @return LoginPart page
     */
    public LoginPart fillFieldsAndGotoLoginPage(UserData userData) {
        enterEmail(userData.getEmail()).enterFirstName(userData.getFirstName())
                .enterPassword(userData.getPassword())
                .enterPasswordConfirm(userData.getPassword());
        setValidatorMessages();
        return gotoLoginPageUsingLink();
    }

//    public void clickSignUpGoogle() {
//        clickSignUpGoogleAccountButton();
//    }

}
