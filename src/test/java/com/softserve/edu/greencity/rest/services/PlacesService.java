package com.softserve.edu.greencity.rest.services;


import com.softserve.edu.greencity.rest.data.PlaceStatus;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.data.places.PlaceId;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.places.PageEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.resources.places.PlacePredicateRsourse;
import com.softserve.edu.greencity.rest.resources.places.PlaceStatusResourse;
import com.softserve.edu.greencity.rest.resources.places.PlacesResource;

public class PlacesService extends LogginedUserService {
	
	private PlaceStatusResourse placeStatusResourse;
    private PlacesResource placesResource;
    private PlacePredicateRsourse placePredicateRsourse;

	public PlacesService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		this.placeStatusResourse = new PlaceStatusResourse();
		this.placesResource = new PlacesResource();
		this.placePredicateRsourse = new PlacePredicateRsourse();
	}
	
	// getters
	
	public PlaceStatusResourse getPlaceStatusResourse() {
		return placeStatusResourse;
	}
    
    public PlacesResource getPlacesResource() {
        return placesResource;
    }
    
    public PlacePredicateRsourse getPlacePredicateRsourse() {
        return placePredicateRsourse;
    }
	
	public PageEntity getPlasesByStatus(PageParameters pageParameters, PlaceStatus status) {
		MethodParameters methodParameters = new MethodParameters();
		RestParameters headerParameters = new RestParameters()
				.addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
				.addParameter(KeyParameters.AUTHORIZATION,
						KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

		RestParameters pathVariables = new RestParameters().addParameter(KeyParameters.PLACE_STATUS, status.toString());

		RestParameters urlParameter = new RestParameters().addParameter(KeyParameters.PAGE, pageParameters.getPage())
				.addParameter(KeyParameters.SIZE, pageParameters.getSize());

		PageEntity pageEntity = placeStatusResourse.httpGetAsEntity(methodParameters
				.addHeaderParameters(headerParameters).addPathVariables(pathVariables).addUrlParameters(urlParameter));

		return pageEntity;
	}

	public PageEntity getPlasesByPredicate(PageParameters pageParameters) {

		MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
		RestParameters mediaTypeParameters = new RestParameters().addNewObjectParameter(KeyParameters.DISCOUNT_DTO)
				.addObjectParameter(KeyParameters.DISCOUNT_MAX, 0).addObjectParameter(KeyParameters.DISCOUNT_MIN, 0)
				.addNewObjectParameter(KeyParameters.SPECIFICATION).addObjectParameter(KeyParameters.NAME, "string")
				.buildCurrentObjectParameter().buildCurrentObjectParameter()
				.addNewObjectParameter(KeyParameters.DISTANCE_FROM_USER_DTO)
				.addObjectParameter(KeyParameters.DISTANCE, 0).addObjectParameter(KeyParameters.LAT, 0)
				.addObjectParameter(KeyParameters.LNG, 0).buildCurrentObjectParameter()
				.addNewObjectParameter(KeyParameters.MAP_BOUNDS_DTO).addObjectParameter(KeyParameters.NORTH_EAST_LAT, 0)
				.addObjectParameter(KeyParameters.NORTH_EAST_LNG, 0).addObjectParameter(KeyParameters.SOUTH_WEST_LAT, 0)
				.addObjectParameter(KeyParameters.SOUTH_WEST_LNG, 0).buildCurrentObjectParameter()
				.addObjectParameter(KeyParameters.SEARCH_REG, "string")
				.addObjectParameter(KeyParameters.STATUS, "PROPOSED")
				.addObjectParameter(KeyParameters.TIME, "29/05/2020 23:06:22");

		RestParameters headerParameters = new RestParameters()
				.addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
				.addParameter(KeyParameters.AUTHORIZATION,
						KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

		RestParameters urlParameter = new RestParameters().addParameter(KeyParameters.PAGE, pageParameters.getPage())
				.addParameter(KeyParameters.SIZE, pageParameters.getSize());

		PageEntity pageEntity = placePredicateRsourse

				.httpPostAsEntity(methodParameters.addMediaTypeParameters(mediaTypeParameters)
						.addHeaderParameters(headerParameters).addUrlParameters(urlParameter));

		System.out.println("***pageEntities = " + pageEntity);

		return pageEntity;
	}
	
	// https://***/place/about/1" -H "accept: */*" -H "Authorization: Bearer ***"
    public PlaceEntity placeAboutID(PlaceId placeId) {
    	
        MethodParameters methodParameters = new MethodParameters();
        getPlacesResource();
        
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION, KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        //
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.PLACE_ID, String.valueOf(placeId.getId()));
 
        
        PlaceEntity placeAboutIDEntity = placesResource
                .httpGetAsEntity(methodParameters.addPathVariables(pathVariables).addHeaderParameters(headerParameters));
        // System.out.println("***googleSecurityEntity = " +
        return placeAboutIDEntity;
    }
    
    
   

}