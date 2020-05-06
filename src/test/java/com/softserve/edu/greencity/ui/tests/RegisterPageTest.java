package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterPage;

/**
 * RegisterPageTest class (doesn't working correctly!).
 * @author Serg
 */
public class RegisterPageTest extends GreencityTestRunner {

//    @DataProvider
//    public Object[][] validCredentialUser() {
//        return new Object[][] {
//                { UserRepository.getDefaultUserCredentials() }, };
//    }

//    @DataProvider
//    public Object[][] invalidCredentialUser() {
//        return new Object[][] { { UserRepository.getWrongUserCredentials1() },
//                { UserRepository.getWrongUserCredentials2() },
//                };
//    }

    //@Test(dataProvider = "validCredentialUser")
    public void checkRegisterPage1(UserData userLoginCredentials) {
        System.out.println("-----validCredentialUser--------");
        loadApplication().navigateMenuMyCabinet();
        RegisterPage registerPage = new LoginPage(driver).gotoRegisterPage();
        System.out.println("registerPage.getTitleFieldText(): "
                + registerPage.getTitleFieldText());
        registerPage.fillFieldsWithoutRegistration(userLoginCredentials);
        presentationSleep(2);
        LoginPage loginPage = registerPage.clickSignInLink();
        loginPage.gotoRegisterPage();
//        registerPage.clickSignUpButton();
        presentationSleep(2);
    }
    
    //@Test(dataProvider = "invalidCredentialUser")
    public void checkRegisterPage2(UserData userLoginCredentials) {
        System.out.println("-----invalidCredentialUser--------");
        loadApplication().navigateMenuMyCabinet();
        RegisterPage registerPage = new LoginPage(driver).gotoRegisterPage();
        System.out.println("registerPage.getTitleFieldText(): "
                + registerPage.getTitleFieldText());
        registerPage.registrationNewUser(userLoginCredentials);
        System.out.println("registerPage.getFirstNameErrorText(): " + registerPage.getFirstNameErrorText());
        System.out.println("registerPage.getEmailErrorText(): " + registerPage.getEmailErrorText());
        System.out.println("registerPage.getPasswordErrorText(): " + registerPage.getPasswordErrorText());
        System.out.println("registerPage.getPasswordConfirmErrorText(): " + registerPage.getPasswordConfirmErrorText());
        System.out.println("registerPage.getRegistrationErrorText(): " + registerPage.getRegistrationErrorText());
        presentationSleep(2);
    }
}
