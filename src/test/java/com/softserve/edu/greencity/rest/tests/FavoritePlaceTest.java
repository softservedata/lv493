package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.ResponseCode;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.places.FavoritePlace;
import com.softserve.edu.greencity.rest.data.places.FavoritePlacesRepository;
import com.softserve.edu.greencity.rest.entity.places.FavoritePlaceEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.services.FavoritePlacesService;
import com.softserve.edu.greencity.rest.tools.VerifyUtils;
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
    public Object[][] places() {
        return new Object[][]{
                {UserRepository.get().getAdminUser(), FavoritePlacesRepository.get().getDefaultPlace() }
        };
    }

    /**
     * Test to Save place as favorite..
     * (CRUD - Create)
     * @param user
     * @param place
     */
    @Test(dataProvider = "places", priority = 1)
    public void saveFavoritePlace(User user, FavoritePlaceEntity place) {
        logger.info("Start getFavoritePlace(" + user + ")");
        FavoritePlacesService favoritePlacesService = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService();

        logger.info("logginedUserEntity = "
                + favoritePlacesService.getLogginedUserEntity());

        FavoritePlace favoritePlace = favoritePlacesService
                .saveFavoritePlace(place.getPlaceId(), place.getName());

        logger.info(favoritePlace.toString());

        Assert.assertTrue(favoritePlace.isValid());
        Assert.assertEquals(favoritePlace.getName(), place.getName());
    }

    @DataProvider
    public Object[][] users() {
        return new Object[][]{{UserRepository.get().getAdminUser()}};
    }

    /**
     * Test of getting all Favorite Places of current user.
     * (CRUD - Read)
     *
     * @param user
     */
    @Test(dataProvider = "users", priority = 2)
    public void getFavoritePlaces(User user) {
        logger.info("Start getFavoritePlace(" + user + ")");
        FavoritePlacesService favoritePlacesService = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService();

        logger.info("logginedUserEntity = "
                + favoritePlacesService.getLogginedUserEntity());

        List<FavoritePlace> favoritePlaces = favoritePlacesService
                .getFavoritePlaces();

        logger.info("FavoritePlaces = " + favoritePlaces);

        Assert.assertTrue(VerifyUtils.verifyClass(favoritePlaces));
        Assert.assertTrue(favoritePlaces.size()>0);
    }


    @DataProvider
    public Object[][] placeId() {
        return new Object[][]{
                {UserRepository.get().getAdminUser(), FavoritePlacesRepository.get().getDefault() }
        };
    }
    /**
     * Test to get favorite place by Place Id
     * (CRUD - Read)
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

        logger.info("logginedUserEntity = "
                + favoritePlacesService.getLogginedUserEntity());

        PlaceEntity favoritePlaceEntity = favoritePlacesService
                .getFavoritePlaceById(placeId);

        logger.info("placeAboutIdEntity = " + favoritePlaceEntity);
    }

    /**
     * Test to update name of favorite place
     * (CRUD - Update)
     *
     * @param user
     * @param place
     */
    @Test(dataProvider = "places", priority = 4)
    public void updateFavoritePlace(User user, FavoritePlaceEntity place) {
        logger.info("Start getFavoritePlace(" + user + ")");
        FavoritePlacesService favoritePlacesService = loadApplication()
                .successfulUserLogin(user)
                .gotoFavoritePlacesService();

        logger.info("logginedUserEntity = "
                + favoritePlacesService.getLogginedUserEntity());

        FavoritePlace favoritePlace = favoritePlacesService
                .updateFavoritePlace(place.getPlaceId(), place.getName()+"la-la");

        logger.info("placeAboutIDEntity = " + favoritePlace);

        Assert.assertTrue(favoritePlace.isValid());

        Assert.assertEquals(favoritePlace.getName(), place.getName()+"la-la");

    }

    /**
     * Test to delete favorite place by Place Id
     *
     * (CRUD - Delete)
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
        Assert.assertEquals(response.getResponsecode(), ResponseCode.RESPONSE200.getValue());
    }
}
