package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;
import com.softserve.edu.greencity.ui.pages.common.LoginPart;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public abstract class LoginTest extends GreencityTestRunner {

    protected LoginPart loginPart;
    protected TopPart resultPage;

    @DataProvider
    public Object[][] validLoginCredentials() {
        return new Object[][] {
                { UserRepository.get().validLoginUserCredentials() }, };
    }


    @DataProvider
    public Object[][] wrongLoginCredentials() {
        return new Object[][] {
                { UserRepository.get().wrongLoginUserCredentials() }, };
    }

    @Test
    public void checkAllElements() {
        logger.info("Check email field");
        Assert.assertTrue(loginPart.getEmailField().isDisplayed());

        logger.info("Check password field");
        Assert.assertTrue(loginPart.getPasswordField().isDisplayed());

        logger.info("Check \"forgot password\" link");
        Assert.assertTrue(loginPart.getForgotPasswordLink().isDisplayed());

        logger.info("Check Sign-In button");
        Assert.assertTrue(loginPart.getSignInButton().isDisplayed());

        logger.info("Check Google Sign-In button");
        Assert.assertTrue(loginPart.getGoogleSigningButton().isDisplayed());

        logger.info("Check Sign-Up link");
        Assert.assertTrue(loginPart.getSignUpLink().isDisplayed());
    }

    @Test(dataProvider = "validLoginCredentials")
    public void checkSuccessfullyLogin(User user) {
        logger.info("Filling all fields for logging");
        resultPage = loginPart.successfullyLogin(user);

        Assert.assertNotNull(resultPage.getTopUserName());
        logger.info("User is Signed in successfully");
    }

    @Test(dataProvider = "wrongLoginCredentials")
    public void checkUnsuccessfullyLogin(User user) {
        logger.info("Filling all fields for logging");
        loginPart = loginPart.unsuccessfullyLogin(user);
        List<String> errors = loginPart.getErrorMassages();
        Assert.assertNotNull(errors);
        logger.info("User is not Signed in because:\n" + String.join(",", errors));
    }


    @AfterMethod
    public void logout() {
        System.out.println(resultPage.getTopUserName());
        if (resultPage != null) {

            resultPage.signout();
        }
    }

}
