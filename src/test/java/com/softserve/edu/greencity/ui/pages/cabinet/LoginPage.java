package com.softserve.edu.greencity.ui.pages.cabinet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.pages.common.UserEnterPage;
import com.softserve.edu.greencity.ui.tools.LoginPart;
import com.softserve.edu.greencity.ui.tools.RegisterPart;

public class LoginPage extends TopPart{

    private LoginComponent loginComponent;

    public LoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        loginComponent = new LoginComponent(driver);
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    // proxy methods

    public LoginPage inputEmail(String email) {
        this.getLoginComponent().getEmailField().sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        this.getLoginComponent().getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        this.getLoginComponent().getSignInButton().click();
        return this;
    }

    public LoginPage clickGoogleLoginButton() {
        this.getLoginComponent().getGoogleSigningButton().click();
        return this;
    }
    
 // Business Logic author Serge
    /**
     * clickSignUp
     * @return LoginPart
     */
    public RegisterPage clickSignUpLink() {
        this.getLoginComponent().clickSignUpLink().gotoRegister();
        return new MyCabinetPage(driver).gotoRegisterPage();
    }
    

}