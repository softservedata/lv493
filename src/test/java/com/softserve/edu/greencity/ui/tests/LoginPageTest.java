package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class LoginPageTest extends LoginTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void openLoginPage() {
        loginPage = loadApplication().navigateMenuMyCabinetGuest();
        loginPart = loginPage.getLoginComponent();
        resultPage = loginPage;
    }


}
