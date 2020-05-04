package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.data.UserData;
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

    // Functional
    
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

    // FIXME
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
     * clickSignInLink
     * @return LoginPart
     */
    public LoginPage clickSignInLink() {
        this.getRegisterComponent().clickSignInLink();
        return new LoginPage(driver);
    }

    /**
     * clickSignUpGoogle
     */
    public void clickSignUpGoogleButton() {
        this.getRegisterComponent().clickSignUpGoogleAccountButton();
    }

//RegistrationError
    /**
     * getRegistrationErrorText
     * @return String
     */
    public String getRegistrationErrorText() {
        if (getRegisterComponent().sizeRegistrationValidator() 
                && getRegisterComponent().isDisplayedRegistrationValidator()) {
            return getRegisterComponent().getRegistrationValidatorText();
        }
        return "Registration error text not found";
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
    
    // Business Logic

    // completion of user registration
    /**
     * Filling all fields on Register page and click on SingUp button.
     * @param userData object with user's credentials
     * @return RegisterPage page
     */
    public RegisterPage registrationNewUser(UserData userData) {
        enterEmail(userData.getEmail()).enterFirstName(userData.getFirstName())
                .enterPassword(userData.getPassword())
                .enterPasswordConfirm(userData.getPassword());
        return clickSignUpButton();
    }

    /**
     * Filling all fields on Register page without registration (without
     * click on SingUp button).
     * @param userData object with user's credentials
     * @return RegisterPage page
     */
    public void fillFieldsWithoutRegistration(UserData userData) {
        enterEmail(userData.getEmail()).enterFirstName(userData.getFirstName())
                .enterPassword(userData.getPassword())
                .enterPasswordConfirm(userData.getPassword());
    }

    /**
     * Filling all fields on Register page without registration, click
     * on SingIn link and go to Login page.
     * @param userData object with user's credentials
     * @return LoginPart page
     */
    public LoginPage fillFieldsAndGotoLoginPage(UserData userData) {
        enterEmail(userData.getEmail()).enterFirstName(userData.getFirstName())
                .enterPassword(userData.getPassword())
                .enterPasswordConfirm(userData.getPassword());
        return clickSignInLink();
    }
}
