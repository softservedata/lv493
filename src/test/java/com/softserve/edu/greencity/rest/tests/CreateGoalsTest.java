package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.UserGoal;
import com.softserve.edu.greencity.rest.data.UserGoalRepository;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.UserCustomGoalsService;

public class CreateGoalsTest extends GreencityRestTestRunner {

    UserCustomGoalsService userCustomGoalsService;
    List<UserGoalEntity> customGoals;

    @BeforeMethod
    public void beforeMethod() {
        userCustomGoalsService = loadApplication()
                .successfulUserLogin(UserRepository.get().getDefault())
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
            {  UserGoalRepository.get().customGoalsForCreating(), UserGoalRepository.get().createdCustomGoals()}
        };
    }

    @Test(dataProvider = "userGoals")
    public void createUserGoal(List<UserGoal> goals, List<UserGoal> expectedGoals) {
        logger.info("Start createUserGoal()");

        List<UserGoalEntity> createdGoals = userCustomGoalsService.createCustomGoals(goals);
        customGoals = createdGoals;

        Assert.assertEquals(UserGoal.converToUserGoalList(createdGoals), expectedGoals, "Goals is not created: ");
    }

    // TODO another language

}
