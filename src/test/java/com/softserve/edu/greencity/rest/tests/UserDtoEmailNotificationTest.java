package com.softserve.edu.greencity.rest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.EmailNotification;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.UserDtoEntity;

/**
 * UserDtoEmailNotificationTest class.
 */
public class UserDtoEmailNotificationTest extends GreencityRestTestRunner {

    /**
     * Credentials for already existing user 
     * email "gceurzwfejqtiguoku@ttirv.net";
     * name "Maksym"
     * password "A475asd123*".
     * @return
     */
    @DataProvider
    public Object[][] users() {
        return new Object[][] { { UserRepository.get().alreadyExistingUserCredentials() } };
    }

    /**
     * Check user's email Notification condition.
     * @param user User
     */
    @Test(dataProvider = "users")
    public void checkEmailNotification(User user) {
        logger.info("Start checkGoogleSecurity(" + user + ")");
        UserDtoEntity userDtoEntity = loadApplication().successfulUserLogin(user).userDtoEmailNotification();
        Assert.assertEquals(userDtoEntity.getEmailNotification(), EmailNotification.DISABLED.toString(),
                "Email notification status does not match with existing");
    }
}
