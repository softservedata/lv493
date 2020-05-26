package com.softserve.edu.greencity.rest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;
import com.softserve.edu.greencity.rest.services.GuestService;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.ui.data.Languages;

public class RegisterUserRestTest extends GreencityRestRegisterTestRunner {

    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] {
                { UserRepository.get().temporaryUserCredentialsForRegistration()
                , Languages.ENGLISH }, 
                 };
    }

    @Test(dataProvider = "validCredentialUser")
    public void checkRegistrationREST(User userLoginCredentials, Languages languages)
            throws Exception {
        logger.info("start test checkRegistrationREST with user = "
                + userLoginCredentials.toString());
        //
        logger.info(
                "REST: register new User with random credential and temporary email");
        RegisterUserEntity registerUserEntity = loadApplication()
                .successfulUserRegistration(languages, userLoginCredentials,
                        driver);
        System.out.println("RegisterUserEntity = "
                + registerUserEntity);
        Assert.assertTrue(registerUserEntity.isOwnRegistrations(), "registration not successfully");
        //
        System.out.println("----------loggin---------------");
        Thread.sleep(2000); // need delay for transfer state 'verify email' to
                            // API
        //
        logger.info("Start checkLogin(" + userLoginCredentials + ")");
        LogginedUserService logginedUserService = loadApplication()
                .successfulUserLogin(userLoginCredentials);
        System.out.println("logginedUserEntity = "
                + logginedUserService.getLogginedUserEntity());
        Assert.assertEquals(
                logginedUserService.getLogginedUserEntity().getName(),
                userLoginCredentials.getName());
    }

}
