package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.common.LoginDropdown;
import com.softserve.edu.greencity.ui.pages.home.HomePage;

/**
 * LoginDropdownTest class (doesn't working correctly!).
 * @author Serg
 */
public class LoginDropdownTest extends GreencityTestRunner {

    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] {
                { UserRepository.getDefaultUserCredentials() }, };
    }

    @Test(dataProvider = "validCredentialUser")
    public void checkLoginPage(UserData userLoginCredentials) {
        HomePage homepage = loadApplication();
        LoginDropdown loginDropdown = homepage.clickSigninLink();
        System.out.println("loginDropdown.getTitleFieldText(): "
                + loginDropdown.getTitleFieldText());
        loginDropdown.clickEmailField();
        loginDropdown.setEmailField(userLoginCredentials.getEmail());
        presentationSleep(2);
        loginDropdown.setPasswordField(userLoginCredentials.getPassword());
        presentationSleep(2);
        loginDropdown.clickShowPasswordButton();
        presentationSleep(2);
        loginDropdown.clickShowPasswordButton();
        presentationSleep(2);
//      loginDropdown.clickLoginButton();;
    }
}
