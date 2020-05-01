package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.common.LoginDropdown;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends GreencityTestRunner {
    @Test
    public void test() { // for debugging
        LoginDropdown dropdown = loadApplication().gotoLoginDropdown();
        dropdown.inputEmail("xoboj58975@2go-mail.com")
                .inputPassword("Qwerty42?")
                .clickLoginButton();
        System.out.println();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
}
