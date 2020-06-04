package com.softserve.edu.greencity.rest.services;

import java.util.List;

import com.softserve.edu.greencity.rest.data.AllSubscriber;
import com.softserve.edu.greencity.rest.data.UserSubscriber;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberAllEntity;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberUnsubscribeEntity;
import com.softserve.edu.greencity.rest.resources.NewsSubscriberResource;
import com.softserve.edu.greencity.rest.resources.NewsSubscriberUnsubscribeResource;

public class TipsTricksService extends LogginedUserService {
    
    private NewsSubscriberResource subscriberResource;
    private NewsSubscriberAllEntity newsSubscriberAllEntity;
    private NewsSubscriberEntity subscribeEntity;
    private NewsSubscriberUnsubscribeEntity newsSubscriberUnsubscribeEntity;
    private UserSubscriber userSubscriber;
    private AllSubscriber allSubscriber;
    private NewsSubscriberUnsubscribeResource newsSubscriberUnsubscribeResource;
 
    
    public TipsTricksService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        subscriberResource = new NewsSubscriberResource();
        subscribeEntity = new NewsSubscriberEntity(); 
        newsSubscriberAllEntity = new NewsSubscriberAllEntity();
        newsSubscriberUnsubscribeResource = new NewsSubscriberUnsubscribeResource();
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
    
    public NewsSubscriberAllEntity getNewsSubscriberAllEntity() {
        return newsSubscriberAllEntity;
    }
    
    public NewsSubscriberUnsubscribeEntity getNewsSubscriberUnsubscribeEntity() {
        return newsSubscriberUnsubscribeEntity;
    }
    
    public NewsSubscriberUnsubscribeResource getNewsSubscriberUnsubscribeResource() {
        return newsSubscriberUnsubscribeResource;
    }
    
    public AllSubscriber getAllSubscriber() {
        return allSubscriber;
    }
      
    // Functionals
    /**
     * POST
     * subscribeEntity use to subscribe a new email for news
     */
    public NewsSubscriberEntity subscribeEntity(UserSubscriber userSubscriber) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
       
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString()) 
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, userSubscriber.getEmail());

        NewsSubscriberEntity subscriberEntity = subscriberResource
                    .httpPostAsEntity(methodParameters
                    .addMediaTypeParameters(mediaTypeParameters)
                    .addHeaderParameters(headerParameters));

        return subscriberEntity;
    }
 
    /**
     * POST
     * faultySubscriber for faulty email or exist subscriber
     */
    
    public  NewsSubscriberEntity faultySubscriber(UserSubscriber userSubscriber) {
        List<NewsSubscriberEntity> faultySubscriber;
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.APPLICATION_JSON);
        
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString()) 
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
   
        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, userSubscriber.getEmail());

         faultySubscriber = subscriberResource
                .httpPostAsListEntity(methodParameters
                .addMediaTypeParameters(mediaTypeParameters)
                .addHeaderParameters(headerParameters));
        
        return faultySubscriber.get(0);
    }
    
    /**
     * GET 
     * getSubscribers for get all news subscribers. This method uses only Admin
     */
    
    public List<NewsSubscriberAllEntity> getSubscribers() {
        MethodParameters methodParameters = new MethodParameters();
                
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString()) 
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        
        List<NewsSubscriberAllEntity> getSubscrbers = subscriberResource
                .httpGetAsListEntity(methodParameters
                .addHeaderParameters(headerParameters));
        
         return getSubscrbers;
    }
    
    public List<AllSubscriber> allSubscribers() {
        return AllSubscriber.converToAllSubscriberList(getSubscribers());
   }
   
    /**
     * DELETE subscriber. This method uses only Admin
     */
    
    public NewsSubscriberUnsubscribeEntity getUnscribers(AllSubscriber allSubscriber ){
       
        MethodParameters methodParameters = new MethodParameters();
        
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString()) 
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.EMAIL, allSubscriber.getEmail())
                .addParameter(KeyParameters.UNSUBSCRIBE_TOKEN, allSubscriber.getUnsubscribeToken());
        
       NewsSubscriberUnsubscribeEntity unscribers = newsSubscriberUnsubscribeResource
                .httpGetAsEntity(methodParameters
                .addUrlParameters(urlParameters)
                .addHeaderParameters(headerParameters));
        
        return unscribers;
    }


        
        

    

    // Business Logic
    

}
