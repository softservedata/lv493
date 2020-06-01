package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalEntityRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.MyHabitsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class SelectGoalsTest extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    MyHabitsService myHabitsService;
    List<UserGoalEntity> customGoals;
    List<UserGoalEntity> userGoals;
    List<UserGoal> goalForCreating = UserGoalRepository.get().customGoalsForAdding();

    @BeforeClass
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());
        logger.info("Go to MyhabitsService");
        myHabitsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService();

        logger.info("Create goals: " + goalForCreating);
        customGoals = myHabitsService.gotoUserCustomGoalsService()
            .createCustomGoals(goalForCreating);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());
        logger.info("Delete created goals: " + customGoals);
        myHabitsService.gotoUserCustomGoalsService().deleteCustomGoals(customGoals);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("Start afterMethod() for " + getClass().getSimpleName());
        logger.info("Deselect goal: " + userGoals);
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
        logger.info("Select goals: " + customGoals);
        List<UserGoalEntity> entities = myHabitsService.gotoUserGoalsService().selectUserGoals(goals, customGoals);
        userGoals = entities;

        Assert.assertEquals(UserGoal.converToUserGoalList(entities), expectedGoals, "Goals is not selected: ");
        logger.info("Goals is selected" + entities);
    }

}
