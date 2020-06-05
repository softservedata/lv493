package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC535Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC536Data;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

/**
 * UserStory184TestCase535 class. Negative test of registration user with bad credentials.
 * (Jira Story: SC-184/GC-468; Test GC-536)
 * Verify that user is not registered, when he enters invalid e-mail format in ‘Email’ value via /ownSecurity/signUp call.
 * @author SergiiK
 * 2020-06-02
 */
public class UserStory184TestCase536 extends GreencityRestTestRunner {

    /**
     * Credentials for already existing user: email: "qtiguokuttirv.net";
     * name: "Sergii_Test536"; password: "Aasdas_123".
     * @return
     */
    @DataProvider
    public Object[][] badUserCredentials() {
        return new Object[][] { { UserRepository.get().userForUserStory184TestCase536(), Languages.ENGLISH }, };
    }

    /**
     * Negative test Verify that the user cannot register with bad email. 
     * @param user's credentials.
     */
    @Description("Negative test Verify that the user cannot register with bad email.")
    @Issue("GC-536")
    @Story("Verify that user is not registered, when he enters invalid e-mail format in ‘Email’ value via /ownSecurity/signUp call.")
    @Step("5. Check response (code, name and message)")
    @Parameters({"User credentials", "languages"})
    @Test(dataProvider = "badUserCredentials")
    public void checkUserRegistrationWithBadEmail(User badUserCredentials, Languages languages) {
        logger.info("Jira Story: SC-184/GC-468; Test GC-536");
        logger.info("Verify that user is not registered, when he enters invalid e-mail format in ‘Email’ value via /ownSecurity/signUp call.");
        logger.info("start test checkUserRegistrationWithBadEmail with user = " + badUserCredentials.toString());
        //
        logger.info("REST: register a user with bad credentials");
        GC536Data unsuccessfulRegistration = loadApplication().userStory184Test536(languages, badUserCredentials);
        Assert.assertEquals(unsuccessfulRegistration.getName(), GC536Data.EXPECTED_NAME, "expected name isn't match");
        Assert.assertEquals(unsuccessfulRegistration.getMessage(), GC536Data.EXPECTED_MESSAGE, "expected message isn't match");
    }

}
