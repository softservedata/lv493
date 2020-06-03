package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.places.PlaceId;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.places.PlaceInfoEntity;
import com.softserve.edu.greencity.rest.resources.places.InfoPlaceResourse;

public class PlacesGuestService extends GuestService {
	
	private InfoPlaceResourse placeInfoResourse;

	public PlacesGuestService() {
		super();
		this.placeInfoResourse = new InfoPlaceResourse();
	}
	 
	public InfoPlaceResourse getPlaceInfoResourse() {
		return placeInfoResourse;
	}

	 
    public PlaceInfoEntity placeInfoID(PlaceId placeId) {
        MethodParameters methodParameters = new MethodParameters();
        
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
                
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.PLACE_ID, String.valueOf(placeId.getId()));
        
        PlaceInfoEntity placeInfoEntity = placeInfoResourse
                .httpGetAsEntity(methodParameters
                		.addPathVariables(pathVariables)
                		.addHeaderParameters(headerParameters));
         System.out.println("***placeInfoEntity = " + placeInfoEntity);
        return placeInfoEntity;
    }


	

}
