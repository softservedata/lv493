package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.common.RegisterDropdown;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.pages.home.HomePage;

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
    public Object[][] invalidCredentialUser() {
        return new Object[][] { { UserRepository.getWrongUserCredentials1() },
                { UserRepository.getWrongUserCredentials2() }, };
    }

    @Test(dataProvider = "validCredentialUser")
    public void checkLoginPage(UserData userLoginCredentials) {
        System.out.println("-----------validCredentialUser------------");
        RegisterDropdown registerDropdown = loadApplication()
                .gotoRegisterDropdown();
        System.out.println("registerDropdown.getTitleFieldText(): "
                + registerDropdown.getTitleFieldText());
//        TopPart page = registerDropdown.fillFieldsWithoutRegistration(userLoginCredentials);
        TopPart page = registerDropdown.registrationNewUser(userLoginCredentials);
//        Assert.assertEquals(page.getUserComponent().getName(), userLoginCredentials.getFirstName());
//        page.logout();
        presentationSleep(2);
//        registerDropdown.closeRegisterDropdown();
    }

//    @Test(dataProvider = "invalidCredentialUser")
    public void checkLoginPage2(UserData userLoginCredentials) {
        System.out.println("-----------invalidCredentialUser------------");
        RegisterDropdown registerDropdown = loadApplication()
                .gotoRegisterDropdown();
        System.out.println("registerDropdown.getTitleFieldText(): "
                + registerDropdown.getTitleFieldText());
        registerDropdown.fillFieldsAndGotoLoginPage(userLoginCredentials);
        System.out.println("registerDropdown.getEmailErrorText(): "
                + registerDropdown.getEmailErrorText());
        System.out.println("registerDropdown.getPasswordErrorText(): "
                + registerDropdown.getPasswordErrorText());
        System.out.println("registerDropdown.getPasswordConfirmErrorText(): "
                + registerDropdown.getPasswordConfirmErrorText());
//        registerDropdown.clickSignUpButton();
        presentationSleep(2);
//        registerDropdown.closeRegisterDropdown();
    }
}
