package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.common.LoginDropdown;
import com.softserve.edu.greencity.ui.pages.common.RegisterDropdown;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.tools.GetMail10MinTools;

/**
 * RegisterDropdownTest class (doesn't working correctly!).
 * @author Serg
 */
public class RegisterDropdownTest extends GreencityTestRunner {

    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] {
                { UserRepository.get().defaultUserCredentials() }, };
    }

    @DataProvider
    public Object[][] validCredentialUser2() {
        return new Object[][] { { UserRepository.get()
                .temporaryUserCredentialsForRegistration() }, };
    }

    @DataProvider
    public Object[][] invalidCredentialUser() {
        return new Object[][] {
                { UserRepository.get().wrongUserCredentials1() },
                { UserRepository.get().wrongUserCredentials2() }, };
    }

    /**
     * Filling all the fields in the RegisterDropdown window without registering
     * and switch to LoginDropdown.
     * @param userLoginCredentials
     */
    @Test(dataProvider = "validCredentialUser")
    public void checkRegisterDropdown(User userLoginCredentials) {
        logger.info("start test checkRegisterDropdown with user = "
                + userLoginCredentials.toString());
        RegisterDropdown registerDropdown = loadApplication().signup();
        logger.info("get a top title text on the page: "
                + registerDropdown.getTitlePageText());
        logger.info("register new User with valid credential");
        TopPart page = registerDropdown
                .fillFieldsWithoutRegistration(userLoginCredentials);
        //
//      presentationSleep(2);
        logger.info("click Sign-in link and go to LoginDropdown");
        LoginDropdown loginDropdown = page.signin();
        logger.info("click Sign-un link and go to RegisterDropdown");
        registerDropdown = loginDropdown.gotoRegisterDropdown();
        Assert.assertEquals(registerDropdown.getTitlePageText(), "Hello!",
                "you did not go to the page RegisterPage");
        logger.info("close RegisterDropdown");
        page = registerDropdown.closeRegisterDropdown();
    }

    /**
     * Filling all the fields in the RegisterDropdown window using the wrong
     * credentials and reading the error message.
     */
    @Test(dataProvider = "invalidCredentialUser")
    public void checkRegisterDropdown2(User userLoginCredentials) {
        logger.info("start test checkRegisterDropdown2 with user = "
                + userLoginCredentials.toString());
        RegisterDropdown registerDropdown = loadApplication().signup();
        logger.info("get a top title text on the page: "
                + registerDropdown.getTitlePageText());
        logger.info("register new User with wrong credential");
        registerDropdown.registrationNewWrongUser(userLoginCredentials);
        Assert.assertEquals(registerDropdown.getEmailErrorText(),
                "This is not email",
                "the error message does not equal the expected result");
        Assert.assertEquals(registerDropdown.getPasswordErrorText(),
                "Password must be at least 8 characters long",
                "the error message does not equal the expected result");
        Assert.assertEquals(registerDropdown.getPasswordConfirmErrorText(),
                "Passwords do not match",
                "the error message does not equal the expected result");
    }

    /**
     * Test for registration with temporary email and random other credentials
     * without logging.
     * @param userLoginCredentials
     */
    @Test(dataProvider = "validCredentialUser2")
    public void successRegistrationUser1(User userLoginCredentials) {
        logger.info("start test successRegistrationUser1 with user = "
                + userLoginCredentials.toString());
        RegisterDropdown registerDropdown = loadApplication().signup();
        logger.info("get a top title text on the page: "
                + registerDropdown.getTitlePageText());
        Assert.assertEquals(registerDropdown.getTitlePageText(), "Hello!",
                "you did not go to the page RegisterPage");
        //
        logger.info(
                "register new User with random credential and temporary email");
        registerDropdown.registrationNewRandomUser(userLoginCredentials);
        Assert.assertTrue(
                registerDropdown.getConfirmRegisterationText()
                        .contains("You have successfully registered"),
                "you did not go to the page RegisterPage");
    }

    /**
     * Test for registration with temporary email and random other credentials
     * with logging and checking displayed user name in the top of the page.
     * @param userLoginCredentials
     */
    @Test(dataProvider = "validCredentialUser2")
    public void successRegistrationUser2(User userLoginCredentials) {
        logger.info("start test successRegistrationUser2 with user = "
                + userLoginCredentials.toString());
        RegisterDropdown registerDropdown = loadApplication().signup();
        logger.info("get a top title text on the page: "
                + registerDropdown.getTitlePageText());
        Assert.assertEquals(registerDropdown.getTitlePageText(), "Hello!",
                "you did not go to the page RegisterPage");
        //
        logger.info(
                "register new User with random credential and temporary email");
        registerDropdown.registrationNewRandomUser(userLoginCredentials);
        Assert.assertTrue(
                registerDropdown.getConfirmRegisterationText()
                        .contains("You have successfully registered"),
                "you did not go to the page RegisterPage");
        //
        registerDropdown.closeConfirmRegisterationText();
        //
        LoginPage page = loadApplication().navigateMenuMyCabinetGuest();
        logger.info("login with temporary Email and random credential: "
                + userLoginCredentials.toString());
        page.inputEmail(userLoginCredentials.getEmail())
                .inputPassword(userLoginCredentials.getPassword())
                .clickLoginButton(); // not always success after one click (need
                                     // one more click)
        logger.info("get Title curent page: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Home",
                "you didn't log in successfully");
        logger.info("check TopUserName: " + page.getTopUserName());
        Assert.assertEquals(page.getTopUserName(), TopPart.PROFILE_NAME);
    }
}
