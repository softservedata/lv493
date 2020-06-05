package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalEntityRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.MyHabitsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Select user goals")
public class SelectGoalsTest extends GreencityRestTestRunner {
    MyHabitsService myHabitsService;
    List<UserGoalEntity> customGoals;
    List<UserGoalEntity> userGoals;

    @BeforeClass(description = "Create goals")
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());

        logger.info("Go to MyhabitsService");
        myHabitsService = loadApplication()
                .successfulUserLogin(UserRepository.get().getDefault())
                .gotoMyhabitsService();

        logger.info("Create goals: " + UserGoalRepository.get().customGoalsForAdding());
        customGoals = myHabitsService.gotoUserCustomGoalsService()
                .createCustomGoals(UserGoalRepository.get().customGoalsForAdding());
    }

    @AfterMethod(alwaysRun = true, description = "Deselect goals")
    public void afterMethod() {
        logger.info("Start afterMethod() for " + getClass().getSimpleName());

        logger.info("Deselect goals: " + userGoals);
        myHabitsService.gotoUserGoalsService().deselectUserGoals(userGoals);
    }

    @AfterClass(alwaysRun = true, description = "Delete created goals")
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());

        logger.info("Delete created goals: " + customGoals);
        myHabitsService.gotoUserCustomGoalsService().deleteCustomGoals(customGoals);
    }

    @DataProvider
    public Object[][] userGoalEntities() {
        return new Object[][] {
                { UserGoalEntityRepository.get().goalsForAdding(),
                        UserGoalRepository.get().selectedGoals() } };
    }

    @Description("Check if user can select goals")
    @Parameters({ "Goals for selecting", "Selected goals" })
    @Test(dataProvider = "userGoalEntities", description = "Select goals")
    public void selectUserGoal(List<UserGoalEntity> goals, List<UserGoal> expectedGoals) {
        logger.info("Start selectUserGoal()");

        logger.info("Select goals: " + customGoals);
        List<UserGoalEntity> entities = myHabitsService.gotoUserGoalsService().selectUserGoals(goals, customGoals);
        userGoals = entities;

        Assert.assertEquals(UserGoal.converToUserGoalList(entities),
                expectedGoals, "Goals are not selected: ");

        logger.info("Goals are selected" + entities);
    }

}
