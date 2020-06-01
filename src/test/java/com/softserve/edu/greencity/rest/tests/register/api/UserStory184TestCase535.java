package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC535Data;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

/**
 * UserStory184TestCase535 class. Negative test of registration user with bad credentials.
 * (Jira Story: SC-184/GC-468; Test GC-535)
 * Verify that user is not registered, when ‘Password’ field is empty via /ownSecurity/signUp call.
 * @author SergiiK
 * 2020-06-02
 */
public class UserStory184TestCase535 extends GreencityRestTestRunner {

    /**
     * Credentials for already existing user: email: "qtiguoku@ttirv.net";
     * name: "Sergii_Test534"; 
     * password: "".
     * @return
     */
    @DataProvider
    public Object[][] badUserCredentials() {
        return new Object[][] { { UserRepository.get().userForUserStory184TestCase535(), Languages.ENGLISH }, };
    }

    /**
     * Negative test Verify that the user cannot register with empty password field. 
     * @param user's credentials.
     */
    @Test(dataProvider = "badUserCredentials")
    public void checkUserRegistrationWithEmptyPassword(User badUserCredentials, Languages languages) {
        logger.info("Jira Story: SC-184/GC-468; Test GC-535");
        logger.info("Verify that user is not registered, when ‘Password’ field is empty via /ownSecurity/signUp call.");
        logger.info("start test checkUserRegistrationWithEmptyPassword with user = " + badUserCredentials.toString());
        //
        logger.info("REST: register a user with bad credentials");
        GC535Data unsuccessfulRegistration = loadApplication().userStory184Test535(languages, badUserCredentials);
        Assert.assertEquals(unsuccessfulRegistration.getName(), GC535Data.EXPECTED_NAME, "expected name isn't match");
        Assert.assertEquals(unsuccessfulRegistration.getMessage(), GC535Data.EXPECTED_MESSAGE, "expected message isn't match");
    }

}
