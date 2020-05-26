package com.softserve.edu.greencity.rest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.GoogleSecurityEntity;

public class GoogleSecurityTest extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] users() {
        return new Object[][] { { UserRepository.get().temporary2() } };
    }
    
    @Test(dataProvider = "users")
    public void checkGoogleSecurity(User user) {
        logger.info("Start checkGoogleSecurity(" + user + ")");
        GoogleSecurityEntity googleSecurity = loadApplication()
                .successfulUserLogin(user).googleSecurity();
        System.out.println("googleSecurity = "+ googleSecurity);
//      Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(),
//              user.getName());
    }
}
