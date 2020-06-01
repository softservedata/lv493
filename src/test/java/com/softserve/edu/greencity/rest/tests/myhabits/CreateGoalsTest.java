package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.UserCustomGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class CreateGoalsTest extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    UserCustomGoalsService userCustomGoalsService;
    List<UserGoalEntity> customGoals;

    @BeforeMethod
    public void beforeMethod() {
        userCustomGoalsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserCustomGoalsService();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        userCustomGoalsService.deleteCustomGoals(customGoals);
    }

    @DataProvider
    public Object[][] userGoals() {
        return new Object[][] {
                { UserGoalRepository.get().customGoalsForCreating(),
                        UserGoalRepository.get().createdCustomGoals() }};
    }

    @Test(dataProvider = "userGoals")
    public void createUserGoals(List<UserGoal> goals, List<UserGoal> expectedGoals) {
        logger.info("Start createUserGoals()");

        List<UserGoalEntity> createdGoals = userCustomGoalsService.createCustomGoals(goals);
        customGoals = createdGoals;

        Assert.assertEquals(UserGoal.converToUserGoalList(createdGoals),
                expectedGoals, "Goals is not created: ");
    }

}
