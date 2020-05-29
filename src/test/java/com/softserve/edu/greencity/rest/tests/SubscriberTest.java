package com.softserve.edu.greencity.rest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.IgnoreError400;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.UserSubscriber;
import com.softserve.edu.greencity.rest.data.UserSubscriberRepository;
import com.softserve.edu.greencity.rest.entity.ErrorEntity;
import com.softserve.edu.greencity.rest.entity.NewsSubscriberEntity;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.rest.services.TipsTricksService;

public class SubscriberTest extends GreencityRestTestRunner {
 
    @DataProvider
    public Object[][] rendomEmail() {
        return new Object[][] { { UserRepository.get().temporary(), UserSubscriberRepository.getRandomEmail() } };
    }
    
//    @Test(dataProvider = "rendomEmail")
    public void singleEmail(User user, UserSubscriber userSubscriber) {
        logger.info("Start checkLogin(" + user + ")");
        TipsTricksService tipsTricksService = loadApplication()
                .successfulUserLogin(user)
                .gotoTipsTricksService();
//       System.out.print("\t***newsSubscribeEntity = "
//                + tipsTricksService.subscribeEntity(userSubscriber));
       Assert.assertEquals(tipsTricksService.subscribeEntity(userSubscriber).getEmail(), userSubscriber.getEmail());
      
   
    }
    
    
    @DataProvider
    public Object[][] sameEmail() {
        return new Object[][] { { UserRepository.get().temporary(), UserSubscriberRepository.getSingleEmail()}};
    }
 //todo 
    @Test(dataProvider = "sameEmail")
    public void SingInSame(User user, UserSubscriber userSubscriber) {
       TipsTricksService tipsTricksService = loadApplication()
               .successfulUserLogin(user)
               .gotoTipsTricksService();
      System.out.println(UserSubscriberRepository.getSingleEmail());
     System.out.println("subscribeEntity = "
               + tipsTricksService.previousSubscriber(userSubscriber));
//     String erorr = new ErrorEntity().getMessage();
//     System.out.println("error = " + erorr);
//      NewsSubscriberEntity subscriber = tipsTricksService.subscribeEntity(userSubscriber);
//     Assert.assertEquals(tipsTricksService.subscribeEntity(userSubscriber).getEmail(), userSubscriber.getEmail());

        }
    
}
