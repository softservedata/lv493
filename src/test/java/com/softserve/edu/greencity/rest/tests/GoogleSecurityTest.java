package com.softserve.edu.greencity.rest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.GoogleSecurityEntity;

/**
 * GoogleSecurityTest class.
 */
public class GoogleSecurityTest extends GreencityRestTestRunner {

    /**
     * Gives user's credentials:email - "xdknxusqvjeovowpfk@awdrt.com";first name - "Temp";password - "Temp#001".
     * @return
     */
    @DataProvider
    public Object[][] users() {
        return new Object[][] { { UserRepository.get().temporary() } };
    }
    
    /**
     * Test Google Security Controller.
     * @param user
     */
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
