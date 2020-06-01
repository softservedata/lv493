package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] validUser() {
        return new Object[][] { { UserRepository.get().temporary() } };
    }

    @DataProvider
    public Object[][] wrongUser() {
        return new Object[][] { { UserRepository.get().wrongUserCredentials() } };
    }

    @Test(dataProvider = "validUser")
    public void successfulLogin(User user) {
        logger.info("Start checkLogin(" + user + ")");
        LogginedUserService logginedUserService = loadApplication()
                .successfulUserLogin(user);
        logger.info("logginedUserEntity = "
                + logginedUserService.getLogginedUserEntity());
        Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(),
                user.getName());
    }

    @Test(dataProvider = "wrongUser", expectedExceptions = GreencityRestTestRunner.class)
    public void unsuccessfulLogin(User user) {
        logger.info("Start checkLogin(" + user + ")");
        LogginedUserService logginedUserService = loadApplication()
                .successfulUserLogin(user);
    }
}
