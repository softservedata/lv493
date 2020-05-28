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

/**
 * RegisterUserRestTest2 class.
 * Negative test of registration existing user.
 * (Jira Story: SC-184/GC-468; Test GC-528)
 * @author Serg
 */
public class RegisterUserRestTest2 extends GreencityRestTestRunner {

    /**
     * Credentials for already existing user:
     * email: gceurzwfejqtiguoku@ttirv.net;
     * name: Sergii_Test;
     * password: A475asd123*.
     * @return
     */
    @DataProvider
    public Object[][] credentialsAlreadyExistingUser() {
        return new Object[][] { { UserRepository.get().alreadyExistingUserCredentials(), Languages.ENGLISH }, };
    }

    /**
     * Negative test Verify that the user cannot register with the already
     * registered email address via /ownSecurity/signUp call.
     * @param Credentials for already existing user.
     */
    @Test(dataProvider = "credentialsAlreadyExistingUser", expectedExceptions = GreenCity400Exception.class)
    public void checkAlreadyExistingUserRegistration(User credentialsAlreadyExistingUser, Languages languages) {
        logger.info("start test checkAlreadyExistingUserRegistration with user = " + credentialsAlreadyExistingUser.toString());
        //
        logger.info("REST: register already existing user");
        List<UnsuccessfulRegistration> unsuccessfulRegistration = loadApplication().unsuccessfulUserRegistration(languages,
                credentialsAlreadyExistingUser);
        Assert.assertTrue(unsuccessfulRegistration.toString().contains("User with this email is already registered"),
                "registration already existing user is successful");
    }

}
