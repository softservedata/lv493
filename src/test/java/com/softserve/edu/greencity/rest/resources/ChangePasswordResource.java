package com.softserve.edu.greencity.rest.resources;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrl;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ChangePasswordEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

import java.util.List;

public class ChangePasswordResource extends RestQueries<ResponseCodeEntity,
        ResponseCodeEntity, ResponseCodeEntity,
        ResponseCodeEntity,  ResponseCodeEntity> {

    public ChangePasswordResource() {
        super(RestUrlRepository.getChangePassword());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
        //
        addListEntityParameters(RestHttpMethods.GET,
                new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.POST,
                new GenericConverter<List<ChangePasswordEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.PUT,
                new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.DELETE,
                new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.PATCH,
                new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
    }

}
