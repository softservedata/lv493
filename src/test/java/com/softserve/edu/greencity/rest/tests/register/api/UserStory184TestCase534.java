package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC534Data;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

/**
 * UserStory184TestCase534 class. Negative test of registration user with bad credentials.
 * (Jira Story: SC-184/GC-468; Test GC-534)
 * @author Serg
 */
public class UserStory184TestCase534 extends GreencityRestTestRunner {

    /**
     * Credentials for already existing user: email: "";
     * name: Sergii_Test534; password: A475asd123*.
     * @return
     */
    @DataProvider
    public Object[][] badUserCredentials() {
        return new Object[][] { { UserRepository.get().userForUserStory184TestCase534(), Languages.ENGLISH }, };
    }

    /**
     * Negative test Verify that the user cannot register with the already
     * registered email address via /ownSecurity/signUp call.
     * @param Credentials for already existing user.
     */
    @Test(dataProvider = "badUserCredentials")
    public void checkUserRegistrationWithEmptyEmail(User badUserCredentials, Languages languages) {
        logger.info("start test checkUserRegistrationWithEmptyEmail with user = " + badUserCredentials.toString());
        //
        logger.info("REST: register a user with bad credentials");
        GC534Data unsuccessfulRegistration = loadApplication().userStory184Test534(languages, badUserCredentials);
        Assert.assertEquals(unsuccessfulRegistration.getName(), GC534Data.EXPECTED_NAME, "expected name isn't match");
        Assert.assertEquals(unsuccessfulRegistration.getMessage(), GC534Data.EXPECTED_MESSAGE, "expected message isn't match");
    }

}
