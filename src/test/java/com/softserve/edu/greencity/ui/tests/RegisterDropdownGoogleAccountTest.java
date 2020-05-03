package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserData;
import com.softserve.edu.greencity.ui.data.UserRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.GoogleAccountPage;
import com.softserve.edu.greencity.ui.pages.common.RegisterDropdown;

/**
 * RegisterDropdownGoogleAccountTest class.
 * @author Serg
 *
 */
public class RegisterDropdownGoogleAccountTest extends GreencityTestRunner {

    @DataProvider
    public Object[][] validCredentialGoogleUser() {
        return new Object[][] {
                { UserRepository.getGoogleUserCredentials() }, };
    }

    @Test(dataProvider = "validCredentialGoogleUser")
    public void checkGoogleSignUpPage(UserData userGoogleLoginCredentials) {
        System.out.println("-----------validCredentialUser------------");
        RegisterDropdown registerDropdown = loadApplication()
                .gotoRegisterDropdown();
        System.out.println("registerDropdown.getTitleFieldText(): "
                + registerDropdown.getTitleFieldText());
        GoogleAccountPage googleAccountPage = registerDropdown.clickSignUpGoogleAccountButton();
        System.out.println("googleAccountPage.getTitleGoogleAccount(): " + googleAccountPage.getTitleGoogleAccount());
        googleAccountPage.enterEmail(userGoogleLoginCredentials.getEmail());
        presentationSleep(2);
//        googleAccountPage.clickEmailNext();
//        googleAccountPage.enterPassword(userGoogleLoginCredentials.getPassword());
//        presentationSleep(2);
//        googleAccountPage.clickPasswordNext();
    }
}
