package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.IgnoreError400;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.UserSubscriber;
import com.softserve.edu.greencity.rest.data.UserSubscriberRepository;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.services.TipsTricksService;

public class SubscriberTest extends GreencityRestTestRunner {
 
    @DataProvider
    public Object[][] randomEmail() {
        return new Object[][] { { UserRepository.get().temporary(), UserSubscriberRepository.getRandomEmail() } };
    }
    
    @Test(dataProvider = "randomEmail")
    public void newSubscriber(User user, UserSubscriber userSubscriber) {
        logger.info("Start checkLogin(" + user + ")");
        TipsTricksService tipsTricksService = loadApplication()
                .successfulUserLogin(user)
                .gotoTipsTricksService();
        logger.info("Subscriber (" + userSubscriber +")" );
       Assert.assertEquals(tipsTricksService.subscribeEntity(userSubscriber).getEmail(), userSubscriber.getEmail());
    }
    
    @DataProvider
    public Object[][] existEmail() {
        return new Object[][] { { UserRepository.get().temporary(), UserSubscriberRepository.getSingleEmail()}};
    }

    @Test(dataProvider = "existEmail")
    public void existSubscriber(User user, UserSubscriber userSubscriber) {
       logger.info("Start checkLogin(" + user + ")");
       TipsTricksService tipsTricksService = loadApplication()
               .successfulUserLogin(user)
               .gotoTipsTricksService();
       logger.info("Subscriber (" + userSubscriber +")");
       NewsSubscriberEntity subscriber = tipsTricksService.subscribeEntity(userSubscriber);
       logger.info("ErrorMassege (" + subscriber.getMessage()+ ")");
//       Assert.assertEquals(subscriber.getMessage(), IgnoreError400.EXIST_EMAIL.toString());
        }
    
    @DataProvider
    public Object[][] badEmail() {
        return new Object[][] { { UserRepository.get().temporary(), UserSubscriberRepository.getFaultyEmail()}};
    }
    
   // @Test(dataProvider = "badEmail")
    public void faultyEmail(User user, UserSubscriber userSubscriber) {
       logger.info("Start checkLogin(" + user + ")");
       TipsTricksService tipsTricksService = loadApplication()
               .successfulUserLogin(user)
               .gotoTipsTricksService();
       logger.info("Subscriber (" + userSubscriber +")");
       List<NewsSubscriberEntity> subscriber = tipsTricksService.faultySubscriber(userSubscriber);
//       logger.info("ErrorMassege (" + subscriber.getMessage()+ ")");
//       Assert.assertEquals(subscriber.getMessage(), IgnoreError400.FAULTY_EMAIL.toString());
        }
}
