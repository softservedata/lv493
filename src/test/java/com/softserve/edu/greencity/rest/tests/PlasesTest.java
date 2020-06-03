package com.softserve.edu.greencity.rest.tests;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.PlaceStatus;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameterRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.data.places.PlaceId;
import com.softserve.edu.greencity.rest.data.places.PlacesInfoRepository;
import com.softserve.edu.greencity.rest.entity.places.PageEntity;
import com.softserve.edu.greencity.rest.entity.places.PlaceInfoEntity;
import com.softserve.edu.greencity.rest.services.PlacesGuestService;
import com.softserve.edu.greencity.rest.services.PlacesService;

public class PlasesTest  extends GreencityRestTestRunner{
	
	 @DataProvider
	    public Object[][] invalidEmaildata() {
	        return new Object[][]{{UserRepository.get().temporaryInvalidEmail(), PageParameterRepository.getNews(), PlaceStatus.PROPOSED  }};
	        
	    }
	 
	 @DataProvider
		public Object[][] econews() {
		
			return new Object[][] { { UserRepository.get().temporary(), PageParameterRepository.getNews()  } };
//				 PlaceStatus.PROPOSED } };
		}

	 //@Test (dataProvider = "econews")
	 //   public void checkPlaceStatus( ) {
	    public void checkPlaceStatus( User user, PageParameters pageParameters, PlaceStatus status) {
	       logger.info("checkPlaceStatu(" + user + ")");
	       PlacesService placesService = loadApplication()
	                .successfulUserLogin(user)
	                .gotoPlacesService();

	        System.out.println("placesServiceEntity = "
	                + placesService.getPlaceStatusResourse());
	       PageEntity pageEntity = placesService.getPlasesByStatus(pageParameters, status);
	       System.out.println(pageEntity);

	    }
	    
	   // @Test (dataProvider = "invalidEmaildata")
//		    public void checkPlaceStatusWithInvalidEmail( User user, PageParameters pageParameters, PlaceStatus status) {
//		       logger.info("checkPlaceStatusWithInvalidEmail(" + user + ")");
//		        PlacesService placesService = loadApplication()
//		                .successfulUserLogin(user)
//		                .gotoPlacesService();
//
//		        System.out.println("placesServiceEntity = "
//		                + placesService.getPlaceStatusResourse());
//		       PageEntity pageEntity = placesService.getPlasesByStatus(pageParameters, status);
//		       System.out.println(pageEntity);
////		       Assert.assertArrayEquals(expecteds, actuals);
//
//		    }
//	    
	    
	    //@Test (dataProvider = "econews")
		    public void checkPlace( User user, PageParameters pageParameters) {
		    		//, PlaceStatus status) {
		       logger.info("checkPlaceStatusWithInvalidEmail(" + user + ")");
		        PlacesService placesService = loadApplication()
		                .successfulUserLogin(user)
		                .gotoPlacesService();

		        System.out.println("placesServiceEntity = "
		                + placesService.getPlacePredicateRsourse());
		       PageEntity pageEntity = placesService.getPlasesByPredicate(pageParameters);
		    		   //, status);
		       System.out.println(pageEntity);
//		       Assert.assertArrayEquals(expecteds, actuals);

		    }
	    

	    @DataProvider
	    public Object[][] placeInfo() {
	        return new Object[][] { {PlacesInfoRepository.getPlaceId() } };
	    }
	    
	  //  @Test (dataProvider = "placeInfo")
		    public void checkInfoPlace(  PlaceId placeId) {
		    		//, PlaceStatus status) {
		       logger.info("checkInfoPlace");
		        PlacesGuestService placesService = loadApplication()
		        		.gotoPlacesGuestService();
		        		
		       PlaceInfoEntity placeEntity = placesService.placeInfoID(placeId);
		    		   //, status);
		       System.out.println(placeEntity);
//		       Assert.assertArrayEquals(expecteds, actuals);

		    }
}
