package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.places.FavoritePlace;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.places.FavoritePlaceEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.resources.places.FavoritePlaceByIdResource;
import com.softserve.edu.greencity.rest.resources.places.FavoritePlaceResources;
import com.softserve.edu.greencity.rest.resources.places.SaveFavoritePlaceResource;

import java.util.List;

/**
 * FavoritePlacesService class implements methods from Favorite Place Controller
 *
 * @author Mariana
 */
public class FavoritePlacesService extends LogginedUserService{
   // private PlaceEntity placeEntity;
    private FavoritePlaceResources favoritePlaceResources;
    private FavoritePlaceByIdResource favoritePlaceByIdResource;
    private SaveFavoritePlaceResource saveFavoritePlaceResource;

    public FavoritePlacesService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
   //     placeEntity = new PlaceEntity();
        favoritePlaceResources = new FavoritePlaceResources();
        favoritePlaceByIdResource = new FavoritePlaceByIdResource();
        saveFavoritePlaceResource = new SaveFavoritePlaceResource();
    }

  //  public PlaceEntity getPlaceEntity() {
     //   return placeEntity;
 //   }

    public FavoritePlaceResources getFavoritePlaceResources() {
        return favoritePlaceResources;
    }

    public FavoritePlaceByIdResource getFavoritePlaceByIdResource() {
        return favoritePlaceByIdResource;
    }

    public SaveFavoritePlaceResource getSaveFavoritePlaceResource() {
        return saveFavoritePlaceResource;
    }

    /**
     * Method to get list of favorite places of current user
     *
     * @return List<FavoritePlaceEntity>
     */
    public List<FavoritePlace> getFavoritePlaces() {
        MethodParameters methodParameters = new MethodParameters();

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

        List<FavoritePlaceEntity> favoritePlaceEntities= favoritePlaceResources
                .httpGetAsListEntity(methodParameters.addHeaderParameters(headerParameters));

        return FavoritePlace.convertToPlacesList(favoritePlaceEntities);
    }

    /**
     * Method to get favorite place by PlaceId
     *
     * @return PlaceEntity
     */
    public PlaceEntity getFavoritePlaceById(int placeId) {
        MethodParameters methodParameters = new MethodParameters();

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.PLACE_ID, String.valueOf(placeId));

        PlaceEntity favoritePlaceEntity= favoritePlaceByIdResource
                .httpGetAsEntity(methodParameters.addHeaderParameters(headerParameters)
                .addPathVariables(pathVariables));

        return favoritePlaceEntity;
    }

    /**
     * Method to save place  as favorite.
     *
     * @return FavoritePlaceEntity
     */
    public FavoritePlace saveFavoritePlace(int placeId, String placeName) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.NAME, placeName)
                .addParameter(KeyParameters.PLACE_ID, String.valueOf(placeId));

        FavoritePlaceEntity favoritePlaceEntity= saveFavoritePlaceResource
                .httpPostAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addMediaTypeParameters(mediaTypeParameters));

        return FavoritePlace.convertToPlace(favoritePlaceEntity);
    }

    /**
     * Method to update favorite place
     *
     * @return FavoritePlaceEntity
     */
    public FavoritePlace updateFavoritePlace(int placeId, String placeName) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.NAME, placeName)
                .addParameter(KeyParameters.PLACE_ID, String.valueOf(placeId));

        FavoritePlaceEntity favoritePlaceEntity= favoritePlaceResources
                .httpPutAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addMediaTypeParameters(mediaTypeParameters));

        return FavoritePlace.convertToPlace(favoritePlaceEntity);
    }

    /**
     * Method to delete place for Favorite Places of current user by Place Id
     *
     * @return ResponseCodeEntity
     */
    public ResponseCodeEntity deleteFavoritePlace(int placeId) {
        MethodParameters methodParameters = new MethodParameters();

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.CONTENT_TYPE, ContentTypes.APPLICATION_JSON.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.PLACE_ID, String.valueOf(placeId));

        ResponseCodeEntity response = favoritePlaceResources
                .httpDeleteAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addPathVariables(pathVariables));
        return response;
    }
}
