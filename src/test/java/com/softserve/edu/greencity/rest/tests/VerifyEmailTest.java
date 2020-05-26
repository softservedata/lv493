package com.softserve.edu.greencity.rest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.VerifyEmail;
import com.softserve.edu.greencity.rest.services.LogginedUserService;

public class VerifyEmailTest extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] users() {
        return new Object[][] { { UserRepository.get().temporary2() } };
    }

    @Test(dataProvider = "users")
    public void checkVerifyEmail(User user) {
        logger.info("Start checkGoogleSecurity(" + user + ")");
        LogginedUserService logginedUserService = loadApplication().successfulUserLogin(user);
        System.out.println("logginedUserEntity = " + logginedUserService.getLogginedUserEntity());
        VerifyEmail verifyEmail = logginedUserService.verifyEmail();
        System.out.println("verifyEmailService = " + verifyEmail);
//      Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(),
//              user.getName());
    }
}
