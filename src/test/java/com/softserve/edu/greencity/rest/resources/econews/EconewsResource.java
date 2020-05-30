package com.softserve.edu.greencity.rest.resources.econews;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.PageEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

import java.util.List;

public class EconewsResource extends
        RestQueries<PageEntity, NewsEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity> {

    public EconewsResource() {
        super(RestUrlRepository.getNews());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, PageEntity.class);
        addEntityParameters(RestHttpMethods.POST, NewsEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
        //
        addListEntityParameters(RestHttpMethods.GET,
                new GenericConverter<List<PageEntity>>() {
                }.getGenericType());
        addListEntityParameters(RestHttpMethods.POST,
                new GenericConverter<List<NewsEntity>>() {
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