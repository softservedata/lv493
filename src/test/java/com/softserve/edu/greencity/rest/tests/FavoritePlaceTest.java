package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.places.FavoritePlacesRepository;
import com.softserve.edu.greencity.rest.entity.FavoritePlaceEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.services.FavoritePlacesService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Tests for Favorite Place Controller
 *
 * @author Mariana
 */
public class FavoritePlaceTest extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] users() {
        return new Object[][]{{UserRepository.get().getAdminUser()}};
    }

    /**
     * Test of getting all Favorite Places of current user.
     *
     * @param user
     */
    @Test(dataProvider = "users", priority = 4)
    public void getFavoritePlaces(User user) {
        logger.info("Start getFavoritePlace(" + user + ")");
        FavoritePlacesService favoritePlacesService = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService();

        logger.info("logginedUserEntity = "
                + favoritePlacesService.getLogginedUserEntity());

        List<FavoritePlaceEntity> favoritePlaceEntity = favoritePlacesService
                .getFavoritePlaces();

        logger.info("FavoritePlaces = " + favoritePlaceEntity);

        Assert.assertTrue(favoritePlaceEntity.size()>0);
    }

    @DataProvider
    public Object[][] placeId() {
        return new Object[][]{
                {UserRepository.get().getAdminUser(), FavoritePlacesRepository.get().getDefault() }
        };
    }

    /**
     * Test to Save place as favorite..
     *
     * @param user
     * @param placeId
     */
    @Test(dataProvider = "placeId", priority = 1)
    public void saveFavoritePlace(User user, int placeId) {
        logger.info("Start getFavoritePlace(" + user + ")");
        FavoritePlacesService favoritePlacesService = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService();

        System.out.println("logginedUserEntity = "
                + favoritePlacesService.getLogginedUserEntity());

        FavoritePlaceEntity favoritePlaceEntity = favoritePlacesService
                .saveFavoritePlace(placeId, "Place");

        System.out.println("placeAboutIDEntity = " + favoritePlaceEntity);
    }

    /**
     * Test to update name of favorite place
     *
     * @param user
     * @param placeId
     */
    @Test(dataProvider = "placeId", priority = 2)
    public void updateFavoritePlace(User user, int placeId) {
        logger.info("Start getFavoritePlace(" + user + ")");
        FavoritePlacesService favoritePlacesService = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService();

        System.out.println("logginedUserEntity = "
                + favoritePlacesService.getLogginedUserEntity());

        FavoritePlaceEntity favoritePlaceEntity = favoritePlacesService
                .updateFavoritePlace(placeId, "Place");

        System.out.println("placeAboutIDEntity = " + favoritePlaceEntity);
    }

    /**
     * Test to get favorite place by Place Id
     *
     * @param user
     * @param placeId
     */
    @Test(dataProvider = "placeId", priority = 3)
    public void getFavoritePlaceByPlaceId(User user, int placeId) {
        logger.info("Start getFavoritePlace(" + user + ")");
        FavoritePlacesService favoritePlacesService = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService();

        System.out.println("logginedUserEntity = "
                + favoritePlacesService.getLogginedUserEntity());

        PlaceEntity favoritePlaceEntity = favoritePlacesService
                .getFavoritePlaceById(placeId);

        System.out.println("placeAboutIdEntity = " + favoritePlaceEntity);
    }

    /**
     * Test to delete favorite place by Place Id
     *
     * @param user
     * @param placeId
     */
    @Test(dataProvider = "placeId", priority = 5)
    public void deleteFavoritePlace(User user, int placeId) {
        logger.info("Start getFavoritePlace(" + user + ")");
        FavoritePlacesService favoritePlacesService = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService();

        logger.info("Start deleteFavoritePlace(" + placeId + ")");
        ResponseCodeEntity response = favoritePlacesService
                .deleteFavoritePlace(placeId);
        Assert.assertEquals(response.getResponsecode(), 200);
    }
}
