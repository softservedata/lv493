package com.softserve.edu.greencity.rest.tests.myhabits;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.LanguagesCode;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabit;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabitRepository;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabitStatistic;
import com.softserve.edu.greencity.rest.data.myhabits.UserHabitStatisticRepository;
import com.softserve.edu.greencity.rest.services.myhabits.UserHabitsService;
import com.softserve.edu.greencity.rest.tests.GreencityRestTestRunner;

public class UserHabitsTests extends GreencityRestTestRunner {
    User user = UserRepository.get().getDefault();
    UserHabitsService userHabitsService;

    @BeforeClass
    public void beforeClass() {
        userHabitsService = loadApplication()
                .successfulUserLogin(user)
                .gotoMyhabitsService()
                .gotoUserHabitsService();
    }

    @DataProvider
    public Object[][] userHabits() {
        return new Object[][] {
            { UserHabitRepository.get().typicalHabits()}
            };
    }

    @Test(dataProvider = "userHabits")
    public void checkUserHabits(List<UserHabit> expectedHabits) {
        logger.info("Start checkUserHabits()");

        Assert.assertEquals(userHabitsService.userHabits(),
                expectedHabits, "Habit is not selected: ");
    }


    @DataProvider
    public Object[][] userHabitsWithLanguage() {
        return new Object[][] {
            {UserHabitRepository.get().typicalHabitsUK(), LanguagesCode.UKRAINIAN}
        };
    }

    @Test(dataProvider = "userHabitsWithLanguage")
    public void checkUserHabits(List<UserHabit> expectedHabits, LanguagesCode language) {
        logger.info("Start checkUserHabits()");

        Assert.assertEquals(userHabitsService.userHabits(language),
                expectedHabits, "Habit is not selected: ");
    }


    @DataProvider
    public Object[][] availableHabits() {
        return new Object[][] {
            { UserHabitRepository.get().typicalHabits()}
            };
    }

    @Test(dataProvider = "availableHabits")
    public void checkAvailableUserHabits(List<UserHabit> expectedHabits) {
        logger.info("Start checkAvailableUserHabits()");

        Assert.assertEquals(userHabitsService.userAvailableHabits(),
                expectedHabits, "Habit is not available: ");
    }

    @DataProvider
    public Object[][] availableHabitsWithLanguage() {
        return new Object[][] {
            {UserHabitRepository.get().typicalHabitsUK(), LanguagesCode.UKRAINIAN}
        };
    }

    @Test(dataProvider = "availableHabitsWithLanguage")
    public void checkAvailableUserHabits(List<UserHabit> expectedHabits,LanguagesCode language) {
        logger.info("Start checkAvailableUserHabits()");

        Assert.assertEquals(userHabitsService.userAvailableHabits(language),
                expectedHabits, "Habit is not available: ");
    }

    @DataProvider
    public Object[][] userHabitsStatistic() {
        return new Object[][] {
            {UserHabitStatisticRepository.get().getDefault()}
        };
    }

    @Test(dataProvider = "userHabitsStatistic")
    public void checkUserHabitStatistic(UserHabitStatistic expectedStatistic) {
        logger.info("Start checkUserHabitStatistic()");

        Assert.assertEquals(UserHabitStatistic.converToUserHabitStatistic(
                    userHabitsService.gotoUserHabitStatisticService().userHabitStatistic()),
                expectedStatistic, "Statistic is not correct: ");
    }

}
