package com.softserve.edu.greencity.rest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;
import com.softserve.edu.greencity.ui.data.Languages;

import io.qameta.allure.Description;

/**
 * RegisterUserRestTest2 class.
 * Negative test of registration existing user.
 * (Jira Story: SC-184/GC-468; Test GC-528)
 * @author Serg
 */
public class RegisterUserRestTest2 extends GreencityRestTestRunner {

    /**
     * Credentials for already existing user:
     * email: gceurzwfejqtiguoku@ttirv.net;
     * name: Sergii_Test;
     * password: A475asd123*.
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
    @Description("Negative test of registration existing user.")
//  @Issue("---")
//  @Story("---")
//  @Step("---")
    @Parameters({"User credentials", "languages"})
    @Test(dataProvider = "credentialsAlreadyExistingUser")
    public void checkAlreadyExistingUserRegistration(User credentialsAlreadyExistingUser, Languages languages) {
        logger.info("start test checkAlreadyExistingUserRegistration with user = " + credentialsAlreadyExistingUser.toString());
        //
        logger.info("REST: register already existing user");
        RegisterUserEntity unsuccessfulRegistration = loadApplication().unsuccessfulUserRegistration(languages,
                credentialsAlreadyExistingUser);
        Assert.assertTrue(unsuccessfulRegistration.getMessage().contains("User with this email is already registered"),
                "registration already existing user is successful");
    }

}
