package com.softserve.edu.greencity.rest.resources;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.VerifyEmailEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

/**
 * VerifyEmailResource class for verification user mail. Includes only a GET
 * method. !!! Changes a condition of the user.
 */
public class VerifyEmailResource
        extends RestQueries<VerifyEmailEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity> {

    public VerifyEmailResource() {
        super(RestUrlRepository.getVerifyEmail());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, VerifyEmailEntity.class);
        addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
//
        addListEntityParameters(RestHttpMethods.GET, new GenericConverter<List<VerifyEmailEntity>>() {
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
