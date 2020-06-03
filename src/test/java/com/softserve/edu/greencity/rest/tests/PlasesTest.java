package com.softserve.edu.greencity.rest.tests;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.IgnoreError401;
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
import com.softserve.edu.greencity.rest.tools.VerifyUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class PlasesTest  extends GreencityRestTestRunner{
	
	 @DataProvider
	    public Object[][] invalidEmaildata() {
	        return new Object[][]{{UserRepository.get().temporaryInvalidEmail(), PageParameterRepository.getNews(), PlaceStatus.PROPOSED  }};
	        
	    }
	 
	 @DataProvider
		public Object[][] places() {
					return new Object[][] { { UserRepository.get().temporary(), PageParameterRepository.getNews(), PlaceStatus.APPROVED  } };
		}
	 	
	 	/**
	 	 * Get info about places by status
	 	 * @param user
	 	 * @param pageParameters
	 	 * @param status
	 	 */
	    @Description("Check places by status")
		@Severity(SeverityLevel.NORMAL)
		@Parameters({"Loggined User", "pageParameters", "placeStatus"})
		@Epic("Places")
	 	@Test (dataProvider = "places")
	    public void checkPlaceStatus(User user, PageParameters pageParameters, PlaceStatus status) {
	       logger.info("checkPlaceStatu(" + user + ")");
	       
	       PlacesService placesService = loadApplication()
	                .successfulUserLogin(user)
	                .gotoPlacesService();
	       
	       PageEntity pageEntity = placesService.getPlasesByStatus(pageParameters, status);
	       logger.info("pageEntity = " + pageEntity);

	       Assert.assertTrue("Test checkPlaceStatus: list with places is empty", pageEntity.getPage() != null);
	    }
	    
	    /**
	     * Negative test, check error message 
	     * @param user
	     * @param pageParameters
	     * @param status
	     */
	    @Description("check Place Status With InvalidEmail")
		@Severity(SeverityLevel.NORMAL)
		@Parameters({ "Loggined User", "pageParameters", "placeStatus" })
		@Epic("Places")
		@Test(dataProvider = "invalidEmaildata")
		public void checkPlaceStatusWithInvalidEmail(User user, PageParameters pageParameters, PlaceStatus status) {

			logger.info("checkPlaceStatusWithInvalidEmail(" + user + ")");
			PlacesService placesService = loadApplication().successfulUserLogin(user).gotoPlacesService();

			PageEntity pageEntity = placesService.getPlasesByStatus(pageParameters, status);

			logger.info("pageEntity = " + pageEntity);
			Assert.assertEquals("Test checkPlaceStatusWithInvalidEmail failed: Error messages do not match",
					pageEntity.getMessage(), IgnoreError401.AUTHORIZE_FIRST.toString());

		}
	    
	   // @Test (dataProvider = "places")
		    public void checkPlace(User user, PageParameters pageParameters) {
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
	    
		// TODO delete test;
		// request does not work
	    /**
	     * Get information about favorite place by id
	     * @param placeId
	     */
		@Description("check Info about favorite place")
		@Severity(SeverityLevel.NORMAL)
		@Parameters({"Loggined User", "pageParameters", "placeStatus" })
		@Epic("Places")
		//@Test(dataProvider = "placeInfo")
		public void checkInfoPlace(PlaceId placeId) {

			logger.info("checkInfoPlace");
			PlacesGuestService placesService = loadApplication().gotoPlacesGuestService();

			PlaceInfoEntity placeEntity = placesService.placeInfoID(placeId);

			Assert.assertEquals("Test checkInfoPlace failed", placeEntity.getId(), placeId);

		 }
}
