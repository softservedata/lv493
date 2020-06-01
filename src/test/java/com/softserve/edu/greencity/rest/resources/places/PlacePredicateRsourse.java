package com.softserve.edu.greencity.rest.resources.places;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrl;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.places.PageEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

public class PlacePredicateRsourse extends RestQueries<ResponseCodeEntity, 
    PageEntity, ResponseCodeEntity, 
	ResponseCodeEntity, ResponseCodeEntity> {

	protected PlacePredicateRsourse(RestUrl restUrl) {
		super(restUrl);
	}

	public PlacePredicateRsourse() {
		super(RestUrlRepository.getPlacesByPredicate());
		initParameters();
	}

	private void initParameters() {
		addEntityParameters(RestHttpMethods.GET, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.POST, PageEntity.class);
		addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
		addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
//
		addListEntityParameters(RestHttpMethods.GET, new GenericConverter<List<ResponseCodeEntity>>() {
		}.getGenericType());
		addListEntityParameters(RestHttpMethods.POST, new GenericConverter<List<PageEntity>>() {
		}.getGenericType());
		addListEntityParameters(RestHttpMethods.PUT, new GenericConverter<List<ResponseCodeEntity>>() {
		}.getGenericType());
		addListEntityParameters(RestHttpMethods.DELETE, new GenericConverter<List<ResponseCodeEntity>>() {
		}.getGenericType());
		addListEntityParameters(RestHttpMethods.PATCH, new GenericConverter<List<ResponseCodeEntity>>() {
		}.getGenericType());
	}

}
