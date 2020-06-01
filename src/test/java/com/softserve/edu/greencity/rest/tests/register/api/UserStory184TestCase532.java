package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC532Data;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

/**
 * UserStory184TestCase532 class.
 * Negative test of registration existing user.
 * (Jira Story: SC-184/GC-468; Test GC-532)
 * Verify that user is not registered, when all values in request are empty via /ownSecurity/signUp call.
 * @author SergiiK
 * 2020-06-02
 */
public class UserStory184TestCase532 extends GreencityRestTestRunner {

    /**
     * Empty credentials for user:
     * email: "";
     * name: "";
     * password: "".
     * @return
     */
    @DataProvider
    public Object[][] emptyCredentialsForUser() {
        return new Object[][] { { UserRepository.get().userForUserStory184TestCase532(), Languages.ENGLISH }, };
    }

    // TODO
    /**
     * Negative test user registration with empty credentials.
     * @param Credentials.
     */
    @Test(dataProvider = "emptyCredentialsForUser")
    public void checkAlreadyExistingUserRegistration(User emptyCredentialsForUser, Languages languages) {
        logger.info("Jira Story: SC-184/GC-468; Test GC-532");
        logger.info("Verify that user is not registered, when all values in request are empty via /ownSecurity/signUp call.");
        logger.info("start test checkAlreadyExistingUserRegistration with user = " + emptyCredentialsForUser.toString());
        //
        logger.info("REST: register already existing user");
        GC532Data unsuccessfulRegistration = loadApplication().userStory184Test532(languages,
                emptyCredentialsForUser);
        System.out.println("****.getMessage(): " + unsuccessfulRegistration.getMessage());
//        Assert.assertTrue(unsuccessfulRegistration.getMessage().contains("User with this email is already registered"),
//                "registration already existing user is successful");
    }

}
