package com.softserve.edu.greencity.rest.services;


import com.softserve.edu.greencity.rest.data.PlaceStatus;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.places.PageEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.resources.places.PlaceStatusResourse;
import com.softserve.edu.greencity.rest.resources.places.PlacesResource;

public class PlacesService extends LogginedUserService {
	
	private PlaceStatusResourse placeStatusResourse;
//	private PlaceEntity placeAboutIDEntity;
    private PlacesResource placesResource;

	public PlacesService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		this.placeStatusResourse = new PlaceStatusResourse();
		this.placesResource = new PlacesResource();
	}

	public PlaceStatusResourse getPlaceStatusResourse() {
		return placeStatusResourse;
	}
	
//	public PlaceEntity getPlaceAboutIDEntity() {
//        placeAboutIDEntity = new PlaceAboutIDEntity();
//        return placeAboutIDEntity;
//    }
    
    public PlacesResource getPlacesResource() {
        return placesResource;
    }
	

    public PageEntity getPlasesByStatus(PageParameters pageParameters, PlaceStatus status) {
        MethodParameters methodParameters = new MethodParameters();
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.PLACE_STATUS, status.toString());
        
        RestParameters urlParameter = new RestParameters()
                .addParameter(KeyParameters.PAGE, pageParameters.getPage())
                .addParameter(KeyParameters.SIZE, pageParameters.getSize());
      
        PageEntity pageEntity = placeStatusResourse
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addPathVariables(pathVariables)
                        .addUrlParameters(urlParameter));

        System.out.println("***pageEntities = " + pageEntity);

        return pageEntity;
    }
	
	// https://***/place/about/1" -H "accept: */*" -H "Authorization: Bearer ***"
    public PlaceEntity placeAboutID() {
        MethodParameters methodParameters = new MethodParameters();
        getPlacesResource();
        
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        //
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.PLACE_ID, "1");
        
        // add  "PlaceEntity"
        
        
        PlaceEntity placeAboutIDEntity = placesResource
                .httpGetAsEntity(methodParameters.addPathVariables(pathVariables).addHeaderParameters(headerParameters));
        // System.out.println("***googleSecurityEntity = " +
        return placeAboutIDEntity;
    }

}
