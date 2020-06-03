package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC531Data;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.rest.tests.GreencityRestRegisterTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

/**
 * Registration new user.
 * (Jira Story: GC-184/GC-468; Test GC-531)
 * Verify that user is registered, after he enters valid values via /ownSecurity/signUp call.
 * @author SergiiK
 * 2020-06-02
 */
public class UserStory184TestCase531 extends GreencityRestRegisterTestRunner {

    /**
     * Credentials for Jira Story: GC-184/GC-468; Test GC-531; email - "";first name - "Yuriy";password - "12345Awerty_"; language - En.
     * @return
     */
    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] { { UserRepository.get().userForUserStory184TestCase531(), Languages.ENGLISH }, };
    }

    /**
     * Test of successful user registration.
     * @param userLoginCredentials User
     * @param languages Enum
     * @throws Exception need delay for transfer state 'verify email'
     */
    @Description("Registration new user.")
    @Issue("GC-531")
    @Story("Verify that user is registered, after he enters valid values via /ownSecurity/signUp call.")
    @Step("5. Check response (name)")
    @Parameters({"User credentials", "languages"})
    @Test(dataProvider = "validCredentialUser")
    public void checkUserStory184TestCase531REST(User userLoginCredentials, Languages languages) throws Exception {
        logger.info("Jira Story: GC-184/GC-468; Test GC-531");
        logger.info("Verify that user is registered, after he enters valid values via /ownSecurity/signUp call.");
        logger.info("start test checkUserStory184TestCase531REST with user = " + userLoginCredentials.toString());
        //
        logger.info("REST: register new User with random credential and temporary email");
        GC531Data resultGC531Data = loadApplication().userStory184Test531(languages, userLoginCredentials, driver);
        Assert.assertTrue(resultGC531Data.isOwnRegistrations(), "registration not successful");
        // TODO
//        Assert.assertTrue(resultGC531Data.getHttpsAfterVerify().contains(GC531Data.EXPECTED_URL_AFTER_VERIFY), "you don't redirected to https://***/#/welcome");
        //
        // ----------logging---------------
        Thread.sleep(2000); // need delay for transfer state 'verify email' to API
        //
        logger.info("Start logging user (" + userLoginCredentials + ")");
        LogginedUserService logginedUserService = loadApplication().successfulUserLogin(userLoginCredentials);
        Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(), userLoginCredentials.getName(), "logging not successful");
    }

}
