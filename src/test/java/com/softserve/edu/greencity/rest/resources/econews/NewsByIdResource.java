package com.softserve.edu.greencity.rest.resources.econews;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

import java.util.List;

/**
 * EconewsResource class for "/econews/{id}" endpoint
 *
 * @author Mariana
 */

public class NewsByIdResource  extends
        RestQueries<NewsEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity> {

    public NewsByIdResource() {
        super(RestUrlRepository.getNewsById());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, NewsEntity.class);
        addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
        //
        addListEntityParameters(RestHttpMethods.GET,
                new GenericConverter<List<NewsEntity>>() {
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