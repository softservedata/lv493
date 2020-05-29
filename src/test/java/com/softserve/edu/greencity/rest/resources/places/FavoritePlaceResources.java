package com.softserve.edu.greencity.rest.resources.places;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

import java.util.List;

public class FavoritePlaceResources
        extends RestQueries<PlaceEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity>{


        public FavoritePlaceResources() {
            super(RestUrlRepository.getPlaceAbouId());
            initParameters();
        }

        private void initParameters() {
            addEntityParameters(RestHttpMethods.GET, PlaceEntity.class);
            addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
            addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
            addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
            addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
//
            addListEntityParameters(RestHttpMethods.GET, new GenericConverter<List<PlaceEntity>>() {
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
