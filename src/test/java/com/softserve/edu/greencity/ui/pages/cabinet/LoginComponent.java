package com.softserve.edu.greencity.ui.pages.cabinet;

import com.softserve.edu.greencity.ui.tools.ForgotPasswordPart;
import com.softserve.edu.greencity.ui.tools.LoginPart;
import com.softserve.edu.greencity.ui.tools.RegisterPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginComponent extends LoginPart {

    private final String EMAIL_ID = "email";
    private final String PASSWORD_ID = "password";
    private final String LOGIN_BUTTON_XPATH = "//button[@type='submit' and @class='submit primary-global-button']";
    private final String GOOGLE_LOGIN_BUTTON_CLASS = "google";
    private final String FORGOT_PASSWORD_LINK_CLASS = "forgot-password";

    private final WebDriver driver;

    public LoginComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        this.setEmailField(driver.findElement(By.id(EMAIL_ID)))
                .setPasswordField(driver.findElement(By.id(PASSWORD_ID)))
                .setForgotPasswordLink(driver.findElement(By.className(FORGOT_PASSWORD_LINK_CLASS)))
                .setGoogleSignInButton(driver.findElement(By.className(GOOGLE_LOGIN_BUTTON_CLASS)))
                .setSignInButton(driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)));
    }

    @Override
    public ForgotPasswordPart gotoForgotPassword() {
        return null;
    }

    @Override
    public RegisterPart gotoRegister() {
        return null;
    }
}
