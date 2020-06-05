package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoal;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalEntityRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserGoalRepository;
import com.softserve.edu.greencity.rest.entity.myhabits.UserGoalEntity;
import com.softserve.edu.greencity.rest.services.myhabits.MyHabitsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

@Feature("Check presence of user goals")
public class UserGoalsTests extends GreencityRestTestRunner {
    MyHabitsService myHabitsService;
    List<UserGoalEntity> createdGoals;
    List<UserGoalEntity> selectedGoals;

    @BeforeClass(description = "Create goals and select ones")
    public void beforeClass() {
        logger.info("Start beforeClass() for " + getClass().getSimpleName());

        logger.info("Go to UserGoalsService");
        myHabitsService = loadApplication()
                .successfulUserLogin(UserRepository.get().getDefault())
                .gotoMyhabitsService();

        logger.info("Create goals: " + UserGoalRepository.get().customGoals());
        createdGoals = myHabitsService.gotoUserCustomGoalsService()
                .createCustomGoals(UserGoalRepository.get().customGoals());
        List<UserGoalEntity> customSelected = new ArrayList<>();
        customSelected.add(createdGoals.stream()
                .filter(goal -> goal.getText().contains(UserGoalRepository.get().buyNaturalFood().getText()))
                .findAny().orElse(null));

        logger.info("Select goals: " + customSelected + " "
                + UserGoalEntityRepository.get().goalsForSelecting());
        selectedGoals = myHabitsService.gotoUserGoalsService().selectUserGoals(
                UserGoalEntityRepository.get().goalsForSelecting(),
                customSelected);
    }

    @AfterClass(alwaysRun = true, description = "Deselect goals and delete created ones")
    public void afterClass() {
        logger.info("Start afterClass() for " + getClass().getSimpleName());

        logger.info("Deselect user goals: " + selectedGoals);
        myHabitsService.gotoUserGoalsService().deselectUserGoals(selectedGoals);

        logger.info("Delete created goals: " + createdGoals);
        myHabitsService.gotoUserCustomGoalsService()
                .deleteCustomGoals(createdGoals);
    }

    @DataProvider
    public Object[][] selectedUserGoals() {
        return new Object[][] { { UserGoalRepository.get().typicalGoal() } };
    }

    @Description("Check user goals selecting")
    @Parameters("Selected goals")
    @Test(dataProvider = "selectedUserGoals", description = "Check goals presence")
    public void checkUserGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkUserGoals()");

        logger.info("Check selected user goals");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().userGoals(),
                expectedGoals, "Goals are not selected: ");

        logger.info("Goals are selected");
    }

    @DataProvider
    public Object[][] availableUserGoals() {
        return new Object[][] { { UserGoalRepository.get().availableGoals() } };
    }

    @Description("Check user goals availability")
    @Parameters("Available goals")
    @Test(dataProvider = "availableUserGoals", description = "Check goals availability")
    public void checkAvailableUserGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkAvailableUserGoals()");

        logger.info("Check available user goals");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().availableUserGoals(),
                expectedGoals, "Goals are not available: ");

        logger.info("Goals are available");
    }

    @DataProvider
    public Object[][] selectedUserGoalsWithLanguage() {
        return new Object[][] { { UserGoalRepository.get().typicalGoalUk(),
                LanguagesCode.UKRAINIAN } };
    }

    @Description("Check user goals selecting with particular language")
    @Parameters({ "Selected goals", "Language" })
    @Test(dataProvider = "selectedUserGoalsWithLanguage", description = "Check goals selecting")
    public void checkUserGoals(List<UserGoal> expectedGoals, LanguagesCode language) {
        logger.info("Start checkUserGoals()");

        logger.info("Check selected user goals");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().userGoals(language),
                expectedGoals, "Goals are not selected: ");

        logger.info("Goals are selected");
    }

    @DataProvider
    public Object[][] availableUserGoalsWithLanguage() {
        return new Object[][] { { UserGoalRepository.get().availableGoalsUk(),
                LanguagesCode.UKRAINIAN } };
    }

    @Description("Check user goals availability with particular language")
    @Parameters({ "Available goals", "Language" })
    @Test(dataProvider = "availableUserGoalsWithLanguage", description = "Check goals availability")
    public void checkAvailableUserGoals(List<UserGoal> expectedGoals, LanguagesCode language) {
        logger.info("Start checkAvailableUserGoals()");

        logger.info("Check available user goals");
        Assert.assertEquals(myHabitsService.gotoUserGoalsService().availableUserGoals(language),
                expectedGoals, "Goals are not available: ");

        logger.info("Goals are available");
    }

    @DataProvider
    public Object[][] customGoals() {
        return new Object[][] { { UserGoalRepository.get().customGoals() } };
    }

    @Description("Check user custom goals selecting")
    @Parameters("Selected custom goals")
    @Test(dataProvider = "customGoals", description = "Check custom goals presence")
    public void checkUserCustomGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkUserCustomGoals()");

        logger.info("Check all present user custom goals");
        Assert.assertEquals(myHabitsService.gotoUserCustomGoalsService().customGoals(),
                expectedGoals, "Goals are not present: ");

        logger.info("Goals are present");
    }

    @DataProvider
    public Object[][] availableCustomGoals() {
        return new Object[][] {
                { UserGoalRepository.get().availableCustomGoals() } };
    }

    @Description("Check user custom goals availability")
    @Parameters("Available custom goals")
    @Test(dataProvider = "availableCustomGoals", description = "Check custom goals availability")
    public void checkAvailableUserCustomGoals(List<UserGoal> expectedGoals) {
        logger.info("Start checkAvailableUserCustomGoals()");

        logger.info("Check available user custom goals");
        Assert.assertEquals(myHabitsService.gotoUserCustomGoalsService().availableCustomGoals(),
                expectedGoals, "Goals are not available: ");

        logger.info("Goals are available");
    }

}
