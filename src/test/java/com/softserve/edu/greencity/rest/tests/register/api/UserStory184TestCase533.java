package com.softserve.edu.greencity.rest.tests.register.api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC528Data;
import com.softserve.edu.greencity.rest.data.jira.testcases.GC533Data;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.rest.tests.GreencityRestRegisterTestRunner;
import com.softserve.edu.greencity.ui.data.Languages;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

/**
 * UserStory184TestCase533 class. Negative test of the user logging.
 * (Jira Story: SC-184/GC-468; Test GC-533)
 * Verify that user is not registered if he didn’t verify email address in email box via /ownSecurity/signUp call.
 * @author SergiiK
 * 2020-06-02
 */
public class UserStory184TestCase533 extends GreencityRestRegisterTestRunner {

    /**
     * Random credentials: first name - random 20 letters, password - "A475asd123*", language - En.
     * @return
     */
    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] { { UserRepository.get().temporaryUserCredentialsForRegistration(), Languages.ENGLISH }, };
    }

    /**
     * Test of successful user registration and negative logging.
     * @param userLoginCredentials User
     * @param languages Enum
     * @throws Exception need delay for transfer state 'verify email'
     */
    @Description("Test of successful user registration and negative logging.")
    @Issue("GC-533")
    @Story("Verify that user is not registered if he didn’t verify email address in email box via /ownSecurity/signUp call.")
    @Step("9. Check response (message)")
    @Parameters({"User credentials", "languages"})
    @Test(dataProvider = "validCredentialUser")
    public void checkRegistrationREST(User userLoginCredentials, Languages languages) throws Exception {
        logger.info("Jira Story: SC-184/GC-468; Test GC-533");
        logger.info("Verify that user is not registered if he didn’t verify email address in email box via /ownSecurity/signUp call.");
        logger.info("start test checkRegistrationREST with user = " + userLoginCredentials.toString());
        //
        logger.info("REST: register new User with random credential and temporary email");
        GC533Data resultGC533Data = loadApplication().userStory184Test533(languages, userLoginCredentials, driver);
        Assert.assertTrue(resultGC533Data.isOwnRegistrations(), "registration not successful");
        Assert.assertEquals(resultGC533Data.getMessage(), GC533Data.EXPECTED_MESSAGE, "expected message isn't match");
    }

}
