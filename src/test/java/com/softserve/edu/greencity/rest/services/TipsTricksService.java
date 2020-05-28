package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.UserSubscriber;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.resources.NewsSubscriberResource;
import com.softserve.edu.greencity.rest.tools.EmailRandom;

public class TipsTricksService extends LogginedUserService {
    
    private NewsSubscriberResource subscriberResource;
    private NewsSubscriberEntity subscribeEntity;
    private UserSubscriber userSubscriber;
    
    public TipsTricksService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        subscriberResource = new NewsSubscriberResource();
        subscribeEntity = new NewsSubscriberEntity();
        userSubscriber = new UserSubscriber(getRamdomEmail());
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
       private String getRamdomEmail() {
//        rendomEmail = new EmailRandom();
        String email = "";
        email = new EmailRandom().getEmailRandom();
        return email;
    }
    //todo???
    public NewsSubscriberEntity subscribeEntity(UserSubscriber userSubscriber) {
        MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
//        getSubscriberResource();
        //
        
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
//                .addParameter(KeyParameters.CONTENT_TYPE, ContentTypes.APPLICATION_JSON.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        //
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, userSubscriber.getEmail());
               
//     RestParameters bodyParameter = new RestParameters()
//             .addParameter(KeyParameters.EMAIL, userSubscriber.getEmail());//json

    NewsSubscriberEntity subscriberEntity = subscriberResource
                    .httpPostAsEntity(methodParameters
                            .addMediaTypeParameters(mediaTypeParameters)
//                    .addBodyParameters(bodyParameter)
                    .addHeaderParameters(headerParameters)
                    );
      

       
        return subscriberEntity;
    }
    
    
    

    
    // Business Logic
    
}
