package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC534Data;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

/**
 * UserStory184TestCase534 class. Negative test of registration user with bad credentials.
 * (Jira Story: SC-184/GC-468; Test GC-534)
 * Verify that user is not registered, when ‘Email’ value is empty via /ownSecurity/signUp call.
 * @author SergiiK
 * 2020-06-02
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
     * Negative test that the user cannot register with the
     * empty email address via /ownSecurity/signUp call.
     * @param Credentials for already existing user.
     */
    @Description("Negative test of registration user with bad credentials.")
    @Issue("GC-534")
    @Story("Verify that user is not registered, when ‘Email’ value is empty via /ownSecurity/signUp call.")
    @Step("5. Check response (code, name and message)")
    @Parameters({"User credentials", "languages"})
    @Test(dataProvider = "badUserCredentials")
    public void checkUserRegistrationWithEmptyEmail(User badUserCredentials, Languages languages) {
        logger.info("Jira Story: SC-184/GC-468; Test GC-534");
        logger.info("Verify that user is not registered, when ‘Email’ value is empty via /ownSecurity/signUp call.");
        logger.info("start test checkUserRegistrationWithEmptyEmail with user = " + badUserCredentials.toString());
        //
        logger.info("REST: register a user with bad credentials");
        GC534Data unsuccessfulRegistration = loadApplication().userStory184Test534(languages, badUserCredentials);
        Assert.assertEquals(unsuccessfulRegistration.getName(), GC534Data.EXPECTED_NAME, "expected name isn't match");
        Assert.assertEquals(unsuccessfulRegistration.getMessage(), GC534Data.EXPECTED_MESSAGE, "expected message isn't match");
    }

}
