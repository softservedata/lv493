package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.GoogleSecurityEntity;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.PlaceAboutIDEntity;
import com.softserve.edu.greencity.rest.resources.PlacesResource;

public class PlacesService extends LogginedUserService {

    private PlaceAboutIDEntity placeAboutIDEntity;
    private PlacesResource placesResource;

    public PlacesService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        this.placesResource = new PlacesResource();
    }

    public PlaceAboutIDEntity getPlaceAboutIDEntity() {
//        placeAboutIDEntity = new PlaceAboutIDEntity();
        return placeAboutIDEntity;
    }
    
    public PlacesResource getPlacesResource() {
        return placesResource;
    }
    
 // Functionals

    // https://***/place/about/1" -H "accept: */*" -H "Authorization: Bearer ***"
    public PlaceAboutIDEntity placeAboutID() {
        MethodParameters methodParameters = new MethodParameters();
        getPlacesResource();
        //
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        //
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.PLACE_ID, "1");
        //
        placeAboutIDEntity = placesResource
                .httpGetAsEntity(methodParameters.addPathVariables(pathVariables).addHeaderParameters(headerParameters));
        // System.out.println("***googleSecurityEntity = " +
        return placeAboutIDEntity;
    }
    
}
