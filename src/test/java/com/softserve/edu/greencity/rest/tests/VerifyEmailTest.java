package com.softserve.edu.greencity.rest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.VerifyEmail;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.ui.data.Languages;

/**
 * VerifyEmailTest class.
 */
public class VerifyEmailTest extends GreencityRestRegisterTestRunner {

    /**
     * Gives random credentials:
     * email - "";
     * first name - random 20 letters;
     * password - "A475asd123*";
     * @return
     */
    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] { { UserRepository.get().temporaryUserCredentialsForRegistration(), Languages.ENGLISH }, };
    }

    /**
     * Check Verify user's Email using id and token from a 'Verify' letter.
     * @param userLoginCredentials
     * @param languages
     */
    @Test(dataProvider = "validCredentialUser")
    public void checkVerifyEmail(User userLoginCredentials, Languages languages) {
        logger.info("Start checkGoogleSecurity with user = " + userLoginCredentials.toString());
        logger.info("REST: register new User with random credential and temporary email");
        VerifyEmail verifyEmail = loadApplication().successfulUserRegistration2(languages, userLoginCredentials, driver)
                .verifyEmail();
        // ----------logging---------------
        logger.info("Start logging user (" + userLoginCredentials + ")");
        LogginedUserService logginedUserService = loadApplication().successfulUserLogin(userLoginCredentials);
        Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(), userLoginCredentials.getName(),
                "logging not successful");
    }
}
