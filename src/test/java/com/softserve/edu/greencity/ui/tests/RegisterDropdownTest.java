package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterPage;
import com.softserve.edu.greencity.ui.pages.common.LoginDropdown;
import com.softserve.edu.greencity.ui.pages.common.RegisterDropdown;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

/**
 * RegisterDropdownTest class (doesn't working correctly!).
 * @author Serg
 */
public class RegisterDropdownTest extends GreencityTestRunner {

    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] {
                { UserRepository.getDefaultUserCredentials() }, };
    }

    @DataProvider
    public Object[][] validCredentialUser2() {
        return new Object[][] { { UserRepository
                .getTemporaryUserCredentialsForRegistration() }, };
    }

    @DataProvider
    public Object[][] invalidCredentialUser() {
        return new Object[][] { { UserRepository.getWrongUserCredentials1() },
                { UserRepository.getWrongUserCredentials2() }, };
    }

    @Test(dataProvider = "validCredentialUser")
    public void checkRegisterDropdown(User userLoginCredentials) {
        System.out.println("-----------validCredentialUser------------");
        RegisterDropdown registerDropdown = loadApplication().signup();
        System.out.println("registerDropdown.getTitleFieldText(): "
                + registerDropdown.getTitlePageText());
        TopPart page = registerDropdown
                .fillFieldsWithoutRegistration(userLoginCredentials);
        LoginDropdown loginDropdown = page.signin();
//        presentationSleep(2);
        registerDropdown = loginDropdown.gotoRegisterDropdown();
        page = registerDropdown.closeRegisterDropdown();
//        TopPart page = registerDropdown.registrationNewUser(userLoginCredentials);
//        Assert.assertEquals(page.getUserComponent().getName(), userLoginCredentials.getFirstName());
//        page.logout();
        presentationSleep(3);
//        registerDropdown.closeRegisterDropdown();
    }

    @Test(dataProvider = "invalidCredentialUser")
    public void checkRegisterDropdown2(User userLoginCredentials) {
        System.out.println("-----------invalidCredentialUser------------");
        RegisterDropdown registerDropdown = loadApplication().signup();
        System.out.println("registerDropdown.getTitleFieldText(): "
                + registerDropdown.getTitlePageText());
        registerDropdown.registrationNewUser(userLoginCredentials);
        System.out.println("registerDropdown.getEmailErrorText(): "
                + registerDropdown.getEmailErrorText());
        System.out.println("registerDropdown.getPasswordErrorText(): "
                + registerDropdown.getPasswordErrorText());
        System.out.println("registerDropdown.getPasswordConfirmErrorText(): "
                + registerDropdown.getPasswordConfirmErrorText());
//        registerDropdown.clickSignUpButton();
        presentationSleep(3);
//        registerDropdown.closeRegisterDropdown();
    }
    
    @Test(dataProvider = "validCredentialUser2")
    public void successRegistrationUser1(User userLoginCredentials) {
        System.out.println("-----validCredentialUser--------");
        RegisterDropdown registerDropdown = loadApplication().signup();
        System.out.println("registerDropdown.getTitleFieldText(): "
                + registerDropdown.getTitlePageText());
        Assert.assertEquals(registerDropdown.getTitlePageText(), "Hello!",
                "you did not go to the page RegisterPage");
        //
        registerDropdown.registrationNewRandomUser(userLoginCredentials);
        System.out.println("registerDropdown.getConfirmRegistrationText(): "
                + registerDropdown.getConfirmRegisterationText());
        Assert.assertTrue(
                registerDropdown.getConfirmRegisterationText()
                        .contains("You have successfully registered"),
                "you did not go to the page RegisterPage");
    }

    // do not end due to alerts presence
//    @Test(dataProvider = "validCredentialUser2")
    public void successRegistrationUser2(User userLoginCredentials) {
        System.out.println("-----validCredentialUser--------");
        RegisterDropdown registerDropdown = loadApplication().signup();
        System.out.println("registerDropdown.getTitleFieldText(): "
                + registerDropdown.getTitlePageText());
        Assert.assertEquals(registerDropdown.getTitlePageText(), "Hello!",
                "you did not go to the page RegisterPage");
        //
        registerDropdown.registrationNewRandomUser(userLoginCredentials);
        System.out.println("registerDropdown.getConfirmRegistrationText(): "
                + registerDropdown.getConfirmRegisterationText());
        Assert.assertTrue(
                registerDropdown.getConfirmRegisterationText()
                        .contains("You have successfully registered"),
                "you did not go to the page RegisterPage");
        //
        // close Alert!
        //
        LoginPage page = loadApplication().navigateMenuMyCabinetGuest();
        page.inputEmail(userLoginCredentials.getEmail())
                .inputPassword(userLoginCredentials.getPassword())
                .clickLoginButton();
        System.out.println("driver.getTitle()" + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Home",
                "you didn't log in successfully");
    }
}
