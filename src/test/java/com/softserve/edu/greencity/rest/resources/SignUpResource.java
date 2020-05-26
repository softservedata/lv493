package com.softserve.edu.greencity.rest.resources;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.RegisterUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

public class SignUpResource extends RestQueries<ResponseCodeEntity, 
                            RegisterUserEntity, ResponseCodeEntity, 
                            ResponseCodeEntity, ResponseCodeEntity> {

    public SignUpResource() {
        super(RestUrlRepository.getSignUp());
        initParameters();
    }
    
    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.POST, RegisterUserEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
//
        addListEntityParameters(RestHttpMethods.GET,
                new GenericConverter<List<ResponseCodeEntity>>() {
                }.getGenericType());
        addListEntityParameters(RestHttpMethods.POST,
                new GenericConverter<List<RegisterUserEntity>>() {
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
