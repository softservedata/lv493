package com.softserve.edu.greencity.rest.services;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.entity.places.PageEntity;
import com.softserve.edu.greencity.rest.resources.places.PlaceStatusResourse;

public class PlacesService extends LogginedUserService {
	
	private PlaceStatusResourse placeStatusResourse;

	public PlacesService(LogginedUserEntity logginedUserEntity, PlaceStatusResourse placeStatusResourse) {
		super(logginedUserEntity);
		this.placeStatusResourse = placeStatusResourse;
	}

	public PlaceStatusResourse getPlaceStatusResourse() {
		return placeStatusResourse;
	}
	

    //	public List<NewsItems> getNewsEntity() {
    public PageEntity getPlasesByStatus() {
        MethodParameters methodParameters = new MethodParameters();
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        //TODO
//        RestParameters urlParameters = new RestParameters()
//                .addParameter(KeyParameters.PAGE, pageParameters.getPage())
//                .addParameter(KeyParameters.SIZE, pageParameters.getSize());
        PageEntity pageEntities = placeStatusResourse
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters));

        System.out.println("***pageEntities = " + pageEntities);
//		return NewsItems.converToNewsItemsList(newsEntities);
        return pageEntities;
    }


}
