package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC528Data;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

/**
 * RegisterUserRestTest2 class. Negative test of registration existing user.
 * (Jira Story: SC-184/GC-468; Test GC-528)
 * Verify that the user cannot register with the already registered email address via /ownSecurity/signUp call.
 * @author SergiiK
 * 2020-06-02
 */
public class UserStory184TestCase528 extends GreencityRestTestRunner {

    /**
     * Credentials for already existing user: email: gceurzwfejqtiguoku@ttirv.net;
     * name: Sergii_Test; password: A475asd123*.
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
    @Description("RegisterUserRestTest2 class. Negative test of registration existing user.")
    @Issue("GC-528")
    @Story("Verify that the user cannot register with the already registered email address via /ownSecurity/signUp call.")
    @Step("5. Check response (name and message)")
    @Parameters({"User credentials", "languages"})
    @Test(dataProvider = "credentialsAlreadyExistingUser")
    public void checkAlreadyExistingUserRegistration(User credentialsAlreadyExistingUser, Languages languages) {
        logger.info("Jira Story: SC-184/GC-468; Test GC-528");
        logger.info("Verify that the user cannot register with the already registered email address via /ownSecurity/signUp call.");
        logger.info("start test checkAlreadyExistingUserRegistration with user = " + credentialsAlreadyExistingUser.toString());
        //
        logger.info("REST: register already existing user");
        GC528Data unsuccessfulRegistration = loadApplication().userStory184Test528(languages, credentialsAlreadyExistingUser);
        Assert.assertEquals(unsuccessfulRegistration.getName(), GC528Data.EXPECTED_NAME, "expected name isn't match");
        Assert.assertEquals(unsuccessfulRegistration.getMessage(), GC528Data.EXPECTED_MESSAGE, "expected message isn't match");
    }

}
