package com.softserve.edu.greencity.ui.pages.cabinet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class LoginPage extends TopPart {
    //
    private WebElement titleField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement showPasswordButton;
    private WebElement forgotPasswordLink;
    private WebElement signInButton;
    private WebElement signUpLink;
    private WebElement signInGoogleButton;
    //
    private WebElement emailValidator;
    private WebElement passwordValidator;
    //
    private String TAG_ATTRIBUTE_VALUE = "text";
    //
    RegisterPage registerPage;
    GoogleAccountPage googleAccountPage;

    public LoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        titleField = driver.findElement(By.cssSelector("div[class='sign-in'] h1"));
//      emailField = driver.findElement(By.id("#email"));
        emailField = driver.findElement(By.cssSelector("form[class*='ng-touched'] input[type='email']"));
        passwordField = driver.findElement(By.id("#password"));
        showPasswordButton = driver.findElement(By.id("#img"));
        forgotPasswordLink = driver.findElement(By.cssSelector("a[class*='forgot-password']"));
        signInButton = driver.findElement(By.cssSelector("form[class*='ng-touched'] button[type='submit']"));
        signUpLink = driver.findElement(By.cssSelector("a[href*='auth/sign-up']"));
        signInGoogleButton = driver.findElement(By.cssSelector("button[class*='google']"));
        emailValidator = driver.findElement(By.xpath("//div[contains(@class,'validation-error')][1]"));    //FIXME selector
        passwordValidator = driver.findElement(By.xpath("//div[contains(@class,'validation-error')][2]")); //FIXME selector
    }

    // Page Object
//  titleField
    public WebElement getTitleField() {
        return titleField;
        }
    
    public void clickTitleField() {
        getTitleField().click();
        }
    
    public String getTitleFieldText() {
        return getTitleField().getText();  // Welcome back!
        }
    public boolean isDisplayedTitleField() {
        return getTitleField().isDisplayed();
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
        
//    passwordField
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
            
//    showPasswordButton
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
            
//    forgotPasswordLink
            public WebElement getForgotPasswordLink() {
                return forgotPasswordLink;
            }

            public String getForgotPasswordLinkText() {
                return getForgotPasswordLink().getText();  //  Forgot password?
            }

            public void clickForgotPasswordLink() {
                if (isDisplayedForgotPasswordLink()) {
                    getForgotPasswordLink().click();
                }
            }

            public boolean isDisplayedForgotPasswordLink() {
                return getForgotPasswordLink().isDisplayed();
            }
            
//    signInButton
            public WebElement getSignInButton() {
                return signInButton;
            }

            public String getSignInButtonText() {
                return getSignInButton().getText();    //  Sign-in 
            }

            public void clickSignInButton() {
                if (isDisplayedSignInButton()) {
                    getSignInButton().click();
                }
            }

            public boolean isDisplayedSignInButton() {
                return getSignInButton().isDisplayed();
            }
            
//    signUpLink
            public WebElement getSignUpLink() {
                return signUpLink;
            }

            public String getSignUpLinkText() {
                return getSignUpLink().getText();  //  Sign-up 
            }

            public void clickSignUpLink() {
                if (isDisplayedSignUpLink()) {
                    getSignUpLink().click();
                }
            }

            public boolean isDisplayedSignUpLink() {
                return getSignUpLink().isDisplayed();
            }
            
//    signInGoogleButton
            public WebElement getSignInGoogleButton() {
                return signInGoogleButton;
            }

            public String getSignInGoogleButtonText() {
                return getSignInGoogleButton().getText();  //  Sign-in with Google 
            }

            public void clickSignInGoogleButton(String email, String password) {
                if (isDisplayedSignInGoogleButton()) {
                    getSignInGoogleButton().click();
                    googleAccountPage = new GoogleAccountPage(driver, email);
                    googleAccountPage.clickChosenGoogleAccountField();
                    googleAccountPage.clickEnterPasswordGoogleAccountField();
                    googleAccountPage.setEnterPasswordGoogleAccountField(password);
                    googleAccountPage.clickShowPasswordGoogleAccountButton();
                    googleAccountPage.clickEnterPasswordGoogleAccountField();
                }
            }

            public boolean isDisplayedSignInGoogleButton() {
                return getSignInGoogleButton().isDisplayed();
            }
            
//  emailValidator
            public WebElement getEmailValidator() {
                return emailValidator;
                }
            
            public String getEmailValidatorText() {
                return getEmailValidator().getText();  //  Email is required 
                }
            public boolean isDisplayedEmailValidator() {
                return getEmailValidator().isDisplayed();
            }
            
//  passwordValidator
            public WebElement getPasswordValidator() {
                return passwordValidator;
                }
            
            public String getPasswordValidatorText() {
                return getPasswordValidator().getText();   //  Password is required 
                }
            public boolean isDisplayedPasswordValidator() {
                return getPasswordValidator().isDisplayed();
            }

    // Functional
         // RegisterPage
            public RegisterPage getRegisterPage() {
                return new RegisterPage(driver);
            }

    // Business Logic
}
