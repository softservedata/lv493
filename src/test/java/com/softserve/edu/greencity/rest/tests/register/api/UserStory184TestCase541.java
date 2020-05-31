package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC541Data;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

/**
 * UserStory184TestCase541 class. Negative test of registration user with bad
 * credentials. (Jira Story: SC-184/GC-468; Test GC-541)
 * @author Serg
 */
public class UserStory184TestCase541 extends GreencityRestTestRunner {

    /**
     * Bad user credentials (Jira Story: SC-184/GC-468; Test GC-541)email
     * "qtiguoku@ttirv.net";name "Sergii_Test541";password invalid "copter20".
     * @return
     */
    @DataProvider
    public Object[][] badUserCredentials() {
        return new Object[][] { { UserRepository.get().userForUserStory184TestCase541(), Languages.ENGLISH }, };
    }

    /**
     * Negative test Verify that the user cannot register with bad password.
     * @param user's credentials.
     */
    @Test(dataProvider = "badUserCredentials")
    public void checkUserRegistrationWithBadPassword(User badUserCredentials, Languages languages) {
        logger.info("start test checkUserRegistrationWithBadPassword with user = " + badUserCredentials.toString());
        //
        logger.info("REST: register a user with bad credentials");
        GC541Data unsuccessfulRegistration = loadApplication().userStory184Test541(languages, badUserCredentials);
        Assert.assertEquals(unsuccessfulRegistration.getName(), GC541Data.EXPECTED_NAME, "expected name isn't match");
        Assert.assertEquals(unsuccessfulRegistration.getMessage(), GC541Data.EXPECTED_MESSAGE, "expected message isn't match");
    }

}
