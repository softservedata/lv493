package com.softserve.edu.greencity.rest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;

public class PlaceAboutIDTest extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] users() {
        return new Object[][] { { UserRepository.get().temporary() } };
    }

    @Test(dataProvider = "users")
    public void checkPlaceAboutID (User user) {
        logger.info("Start checkPlaceAboutID(" + user + ")");
//        PlaceEntity placeAboutIDEntity = loadApplication()
//                .successfulUserLogin(user)
//                .gotoPlacesService().placeAboutID();
//        System.out.println("placeAboutIDEntity = "
//                + placeAboutIDEntity);
//        List<UserGoal> userGoals = myhabitsService.userGoals();
//        System.out.println("userGoals = "+ userGoals);
//        Assert.assertEquals(userGoals, expectedGoals);
    }
}
