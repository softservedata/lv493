package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterPage;
import com.softserve.edu.greencity.ui.pages.home.HomePage;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

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
    public Object[][] invalidCredentialUser() {
        return new Object[][] { { UserRepository.getWrongUserCredentials1() },
                { UserRepository.getWrongUserCredentials2() }, };
    }

    @Test(dataProvider = "validCredentialUser")
    public void checkRegisterPage1(UserData userLoginCredentials) {
        System.out.println("-----validCredentialUser--------");
        RegisterPage registerPage = loadApplication().navigateMenuMyCabinet().gotoLoginPage().clickSignUpLink();
        System.out.println("registerPage.getTitleFieldText(): "
                + registerPage.getTitleFieldText());
        registerPage.fillFieldsWithoutRegistration(userLoginCredentials);
        presentationSleep(2);
        LoginPage loginPage = registerPage.clickSignInLink();
        loginPage.clickSignUpLink();
//        registerPage.clickSignUpButton();
        presentationSleep(2);
    }
    
//    @Test(dataProvider = "invalidCredentialUser")
    public void checkRegisterPage2(UserData userLoginCredentials) {
        System.out.println("-----invalidCredentialUser--------");
        TipsTricksPage homepage = loadApplication();
        MyCabinetPage myCabinetPage = homepage.navigateMenuMyCabinet();
        LoginPage loginPage = myCabinetPage.gotoLoginPage();
        RegisterPage registerPage = loginPage.clickSignUpLink();
        System.out.println("registerPage.getTitleFieldText(): "
                + registerPage.getTitleFieldText());
        registerPage.enterEmail(userLoginCredentials.getEmail())
                .enterFirstName(userLoginCredentials.getFirstName())
                .enterLastName(userLoginCredentials.getLastName())
                .enterPassword(userLoginCredentials.getPassword())
                .enterPasswordConfirm(userLoginCredentials.getPassword());
        presentationSleep(2);
//        registerPage.clickSignUpButton();
    }
}
