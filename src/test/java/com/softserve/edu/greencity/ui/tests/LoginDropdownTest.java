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
        loginDropdown = loadApplication().signin();
        loginPart = loginDropdown;
    }

    @Override
    public void checkUnsuccessfullyLogin(User user) {
        super.checkUnsuccessfullyLogin(user);
        resultPage = loginDropdown.closeDropdown();
    }

}
