package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.ArrayList;
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
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.UserGoalsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class DoCustomGoalsTest extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    UserGoalsService userGoalsService;
    List<UserGoal> goalForCreating = UserGoalRepository.get().customGoalsForAdding();
    List<UserGoalEntity> selectedGoals;
    List<UserGoalEntity> createdGoals;
    UserGoalEntity userCustomGoal;

    @BeforeClass
    public void beforeClass() {
        userGoalsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserGoalsService();
        createdGoals = userGoalsService.gotoUserCustomGoalsService()
                .createCustomGoals(goalForCreating);
        selectedGoals = userGoalsService
                .gotoUserGoalsService()
                .selectUserGoals(new ArrayList<>(), createdGoals);
        userCustomGoal = selectedGoals.get(0);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        userGoalsService.deselectUserGoals(selectedGoals);
        userGoalsService.gotoUserCustomGoalsService().deleteCustomGoals(createdGoals);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        userGoalsService.doUserGoals(userCustomGoal);
    }


    @DataProvider
    public Object[][] customUserGoalEntities() {
        return new Object[][] {
                { UserGoalRepository.get().buyNaturalFoodDONE() } };
    }

    @Test(dataProvider = "customUserGoalEntities")
    public void doUserCustomGoal(UserGoal expectedGoal) {
        logger.info("Start selectUserGoal()");

        Assert.assertEquals(UserGoal.converToUserGoal( userGoalsService.doUserGoals(userCustomGoal)),
                expectedGoal, "Goals is not done: ");
    }

}
