package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.resources.econews.EconewsResource;
import com.softserve.edu.greencity.rest.resources.econews.EconewsTagsResource;
import com.softserve.edu.greencity.rest.resources.econews.NewsByIdResource;
import com.softserve.edu.greencity.rest.resources.places.FavoritePlaceResources;

import java.util.List;

public class FavoritePlacesService extends LogginedUserService{
    private PlaceEntity placeEntity;
    private FavoritePlaceResources favoritePlaceResources;

    public FavoritePlacesService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        placeEntity = new PlaceEntity();
        favoritePlaceResources = new FavoritePlaceResources();
    }

    public FavoritePlacesService(LogginedUserEntity logginedUserEntity, PlaceEntity placeEntity, FavoritePlaceResources favoritePlaceResources) {
        super(logginedUserEntity);
        this.placeEntity = placeEntity;
        this.favoritePlaceResources = favoritePlaceResources;
    }

    public PlaceEntity getPlaceEntity() {
        return placeEntity;
    }

    public FavoritePlaceResources getFavoritePlaceResources() {
        return favoritePlaceResources;
    }

    public List<PlaceEntity> getFavouritePlaces() {
        MethodParameters methodParameters = new MethodParameters();
        //
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.CONTENT_TYPE, ContentTypes.APPLICATION_JSON.toString())
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJncmVlbi5jaXR5Lm1hcmphbmFAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTU5MDc1Mjg0MSwiZXhwIjoxNTkwNzYwMDQxfQ.7AQWPLJPE_vcLRR_XckB7XgJc12cTimHAHH4nEYec1M");

        List<PlaceEntity> favoritePlaceEntities= favoritePlaceResources
                .httpGetAsListEntity(methodParameters.addHeaderParameters(headerParameters));

        return favoritePlaceEntities;
    }
}
