package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.common.RegisterDropdown;
import com.softserve.edu.greencity.ui.pages.home.HomePage;

/**
 * RegisterDropdownTest class (doesn't working correctly!).
 * @author Serg
 *
 */
public class RegisterDropdownTest extends GreencityTestRunner {

    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] {
                { UserRepository.getDefaultUserCredentials() }, };
    }

    @Test(dataProvider = "validCredentialUser")
    public void checkLoginPage(UserData userLoginCredentials) {
        HomePage homepage = loadApplication();
        RegisterDropdown registerDropdown = homepage.clickRegisterLink();
        System.out.println("registerDropdown.getTitleFieldText(): "
                + registerDropdown.getTitleFieldText());
        registerDropdown.clickEmailField();
        registerDropdown.clearEmailField();
        registerDropdown.setEmailField(userLoginCredentials.getEmail());
        presentationSleep(2);
        registerDropdown.clickPersonNameField();
        registerDropdown.clearPersonNameField();
        registerDropdown
        .setPersonNameField(userLoginCredentials.getFirstName());
        presentationSleep(2);
        registerDropdown.clickPasswordField();
        registerDropdown.clearPasswordField();
        registerDropdown.setPasswordField(userLoginCredentials.getPassword());
        registerDropdown.clickShowPasswordButton();
        presentationSleep(2);
        registerDropdown.clickPasswordConfirmField();
        registerDropdown.clearPasswordConfirmField();
        registerDropdown
                .setPasswordConfirmField(userLoginCredentials.getPassword());
        registerDropdown.clickShowPasswordConfirmButton();
        presentationSleep(2);
//      registerDropdown.clickSubmitButton();
    }
}
