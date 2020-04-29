package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class RegisterPage extends TopPart {

    //
    private WebElement titleField;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement showPasswordButton;
    private WebElement passwordConfirmField;
    private WebElement showPasswordConfirmButton;
    private WebElement signUpButton;
    private WebElement signInLink;
    private WebElement signInGoogleButton; // class="wrapper-sign-up" !!!
    //
    private WebElement firstNameValidator;
//    private WebElement lastNameValidator; !!!!!!! not exist
    private WebElement emailValidator;
    private WebElement passwordValidator;
    private WebElement passwordConfirmValidator;
    //
    private String TAG_ATTRIBUTE_VALUE = "text";
    //
    LoginPage loginPage;
    GoogleAccountPage googleAccountPage;

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        titleField = driver
                .findElement(By.cssSelector("form[name='inputform'] h1"));
        firstNameField = driver.findElement(By.cssSelector("form label[for='first-name'] + input"));
        lastNameField = driver.findElement(By.cssSelector("form label[for='last-name'] + input"));
        emailField = driver.findElement(By.cssSelector("form label[for='email'] + input"));
        passwordField = driver.findElement(By.cssSelector("div.password-wrapper input"));
        showPasswordButton = driver.findElement(By.cssSelector("div.password-wrapper div"));
        passwordConfirmField = driver
                .findElement(By.cssSelector("form label[for='password'] + input#password-confirm"));
        showPasswordConfirmButton = driver
                .findElement(By.cssSelector("div.img-confirm"));
        signUpButton = driver.findElement(
                By.xpath("//form[@name='inputform']/button[@type='submit']"));
        signInLink = driver.findElement(By.cssSelector("a[href*='/auth']"));
        signInGoogleButton = driver
                .findElement(By.cssSelector("button[class='google']"));

//        // init Validators
//        firstNameValidator = driver.findElement(By.cssSelector(
//                "div[class='field-wrapper-left'] div[class='ng-star-inserted']"));
//        // lastNameValidator = driver.findElement(By.cssSelector(""));
//        emailValidator = driver
//                .findElement(By.xpath("//div[@id='validation-error']/div"));
//        passwordValidator = driver.findElement(By.xpath(
//                "//div[@class='password-wrapper']/following-sibling::div[1]")); // FIXME
//                                                                                // selector
//        passwordConfirmValidator = driver.findElement(By.xpath(
//                "//div[@class='password-wrapper']/following-sibling::div[3]")); // FIXME
                                                                                // selector
    }

    // Page Object
    // titleField
    public WebElement getTitleField() {
        return titleField;
    }

    public String getTitleFieldText() {
        return getTitleField().getText(); // Welcome back!
    }

    public boolean isDisplayedTitleField() {
        return getTitleField().isDisplayed();
    }

//  firstNameField
    public WebElement getFirstNameField() {
        return firstNameField;
    }

//    public String getFirstNameFieldText() {
//        return getFirstNameField().getAttribute(TAG_ATTRIBUTE_VALUE);
//    }

    public void clearFirstNameField() {
        getFirstNameField().clear();
    }

    public void clickFirstNameField() {
        getFirstNameField().click();
    }

    public void setFirstNameField(String text) {
        getFirstNameField().sendKeys(text);
    }

    public boolean isDisplayedFirstNameField() {
        return getFirstNameField().isDisplayed();
    }

//  lastNameField
    public WebElement getLastNameField() {
        return lastNameField;
    }

    public void clearLastNameField() {
        getLastNameField().clear();
    }

    public void clickLastNameField() {
        getLastNameField().click();
    }

    public void setLastNameField(String text) {
        getLastNameField().sendKeys(text);
    }

    public boolean isDisplayedLastNameField() {
        return getLastNameField().isDisplayed();
    }

//  emailField
    public WebElement getEmailField() {
        return emailField;
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

//  passwordConfirmField
    public WebElement getPasswordConfirmField() {
        return passwordConfirmField;
    }

    public void clearPasswordConfirmField() {
        getPasswordConfirmField().clear();
    }

    public void clickPasswordConfirmField() {
        getPasswordConfirmField().click();
    }

    public void setPasswordConfirmField(String text) {
        getPasswordConfirmField().sendKeys(text);
    }

    public boolean isDisplayedPasswordConfirmField() {
        return getPasswordConfirmField().isDisplayed();
    }

//  showPasswordConfirmButton
    public WebElement getShowPasswordConfirmButton() {
        return showPasswordConfirmButton;
    }

    public String getShowPasswordConfirmButtonText() {
        return getShowPasswordConfirmButton().getText();
    }

    public void clickShowPasswordConfirmButton() {
        if (isDisplayedShowPasswordConfirmButton()) {
            getShowPasswordConfirmButton().click();
        }
    }

    public boolean isDisplayedShowPasswordConfirmButton() {
        return getShowPasswordConfirmButton().isDisplayed();
    }

//  signUpButton
    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public String getSignUpButtonText() {
        return getSignUpButton().getText();
    }

    public void clickSignUpButton() {
        if (isDisplayedSignUpButton()) {
            getSignUpButton().click();
        }
    }

    public boolean isDisplayedSignUpButton() {
        return getSignUpButton().isDisplayed();
    }

//  signInLink
    public WebElement getSignInLink() {
        return signInLink;
    }

    public String getSignInLinkText() {
        return getSignInLink().getText();
    }

    public void clickSignInLink() {
        if (isDisplayedSignInLink()) {
            getSignInLink().click();
        }
    }

    public boolean isDisplayedSignInLink() {
        return getSignInLink().isDisplayed();
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

//    firstNameValidator
    public WebElement getFirstNameValidator() {
        return firstNameValidator;
    }

    public String getFirstNameValidatorText() {
        return getFirstNameValidator().getText();
    }

    public boolean isDisplayedFirstNameValidator() {
        return getFirstNameValidator().isDisplayed();
    }

//    lastNameValidator
//    public WebElement getLastNameValidator() {
//        return lastNameValidator;
//    }
//
//    public String getLastNameValidatorText() {
//        return getLastNameValidator().getText();
//    }
//
//   
//    public boolean isDisplayedLastNameValidator() {
//        return getLastNameValidator().isDisplayed();
//    }

//    emailValidator
    public WebElement getEmailValidator() {
        return emailValidator;
    }

    public String getEmailValidatorText() {
        return getEmailValidator().getText();
    }

    public boolean isDisplayedEmailValidator() {
        return getEmailValidator().isDisplayed();
    }

//    passwordValidator
    public WebElement getPasswordValidator() {
        return passwordValidator;
    }

    public String getPasswordValidatorText() {
        return getPasswordValidator().getText();
    }

    public boolean isDisplayedPasswordValidator() {
        return getPasswordValidator().isDisplayed();
    }

//    passwordConfirmValidator
    public WebElement getPasswordConfirmValidator() {
        return passwordConfirmValidator;
    }

    public String getPasswordConfirmValidatorText() {
        return getPasswordConfirmValidator().getText();
    }

    public boolean isDisplayedPasswordConfirmValidator() {
        return getPasswordConfirmValidator().isDisplayed();
    }

    // LoginPage
    public LoginPage getLoginPage() {
        return new LoginPage(driver);
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
