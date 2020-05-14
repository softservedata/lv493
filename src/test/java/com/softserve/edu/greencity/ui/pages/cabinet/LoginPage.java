package com.softserve.edu.greencity.ui.pages.cabinet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class LoginPage extends TopPart{

    private LoginComponent loginComponent;
    
    WebDriverWait wait; // ------- author Serge

    public LoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        loginComponent = new LoginComponent(driver);
        wait = new WebDriverWait(driver, 10); // ------- author Serge
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    // proxy methods

    public LoginPage inputEmail(String email) {
        this.getLoginComponent().inputEmail(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        this.getLoginComponent().inputPassword(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        this.getLoginComponent().clickLoginButton();
        // ------- author Serge
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.getLoginComponent().clickLoginButton();
        // -------------
        return this;
    }

    public LoginPage clickGoogleLoginButton() {
        this.getLoginComponent().clickGoogleLoginButton();
        return this;
    }

     public GoogleAccountPage loginByGoogle(){
        this.clickGoogleLoginButton();
        return new GoogleAccountPage(driver);
     }

    public TopPart login(String email, String password) {
        this.inputEmail(email)
                .inputPassword(password)
                .clickLoginButton();
        return new TopPart(driver) {};
    }


    public RegisterPage gotoRegisterPage(){
        return getLoginComponent().gotoRegisterPage();
    }
}
