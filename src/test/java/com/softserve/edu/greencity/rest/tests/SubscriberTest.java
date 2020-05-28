package com.softserve.edu.greencity.rest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.UserSubscriber;
import com.softserve.edu.greencity.rest.data.UserSubscriberRepository;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.rest.services.TipsTricksService;

public class SubscriberTest extends GreencityRestTestRunner {
 

    @DataProvider
    public Object[][] users() {
        return new Object[][] { { UserRepository.get().temporary() } };
    }

  // @Test(dataProvider = "users")
    public void checkLogin(User user) {
        logger.info("Start checkLogin(" + user + ")");
        LogginedUserService logginedUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoTipsTricksService();
        System.out.println("logginedUserEntity = " + 
                logginedUserService.getLogginedUserEntity());
        Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(), user.getName());
    }

    @DataProvider
    public Object[][] singleEmail() {
        return new Object[][] { { UserRepository.get().temporary(), UserSubscriberRepository.getRandomEmail() } };
    }
    
    @Test(dataProvider = "singleEmail")
    public void singleEmail(User user, UserSubscriber userSubscriber) {
        logger.info("Start checkLogin(" + user + ")");
        TipsTricksService tipsTricksService = loadApplication()
                .successfulUserLogin(user)
                .gotoTipsTricksService();
       logger.info("subscribeEntity = "
                + tipsTricksService.getLogginedUserEntity());
       NewsSubscriberEntity subscriber = tipsTricksService.subscribeEntity(userSubscriber);
       logger.info("email = " + subscriber);
       Assert.assertEquals(subscriber.getEmail(), userSubscriber.getEmail());
   
    }
    
    
    @DataProvider
    public Object[][] sameEmail() {
        return new Object[][] { { UserRepository.get().temporary(), UserSubscriberRepository.getSingleEmail() } };
    }
    //add to message
    //@Test(dataProvider = "sameEmail")
    public void SingInSame(User user, UserSubscriber userSubscriber) {
        logger.info("Start checkLogin(" + user + ")");
        TipsTricksService tipsTricksService = loadApplication()
                .successfulUserLogin(user)
                .gotoTipsTricksService();
        System.out.println("subscribeEntity = "
                + tipsTricksService.getLogginedUserEntity());
//        NewsSubscriberEntity subscriber = tipsTricksService.getSubscribeEntity();
       NewsSubscriberEntity subscriber = tipsTricksService.subscribeEntity(userSubscriber);
        System.out.println("Random email = " + subscriber);}
    
}
