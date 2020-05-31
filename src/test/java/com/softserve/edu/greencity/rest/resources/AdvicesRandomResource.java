package com.softserve.edu.greencity.rest.resources;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.entity.UserGoalsEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

//public class AdviceResource extends RestQueries<UserGoalsEntity,
//        ResponseCodeEntity, ResponseCodeEntity,
//        ResponseCodeEntity, ResponseCodeEntity> {

//    public AdviceResource() {
//        super(RestUrlRepository.getUserSubscriber());
//        initParameters();
//    }
//
//    private void initParameters() {
//        addEntityParameters(RestHttpMethods.GET, ResponseCodeEntity.class);
//        addEntityParameters(RestHttpMethods.POST, NewsSubscriberEntity.class);
//        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
//        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
//        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
////
//        addListEntityParameters(RestHttpMethods.GET, 
//                    new GenericConverter<List<UserGoalsEntity>>() {}.getGenericType());
//        addListEntityParameters(RestHttpMethods.POST, 
//                    new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
//        addListEntityParameters(RestHttpMethods.PUT,
//                    new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
//        addListEntityParameters(RestHttpMethods.DELETE, 
//                    new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
//        addListEntityParameters(RestHttpMethods.PATCH, 
//                    new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
//        }

//}
