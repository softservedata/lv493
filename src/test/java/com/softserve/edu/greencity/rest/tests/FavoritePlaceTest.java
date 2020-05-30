package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class FavoritePlaceTest extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] users() {
        return new Object[][] { { UserRepository.get().getAdminUser() } };
    }

    @Test(dataProvider = "users")
    public void getFavoritePlace (User user) {
        logger.info("Start getFavoritePlace(" + user + ")");
        List<PlaceEntity> favoritePlaceEntity = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService()
                .getFavouritePlaces();
        System.out.println("placeAboutIDEntity = "
                + favoritePlaceEntity);
    }
}
