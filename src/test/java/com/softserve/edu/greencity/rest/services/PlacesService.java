package com.softserve.edu.greencity.rest.services;


import com.softserve.edu.greencity.rest.data.PlaceStatus;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.data.places.PlaceId;
import com.softserve.edu.greencity.rest.data.places.PlacePredicate;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.places.PageEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceInfoEntity;
import com.softserve.edu.greencity.rest.resources.places.InfoPlaceResourse;
import com.softserve.edu.greencity.rest.resources.places.PlacePredicateRsourse;
import com.softserve.edu.greencity.rest.resources.places.PlaceStatusResourse;
import com.softserve.edu.greencity.rest.resources.places.PlacesResource;

public class PlacesService extends LogginedUserService {
	
	private PlaceStatusResourse placeStatusResourse;
    private PlacesResource placesResource;
    private PlacePredicateRsourse placePredicateRsourse;
//    private InfoPlaceResourse placeInfoResourse;

	public PlacesService(LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		this.placeStatusResourse = new PlaceStatusResourse();
		this.placesResource = new PlacesResource();
		this.placePredicateRsourse = new PlacePredicateRsourse();
	}

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
    
    public PageEntity getPlasesByPredicate(PageParameters pageParameters) {
 //   		, PlaceStatus status) {
//PlacePredicate placePredicate) {
        MethodParameters methodParameters = new MethodParameters()
    	 .addContentType(ContentTypes.APPLICATION_JSON);
       
      
  //      		.addParameter(KeyParameters.DISCOUNT_DTO, "{ \"discountDto\": { \"discountMax\": 0, \"discountMin\": 0, \"specification\": { \"name\": \"string\" } },");
       String value = 	
    		   "{ \"discountDto\": { \"discountMax\": 0, \"discountMin\": 0, \"specification\": { \"name\": \"string\" } },"
    		   + " \"distanceFromUserDto\": { \"distance\": 1000, \"lat\": 0, \"lng\": 0 }, \"mapBoundsDto\": { \"northEastLat\": 0, \"northEastLng\": 0, "
    		   + "\"southWestLat\": 0, \"southWestLng\": 0 }, \"searchReg\": \"\", \"status\": \"APPROVED\", \"time\": \"29/05/2020 12:00:00\"}" ;
        				//"{ \"discountMax\": 0, \"discountMin\": 0, \"specification\": { \"name\": \"string\" } },
       RestParameters mediaTypeParameters = new RestParameters();
 //      		.addParameter(value);
//       System.out.println(".addParameter(value); ");
        		
//               .addParameter(KeyParameters.DISCOUNT_DTO, "{ \"discountDto\": { \"discountMax\": 0, \"discountMin\": 0, \"specification\": { \"name\": \"string\" } }")
//        		.addParameter(KeyParameters.DISTANCE_FROM_USER_DTO, "{ \"distance\": 1, \"lat\": 0, \"lng\": 0 }")
//        		.addParameter(KeyParameters.MAP_BOUNDS_DTO, "{ \"northEastLat\": 0, \"northEastLng\": 0, \"southWestLat\": 0, \"southWestLng\": 0 }")
//        		.addParameter(KeyParameters.SEARCH_REG, "")
//        		.addParameter(KeyParameters.STATUS, "APPROVED")
//        		.addParameter(KeyParameters.TIME, "29/05/2020 23:06:22");
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        
        RestParameters urlParameter = new RestParameters()
                .addParameter(KeyParameters.PAGE, pageParameters.getPage())
                .addParameter(KeyParameters.SIZE, pageParameters.getSize());
      
        PageEntity pageEntity = placePredicateRsourse
        		
                .httpPostAsEntity(methodParameters
 //               		 .addContentType(ContentTypes.APPLICATION_JSON)
                		.addMediaTypeParameters(mediaTypeParameters)
                        .addHeaderParameters(headerParameters)
                        .addUrlParameters(urlParameter));

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
        
        // add  "PlaceEntity"
        
        
        PlaceEntity placeAboutIDEntity = placesResource
                .httpGetAsEntity(methodParameters.addPathVariables(pathVariables).addHeaderParameters(headerParameters));
        // System.out.println("***googleSecurityEntity = " +
        return placeAboutIDEntity;
    }
    
    
   

}
