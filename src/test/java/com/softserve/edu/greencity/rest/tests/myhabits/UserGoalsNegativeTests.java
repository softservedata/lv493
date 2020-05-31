package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.MyHabitsService;

public class UserGoalsNegativeTests extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    MyHabitsService myHabitsService;
    List<UserGoalEntity> customGoals;
    List<UserGoalEntity> selectedGoals;


    @BeforeClass
    public void beforeClass() {
        myHabitsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

    }


    @DataProvider
    public Object[][] selectedUserGoals() {
        return new Object[][] {
            { UserGoalRepository.get().typicalGoal()}
        };
    }

    @Test(dataProvider = "selectedUserGoals")
    public void checkUserGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkUserGoals(" + user + ")");

        List<UserGoal> error = myHabitsService.gotoUserGoalsService().userGoals();
        System.out.println("error   "+ error);
//        Assert.assertEquals(,
//                expectedGoals, "Goal is not selected: ");
    }



}
