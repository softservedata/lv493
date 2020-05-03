package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.common.TopPart;

/**
 * RegisterPage class.
 * @author Serg
 */
public class RegisterPage extends TopPart {

    private RegisterComponent registerComponent;

    /**
     * RegisterPage constructor.
     * @param driver
     */
    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        registerComponent = new RegisterComponent(driver);
    }

    private RegisterComponent getRegisterComponent() {
        return registerComponent;
    }

    // Business Logic
    
    /**
     * getTitleFieldText
     * @return String
     */
    public String getTitleFieldText() {
        return this.getRegisterComponent().getTitleFieldText();
    }
    
    /**
     * enterEmail
     * @param email String
     * @return RegisterPage
     */
    public RegisterPage enterEmail(String email) {
        this.getRegisterComponent()
            .clickEmail(driver)
            .clearEmail()
            .inputEmail(email);
        return this;
    }

    /**
     * enterFirstName
     * @param firstName String
     * @return RegisterPage
     */
    public RegisterPage enterFirstName(String firstName) {
        this.getRegisterComponent()
            .clickFirstName(driver)
            .clearFirstName()
            .inputFirstName(firstName);
        return this;
    }

    /**
     * enterLastName
     * @param lastName String
     * @return RegisterPage
     */
    public RegisterPage enterLastName(String lastName) {
        this.getRegisterComponent()
            .clickLastName(driver)
            .clearLastName()
            .inputLastName(lastName);
        return this;
    }

    /**
     * enterPassword
     * @param password String
     * @return RegisterPage
     */
    public RegisterPage enterPassword(String password) {
        this.getRegisterComponent()
            .clickPasswordField(driver)
            .clearPasswordField()
            .inputPassword(password)
            .clickShowPasswordButton();
        return this;
    }

    /**
     * enterPasswordConfirm
     * @param passwordConfirm String
     * @return RegisterPage
     */
    public RegisterPage enterPasswordConfirm(String passwordConfirm) {
        this.getRegisterComponent()
            .clickPasswordConfirmField(driver)
            .clearPasswordConfirmField()
            .inputPasswordConfirm(passwordConfirm)
            .clickShowPasswordConfirmButton();
        return this;
    }

    /**
     * clickSignUpButton
     * @return RegisterPage
     */
    public RegisterPage clickSignUpButton() {
        this.getRegisterComponent()
            .clickRegisterButton();
        return this;
    }

    /**
     * clickSignIn
     * @return LoginPart
     */
    public LoginPage clickSignIn() {
        this.getRegisterComponent().clickSignInLink().gotoLogin();
        return new MyCabinetPage(driver).gotoLoginPage();
    }

    /**
     * clickSignUpGoogle
     */
    public void clickSignUpGoogle() {
        this.getRegisterComponent().clickSignUpGoogleAccountButton();
    }

//FirstNameError
    /**
     * getFirstNameErrorText
     * @return String
     */
    public String getFirstNameErrorText() {
        if (getRegisterComponent().sizeFirstNameValidator() 
                && getRegisterComponent().isDisplayedFirstNameValidator()) {
            return getRegisterComponent().getFirstNameValidatorText();
        }
        return "First Name error text not found";
    }

//emailError
    /**
     * getEmailErrorText
     * @return String
     */
    public String getEmailErrorText() {
        if (getRegisterComponent().sizeEmailValidator() 
                && getRegisterComponent().isDisplayedEmailValidator()) {
            return getRegisterComponent().getEmailValidatorText();
        }
        return "email error text not found";
    }

//passwordError
    /**
     * getPasswordErrorText
     * @return String
     */
    public String getPasswordErrorText() {
        if (getRegisterComponent().sizePasswordValidator() 
                && getRegisterComponent().isDisplayedPasswordValidator()) {
            return getRegisterComponent().getPasswordValidatorText();
        }
        return "password error text not found";
    }

//passwordConfirmError
    /**
     * getPasswordConfirmErrorText
     * @return String
     */
    public String getPasswordConfirmErrorText() {
        if (getRegisterComponent().sizePasswordConfirmValidator()
                && getRegisterComponent().isDisplayedPasswordConfirmValidator()) {
            return getRegisterComponent().getPasswordConfirmValidatorText();
        }
        return "password confirm error text not found";
    }

}
