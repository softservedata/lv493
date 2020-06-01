package com.softserve.edu.greencity.rest.tests.myhabits;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.resources.myhabits.UserGoalsErrorResource;
import com.softserve.edu.greencity.rest.services.myhabits.MyHabitsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class UserGoalsNegativeTests extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    MyHabitsService myHabitsService;

    @BeforeClass
    public void beforeClass() {
        myHabitsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService();
    }


    @DataProvider
    public Object[][] language() {
        return new Object[][] {
            {LanguagesCode.UKRAINIAN}
        };
    }
    @Test(dataProvider = "language")
    public void checkUserGoals(LanguagesCode language) {
        logger.info("Start checkUserGoals(" + user + ")");

        Assert.assertEquals(myHabitsService.gotoUserGoalsErrorService().userGoalsEntities(language).getMessage(),
                UserGoalsErrorResource.NOT_SELECTED_GOALS);
    }

    @Test
    public void checkUserGoals() {
        logger.info("Start checkUserGoals(" + user + ")");

        Assert.assertEquals(myHabitsService.gotoUserGoalsErrorService().userGoalsEntities().getMessage(),
                UserGoalsErrorResource.NOT_SELECTED_GOALS);
    }

    @DataProvider
    public Object[][] userID() {
        return new Object[][] {
            {17}
        };
    }

    @Test(dataProvider = "userID")
    public void checkUserGoals(int userID) {
        logger.info("Start checkUserGoals(" + user + ")");

        Assert.assertEquals(myHabitsService.gotoUserGoalsErrorService().userGoalsEntitiesWithOtherUser(userID).getMessage(),
                UserGoalsErrorResource.OTHER_USER);
    }


}
