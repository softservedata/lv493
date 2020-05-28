package com.softserve.edu.greencity.rest.resources;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

public class NewsSubscriberResource extends RestQueries<NewsSubscriberEntity,
                NewsSubscriberEntity, ResponseCodeEntity,
                ResponseCodeEntity, ResponseCodeEntity> {

    public NewsSubscriberResource() {
        super(RestUrlRepository.getNewsSubscriber());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, NewsSubscriberEntity.class);
        addEntityParameters(RestHttpMethods.POST, NewsSubscriberEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
        //
        addListEntityParameters(RestHttpMethods.GET, 
                new GenericConverter<List<NewsSubscriberEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.POST, 
                new GenericConverter<List<NewsSubscriberEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.PUT,
                new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.DELETE, 
                new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.PATCH, 
                new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
    }

 

}
