package com.softserve.edu.greencity.rest.services;

import java.util.List;

import com.softserve.edu.greencity.rest.data.UserSubscriber;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.resources.NewsSubscriberResource;

public class TipsGuestService extends GuestService {
    protected NewsSubscriberResource newsSubscriberResource;

    public TipsGuestService() {
        super();
        newsSubscriberResource = new NewsSubscriberResource();

    }

    public NewsSubscriberResource getNewsSubscriberResource() {
        return newsSubscriberResource;
    }

    public NewsSubscriberEntity withoutLogging(UserSubscriber userSubscriber) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, userSubscriber.getEmail());
        
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());

        NewsSubscriberEntity subscriberEntity = newsSubscriberResource
                    .httpPostAsEntity(methodParameters
                    .addHeaderParameters(headerParameters)
                    .addMediaTypeParameters(mediaTypeParameters));

        return subscriberEntity;
    }
    
//    public  NewsSubscriberEntity faultySubscriber(UserSubscriber userSubscriber) {
////        List<NewsSubscriberEntity> faultyEmail;
//        MethodParameters methodParameters = new MethodParameters()
//                .addContentType(ContentTypes.APPLICATION_JSON);
//        
//        RestParameters headerParameters = new RestParameters()
//                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
//                
//        RestParameters mediaTypeParameters = new RestParameters()
//                .addParameter(KeyParameters.EMAIL, userSubscriber.getEmail());
//
//        List<NewsSubscriberEntity> faultyEmail = newsSubscriberResource
//                .httpPostAsListEntity(methodParameters
//                .addMediaTypeParameters(mediaTypeParameters)
//                .addHeaderParameters(headerParameters));
//        
//        return faultyEmail.get(0);
//    }
}
