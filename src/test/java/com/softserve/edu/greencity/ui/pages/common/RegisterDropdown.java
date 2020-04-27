package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.cabinet.GoogleAccountPage;

public class RegisterDropdown {

    private WebDriver driver;
    //
    private WebElement titleField;
    private WebElement emailField;
    private WebElement personNameField;
    private WebElement passwordField;
    private WebElement showPasswordButton;
    private WebElement passwordConfirmField;
    private WebElement showPasswordConfirmButton;
    private WebElement submitButton;
    private WebElement signInLink;
    private WebElement signUpGoogleButton;
    //
//    private WebElement personNameValidator;
    private WebElement emailValidator;
    private WebElement passwordValidator;
    private WebElement passwordConfirmValidator;
    //
    private String TAG_ATTRIBUTE_VALUE = "placeholder";
    //
    LoginDropdown loginDropdown;
    GoogleAccountPage googleAccountPage;

    public RegisterDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        titleField = driver.findElement(By.cssSelector("h1[title-text]"));
        emailField = driver.findElement(By.cssSelector("input[name='email']"));
        personNameField = driver
                .findElement(By.cssSelector("input[name='fistName']"));
        passwordField = driver.findElement(
                By.cssSelector("input[name='form-control password']"));
        showPasswordButton = driver.findElement(
                By.xpath("//input[@name='form-control password']/../span/img"));
        passwordConfirmField = driver.findElement(
                By.cssSelector("input[name='form-control password-confirm']"));
        showPasswordConfirmButton = driver.findElement(By.xpath(
                "//input[@name='form-control password-confirm']/../span/img"));
        submitButton = driver.findElement(By.cssSelector(
                "div[class='form-content-container'] button[class*='global-button']"));
        signInLink = driver.findElement(By.cssSelector("div.exist-account a"));
        signUpGoogleButton = driver.findElement(By.cssSelector(
                "div[class='form-content-container'] button[class*='button-google']"));
//
//        // init Validators
//        emailValidator = driver.findElement(By.xpath(
//                "//form[contains(@class,'ng-touched')]/div/input[@name='email']/following-sibling::div[contains(@class,'error-message')][1]")); // FIXME
//                                                                                                                                                // selector
//        passwordValidator = driver.findElement(By.xpath(
//                "//form[contains(@class,'ng-touched')]/div/input[@name='email']/following-sibling::div[contains(@class,'error-message')][2]")); // FIXME
//                                                                                                                                                // selector
//        passwordConfirmValidator = driver.findElement(By.xpath(
//                "//form[contains(@class,'ng-touched')]/div/input[@name='email']/following-sibling::div[contains(@class,'error-message')][3]")); // FIXME
//                                                                                                                                                // selector
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
    
//  personNameField
    public WebElement getPersonNameField() {
        return personNameField;
    }

    public String getPersonNameFieldText() {
        return getPersonNameField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearPersonNameField() {
        getPersonNameField().clear();
    }

    public void clickPersonNameField() {
        getPersonNameField().click();
    }

    public void setPersonNameField(String text) {
        getPersonNameField().sendKeys(text);
    }

    public boolean isDisplayedPersonNameField() {
        return getPersonNameField().isDisplayed();
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

    public String getPasswordConfirmFieldText() {
        return getPasswordConfirmField().getAttribute(TAG_ATTRIBUTE_VALUE);
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

    public void clickShowPasswordConfirmButton() {
        if (isDisplayedShowPasswordConfirmButton()) {
            getShowPasswordConfirmButton().click();
        }
    }

    public boolean isDisplayedShowPasswordConfirmButton() {
        return getShowPasswordConfirmButton().isDisplayed();
    }
    
//  submitButton
    public WebElement getSubmitButton() {
        return submitButton;
    }

    public String getSubmitButtonText() {
        return getSubmitButton().getText();
    }

    public void clickSubmitButton() {
        if (isDisplayedSubmitButton()) {
            getSubmitButton().click();
        }
    }

    public boolean isDisplayedSubmitButton() {
        return getSubmitButton().isDisplayed();
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
    
//  signUpGoogleButton
    public WebElement getSignUpGoogleButton() {
        return signUpGoogleButton;
    }

    public String getSignUpGoogleButtonText() {
        return getSignUpGoogleButton().getText();
    }

    public void clickSignUpGoogleButton() {
        if (isDisplayedSignUpGoogleButton()) {
            getSignUpGoogleButton().click();
        }
    }

    public boolean isDisplayedSignUpGoogleButton() {
        return getSignUpGoogleButton().isDisplayed();
    }
    
//  emailValidator
  public WebElement getEmailValidator() {
      return emailValidator;
  }

  public String getEmailValidatorText() {
      return getEmailValidator().getText();
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

 
  public boolean isDisplayedPasswordValidator() {
      return getPasswordValidator().isDisplayed();
  }
  
//  passwordConfirmValidator
  public WebElement getPasswordConfirmValidator() {
      return passwordConfirmValidator;
  }

  public String getPasswordConfirmValidatorText() {
      return getPasswordConfirmValidator().getText();
  }

 
  public boolean isDisplayedPasswordConfirmValidator() {
      return getPasswordConfirmValidator().isDisplayed();
  }

    // Functional
  public void clickEmailGoogleAccountField() {
      googleAccountPage = new GoogleAccountPage(driver);
      googleAccountPage.clickEmailField();
  }
  
  public void enterEmailGoogleAccountField(String email) {
      googleAccountPage.clickEmailField();
      googleAccountPage.clearEmailField();
      googleAccountPage.setEmailField(email);
  }
  
  public void clickEmailNextGoogleAccountButton() {
      googleAccountPage.clickEmailNextButton();
  }
  public void enterPasswordGoogleAccountField(String password) {
      googleAccountPage.clickEnterPasswordGoogleAccountField();
      googleAccountPage.clearEnterPasswordGoogleAccountField();
      googleAccountPage.setEnterPasswordGoogleAccountField(password);
  }
  
  public void clickShowPasswordGoogleAccountButton() {
      googleAccountPage.clickShowPasswordGoogleAccountButton();
  }
  
  public void clickNextGoogleAccountButton() {
      googleAccountPage.clickNextButton();
  }

    // Business Logic
}
