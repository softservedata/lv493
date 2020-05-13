package com.softserve.edu.greencity.ui.tests;

import java.util.concurrent.TimeUnit;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import org.testng.Assert;
import org.testng.annotations.*;

import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.common.LoginDropdown;

public class LoginDropdownTest extends LoginTest {
    LoginDropdown loginDropdown;

    @BeforeMethod
    public void openLoginDropdown() {
        logger.info("Open Login Dropdown");
        loginDropdown = loadApplication().navigateMenuMyCabinetGuest().signin();
        loginPart = loginDropdown;
    }

    @AfterMethod
    @Override
    public void logout() {
        if (resultPage == null){
            resultPage = loginDropdown.closeDropdown().navigateMenuMyCabinetGuest();
        }
        super.logout();
    }
}
