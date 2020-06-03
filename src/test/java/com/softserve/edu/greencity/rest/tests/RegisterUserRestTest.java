package com.softserve.edu.greencity.rest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.ui.data.Languages;

import io.qameta.allure.Description;

/**
 * Registration new user with a random name and email address from a temporary
 * mail-box.
 * @author Serg
 */
public class RegisterUserRestTest extends GreencityRestRegisterTestRunner {

    /**
     * Random credentials: first name - random 20 letters, password - "A475asd123*", language - En.
     * @return
     */
    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] { { UserRepository.get().temporaryUserCredentialsForRegistration(), Languages.ENGLISH }, };
    }

    /**
     * Test of successful user registration.
     * @param userLoginCredentials User
     * @param languages Enum
     * @throws Exception need delay for transfer state 'verify email'
     */
    @Description("Test of successful user registration.")
//  @Issue("---")
//  @Story("---")
//  @Step("---")
    @Parameters({"User credentials", "languages"})
    @Test(dataProvider = "validCredentialUser")
    public void checkRegistrationREST(User userLoginCredentials, Languages languages) throws Exception {
        logger.info("start test checkRegistrationREST with user = " + userLoginCredentials.toString());
        //
        logger.info("REST: register new User with random credential and temporary email");
        RegisterUserEntity registerUserEntity = loadApplication().successfulUserRegistration(languages, userLoginCredentials, driver);
        Assert.assertTrue(registerUserEntity.isOwnRegistrations(), "registration not successful");
        //
        // ----------logging---------------
        Thread.sleep(2000); // need delay for transfer state 'verify email' to API
        //
        logger.info("Start logging user (" + userLoginCredentials + ")");
        LogginedUserService logginedUserService = loadApplication().successfulUserLogin(userLoginCredentials);
        Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(), userLoginCredentials.getName(), "logging not successful");
    }

}
