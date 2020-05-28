package com.softserve.edu.greencity.rest.resources.places;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrl;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.places.PageEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

public class PlaceStatusResourse extends RestQueries<PageEntity, 
	ResponseCodeEntity, ResponseCodeEntity, 
	ResponseCodeEntity, ResponseCodeEntity> {

	protected PlaceStatusResourse(RestUrl restUrl) {
		super(restUrl);
		// TODO Auto-generated constructor stub
	}

	public PlaceStatusResourse() {
		super(RestUrlRepository.getPlacesByStatus());
		initParameters();
	}

	private void initParameters() {
		addEntityParameters(RestHttpMethods.GET, PageEntity.class);
		addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
//
		addListEntityParameters(RestHttpMethods.GET, new GenericConverter<List<PageEntity>>() {
		}.getGenericType());
		addListEntityParameters(RestHttpMethods.POST, new GenericConverter<List<ResponseCodeEntity>>() {
		}.getGenericType());
		addListEntityParameters(RestHttpMethods.PUT, new GenericConverter<List<ResponseCodeEntity>>() {
		}.getGenericType());
		addListEntityParameters(RestHttpMethods.DELETE, new GenericConverter<List<ResponseCodeEntity>>() {
		}.getGenericType());
		addListEntityParameters(RestHttpMethods.PATCH, new GenericConverter<List<ResponseCodeEntity>>() {
		}.getGenericType());
	}

}
