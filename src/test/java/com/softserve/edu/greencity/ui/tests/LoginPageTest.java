package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.LoginPage;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;
import com.softserve.edu.greencity.ui.pages.home.HomePage;

/**
 * LoginPageTest class (doesn't working correctly!).
 * @author Serg
 */
public class LoginPageTest extends GreencityTestRunner {

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
        System.out.println("loginPage.getTitleFieldText(): "
                + loginPage.getTitleFieldText());
        loginPage.clickEmailField();
        loginPage.setEmailField(userLoginCredentials.getEmail());
        presentationSleep(2);
        loginPage.setPasswordField(userLoginCredentials.getPassword());
        presentationSleep(2);
        loginPage.clickShowPasswordButton();
        presentationSleep(2);
        loginPage.clickShowPasswordButton();
        presentationSleep(2);
//        loginPage.clickSignInButton();
    }
}
