package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.common.LoginDropdown;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends GreencityTestRunner {
    @Test
    public void checkDropdown() { // for debugging
        LoginDropdown dropdown = loadApplication().gotoLoginDropdown();
        dropdown.inputEmail("xoboj58975@2go-mail.com")
                .inputPassword("werty42?")
                .gotoForgotPassword();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void checkPage() { // for debugging
        loadApplication().navigateMenuMyCabinet();
        LoginPage page = new LoginPage(driver);
        page.inputEmail("xoboj58975@2go-mail.com")
                .inputPassword("werty42?")
                .clickLoginButton();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
}
