package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterPage;
import com.softserve.edu.greencity.ui.pages.home.HomePage;

/**
 * RegisterPageTest class (doesn't working correctly!).
 * @author Serg
 *
 */
public class RegisterPageTest extends GreencityTestRunner {

    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] {
                { UserRepository.getDefaultUserCredentials() }, };
    }

    @Test(dataProvider = "validCredentialUser")
    public void checkLoginPage(UserData userLoginCredentials) {
        HomePage homepage = loadApplication();
        MyCabinetPage myCabinetPage = homepage.navigateMenuMyCabinet();
        presentationSleep(2);
        LoginPage loginPage = myCabinetPage.gotoLoginPage();
        loginPage.clickSignUpLink();;
        RegisterPage registerPage = loginPage.getRegisterPage();
        System.out.println("registerPage.getTitleFieldText(): " + registerPage.getTitleFieldText());
        registerPage.clickFirstNameField();
        registerPage.clearFirstNameField();
        registerPage.setFirstNameField(userLoginCredentials.getFirstName());
        presentationSleep(2);
        registerPage.clickLastNameField();
        registerPage.clearLastNameField();
        registerPage.setLastNameField(userLoginCredentials.getLastName());
        presentationSleep(2);
        registerPage.clickEmailField();
        registerPage.clearEmailField();
        registerPage.setEmailField(userLoginCredentials.getEmail());
        presentationSleep(2);
        registerPage.clickPasswordField();
        registerPage.clearPasswordField();
        registerPage.setPasswordField(userLoginCredentials.getPassword());
        registerPage.clickShowPasswordButton();
        presentationSleep(2);
        registerPage.clickPasswordConfirmField();
        registerPage.clearPasswordConfirmField();
        registerPage.setPasswordConfirmField(userLoginCredentials.getPassword());
        registerPage.clickShowPasswordConfirmButton();
        presentationSleep(2);
//        registerPage.clickSignUpButton();
    }
}
