package com.softserve.edu.greencity.rest.services;


import java.util.List;

import com.softserve.edu.greencity.rest.data.UserSubscriber;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.resources.NewsSubscriberResource;


public class TipsTricksService extends LogginedUserService {
    
    private NewsSubscriberResource subscriberResource;
    private NewsSubscriberEntity subscribeEntity;
    private UserSubscriber userSubscriber;
    
    public TipsTricksService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        subscriberResource = new NewsSubscriberResource();
        subscribeEntity = new NewsSubscriberEntity(); 
    }

    // getters

    public NewsSubscriberResource getSubscriberResource() {
        return subscriberResource;
    }
    
    public NewsSubscriberEntity getSubscribeEntity() {
        return  subscribeEntity;
    }
    
    public UserSubscriber getUserSubcribe() {
        return userSubscriber;
    }
    
    // Functionals

    public NewsSubscriberEntity subscribeEntity(UserSubscriber userSubscriber) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
       
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString()) 
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, userSubscriber.getEmail());
//        System.out.println("**** user = " + userSubscriber.getEmail());

        NewsSubscriberEntity subscriberEntity = subscriberResource
                    .httpPostAsEntity(methodParameters
                    .addMediaTypeParameters(mediaTypeParameters)
                    .addHeaderParameters(headerParameters));

        return subscriberEntity;
    }
    //add ERROr
    public  List<NewsSubscriberEntity> faultySubscriber(UserSubscriber userSubscriber) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString()) 
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
   
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, userSubscriber.getEmail());
        
   
        List<NewsSubscriberEntity> faultySubscriber = subscriberResource
                .httpPostAsListEntity(methodParameters
                .addMediaTypeParameters(mediaTypeParameters)
                .addHeaderParameters(headerParameters));
        
        return faultySubscriber;
    }

    // Business Logic
    

}
