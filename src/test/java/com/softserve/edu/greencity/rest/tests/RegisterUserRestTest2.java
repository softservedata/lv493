package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.UnsuccessfulRegistration;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.tools.GreenCity400Exception;
import com.softserve.edu.greencity.ui.data.Languages;

public class RegisterUserRestTest2 extends GreencityRestTestRunner {
    
    @DataProvider
    public Object[][] credentialsAlreadyExistingUser() {
        return new Object[][] {
                { UserRepository.get().alreadyExistingUserCredentials(), Languages.ENGLISH }, 
        };
    }

    /**
     * Negative test
     * Verify that the user cannot register with the already registered email address via /ownSecurity/signUp call.
     * @param Credentials for already existing user.
     */
    @Test(dataProvider = "credentialsAlreadyExistingUser", expectedExceptions = GreenCity400Exception.class)
    public void checkAlreadyExistingUserRegistration(User credentialsAlreadyExistingUser, Languages languages) {
        logger.info("start test checkAlreadyExistingUserRegistration with user = "
                + credentialsAlreadyExistingUser.toString());
        //
        logger.info(
                "REST: register already existing user");
        List<UnsuccessfulRegistration> unsuccessfulRegistration = loadApplication()
                .unsuccessfulUserRegistration(languages, credentialsAlreadyExistingUser);
        System.out.println("RegisterUserEntity = "
                + unsuccessfulRegistration.toString());
//        Assert.assertFalse(unsuccessfulRegistration, "registration already existing user is successfully");
    }
    
}
