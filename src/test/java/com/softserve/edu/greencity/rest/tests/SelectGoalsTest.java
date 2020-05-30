package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserGoal;
import com.softserve.edu.greencity.rest.data.UserGoalEntityRepository;
import com.softserve.edu.greencity.rest.data.UserGoalRepository;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.MyHabitsService;

public class SelectGoalsTest extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    MyHabitsService myHabitsService;
    List<UserGoalEntity> customGoals;
    List<UserGoalEntity> userGoals;

    @BeforeClass
    public void beforeClass() {
        myHabitsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService();

        customGoals = myHabitsService.gotoUserCustomGoalsService()
            .createCustomGoals(UserGoalRepository.get().customGoalsForAdding());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        myHabitsService.gotoUserCustomGoalsService().deleteCustomGoals(customGoals);
    }



    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        myHabitsService.gotoUserGoalsService().deselectUserGoals(userGoals);

    }

    @DataProvider
    public Object[][] userGoalEntities() {
        return new Object[][] {
            {  UserGoalEntityRepository.get().goalsForAdding(),
                UserGoalRepository.get().selectedGoals()}
        };
    }

    @Test(dataProvider = "userGoalEntities")
    public void selectUserGoal(List<UserGoalEntity> goals, List<UserGoal> expectedGoals) {
        logger.info("Start selectUserGoal()");

        List<UserGoalEntity> entities = myHabitsService.gotoUserGoalsService().selectUserGoals(goals, customGoals);
        userGoals = entities;

        Assert.assertEquals(UserGoal.converToUserGoalList(entities), expectedGoals, "Goals is not selected: ");
    }

}
