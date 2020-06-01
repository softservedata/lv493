package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.services.ChangePasswordService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangePasswordTest {

    private ChangePasswordService changePasswordService;
    private String token;

    private String tokenPattern = ".{8}-.{4}-.{4}-.{4}-.{12}";

    @DataProvider
    public Object[][] emailUser() {
        return new Object[][] { { UserRepository.get().temporary() } };
    }


    @BeforeMethod
    public void startService() {
        changePasswordService = new ChangePasswordService();
    }

    @Test(dataProvider = "emailUser")
    public void checkRestorePassword(User user) {
        changePasswordService.setMailUser(user);
        int responseCode = changePasswordService.restorePassword().getResponsecode();

        Assert.assertTrue(responseCode >= 200 && responseCode < 300);
    }

    @Test(dataProvider = "emailUser", dependsOnMethods = "checkRestorePassword")
    public void checkGetToken(User user) {
        token = changePasswordService.getTokenForChangingPassword();
        Assert.assertTrue(token.matches(tokenPattern));
    }

    @Test(dataProvider = "emailUser", dependsOnMethods = "checkGetToken")
    public void checkChangePassword(User user) {
        int responseCode = changePasswordService
                .changePassword(token, user.getPassword()).getResponsecode();

        Assert.assertTrue(responseCode >= 200 && responseCode < 300);
    }

}
