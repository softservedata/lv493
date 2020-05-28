package com.softserve.edu.greencity.rest.resources;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.EcoNewsEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

import java.util.List;

public class NewestNewsResource extends
        RestQueries<EcoNewsEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity> {

    public NewestNewsResource() {
        super(RestUrlRepository.getNewest());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, EcoNewsEntity.class);
        addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
        //
        addListEntityParameters(RestHttpMethods.GET,
                new GenericConverter<List<EcoNewsEntity>>() {
                }.getGenericType());
        addListEntityParameters(RestHttpMethods.POST,
                new GenericConverter<List<ResponseCodeEntity>>() {
                }.getGenericType());
        addListEntityParameters(RestHttpMethods.PUT,
                new GenericConverter<List<ResponseCodeEntity>>() {
                }.getGenericType());
        addListEntityParameters(RestHttpMethods.DELETE,
                new GenericConverter<List<ResponseCodeEntity>>() {
                }.getGenericType());
        addListEntityParameters(RestHttpMethods.PATCH,
                new GenericConverter<List<ResponseCodeEntity>>() {
                }.getGenericType());
    }
}