package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterPage;

/**
 * RegisterPageTest class (doesn't working correctly!).
 * @author Serg
 */
public class RegisterPageTest extends GreencityTestRunner {

    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] {
                { UserRepository.getDefaultUserCredentials() }, };
    }
    
    @DataProvider
    public Object[][] validCredentialUser2() {
        return new Object[][] {
                { UserRepository.getTemporaryUserCredentialsForRegistration() }, };
    }

    @DataProvider
    public Object[][] invalidCredentialUser() {
        return new Object[][] { { UserRepository.getWrongUserCredentials1() },
                { UserRepository.getWrongUserCredentials2() }, 
                };
    }

    @Test(dataProvider = "validCredentialUser")
    public void checkRegisterPage1(User userLoginCredentials) {
        System.out.println("-----validCredentialUser--------");
        loadApplication().navigateMenuMyCabinetGuest();
        RegisterPage registerPage = new LoginPage(driver).gotoRegisterPage();
        //
        Assert.assertEquals("Hello!", registerPage.getTitleFieldText(), "you did not go to the page RegisterPage");
        System.out.println("registerPage.getTitleFieldText(): "
                + registerPage.getTitleFieldText());
        registerPage.fillFieldsWithoutRegistration(userLoginCredentials);
        presentationSleep(2);
        LoginPage loginPage = registerPage.clickSignInLink();
        loginPage.gotoRegisterPage();
        Assert.assertEquals("Hello!", registerPage.getTitleFieldText(), "you did not go to the page RegisterPage");
//        registerPage.clickSignUpButton();
        presentationSleep(2);
    }
    
    @Test(dataProvider = "invalidCredentialUser")
    public void checkRegisterPage2(User userLoginCredentials) {
        System.out.println("-----invalidCredentialUser--------");
        loadApplication().navigateMenuMyCabinetGuest();
        RegisterPage registerPage = new LoginPage(driver).gotoRegisterPage();
        System.out.println("registerPage.getTitleFieldText(): "
                + registerPage.getTitleFieldText());
        registerPage.registrationUser(userLoginCredentials);
        System.out.println("registerPage.getFirstNameErrorText(): " + registerPage.getFirstNameErrorText());
        System.out.println("registerPage.getEmailErrorText(): " + registerPage.getEmailErrorText());
        System.out.println("registerPage.getPasswordErrorText(): " + registerPage.getPasswordErrorText());
        System.out.println("registerPage.getPasswordConfirmErrorText(): " + registerPage.getPasswordConfirmErrorText());
        System.out.println("registerPage.getRegistrationErrorText(): " + registerPage.getRegistrationErrorText());
        presentationSleep(2);
    }
    
    @Test(dataProvider = "validCredentialUser2")
    public void checkRegistation1(User userLoginCredentials) {
        System.out.println("-----validCredentialUser--------");
        loadApplication().navigateMenuMyCabinetGuest();
        RegisterPage registerPage = new LoginPage(driver).gotoRegisterPage();
        //
        Assert.assertEquals("Hello!", registerPage.getTitleFieldText(), "you did not go to the page RegisterPage");
        System.out.println("registerPage.getTitleFieldText(): "
                + registerPage.getTitleFieldText());
        registerPage.registrationNewRandomUser(userLoginCredentials);
        System.out.println("registerPage.getConfirmRegistrationText(): " + registerPage.getConfirmRegistrationText());
        Assert.assertTrue(registerPage.getConfirmRegistrationText().contains("You have successfully registered"), "you not complete registration");
        presentationSleep(2);
    }
    
    @Test(dataProvider = "validCredentialUser2")
    public void checkRegistation2(User userLoginCredentials) {
        System.out.println("-----validCredentialUser--------");
        loadApplication().navigateMenuMyCabinetGuest();
        RegisterPage registerPage = new LoginPage(driver).gotoRegisterPage();
        Assert.assertEquals(registerPage.getTitleFieldText(), "Hello!", "you did not go to the page RegisterPage");
        System.out.println("registerPage.getTitleFieldText(): "
                + registerPage.getTitleFieldText());
        //
        registerPage.registrationNewRandomUser(userLoginCredentials);
        System.out.println("registerPage.getConfirmRegistrationText(): " + registerPage.getConfirmRegistrationText());
        Assert.assertTrue(registerPage.getConfirmRegistrationText().contains("You have successfully registered"), "you did not go to the page RegisterPage");
        //
        registerPage.navigateMenuMyCabinetGuest();
        LoginPage page = new LoginPage(driver);
        page.inputEmail(userLoginCredentials.getEmail())
        .inputPassword(userLoginCredentials.getPassword())
        .clickLoginButton();
        System.out.println("driver.getTitle()" + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Home", "you didn't log in successfully");
    }
}
