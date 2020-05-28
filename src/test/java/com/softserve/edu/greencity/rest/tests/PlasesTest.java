package com.softserve.edu.greencity.rest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.PlaceStatus;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.econews.News;
import com.softserve.edu.greencity.rest.data.econews.PageParameterRepository;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.entity.places.PageEntity;
import com.softserve.edu.greencity.rest.services.PlacesService;

public class PlasesTest  extends GreencityRestTestRunner{
	
	 @DataProvider
	    public Object[][] data() {
	        return new Object[][]{{UserRepository.get().temporary(), PageParameterRepository.getNews() }};
	        	//PlaceStatus.APPROVED.toString()}};
	    }
	 
	 @DataProvider
		public Object[][] econews() {
		 logger.info("-----");
			return new Object[][] { { UserRepository.get().temporary(), PageParameterRepository.getNews(), PlaceStatus.PROPOSED } };
		}

	    @Test (dataProvider = "econews")
	 //   public void checkPlaceStatus( ) {
	    public void checkPlaceStatus( User user, PageParameters pageParameters, PlaceStatus status) {
	       logger.info("checkPlaceStatu(" + user + ")");
//	    	User user =  UserRepository.get().temporary();
//	    	PageParameters pageParameters = PageParameterRepository.getNews();
//	    	PlaceStatus statu = PlaceStatus.APPROVED;
	        PlacesService placesService = loadApplication()
	                .successfulUserLogin(user)
	                .gotoPlacesService();

	        System.out.println("placesServiceEntity = "
	                + placesService.getPlaceStatusResourse());
	       PageEntity pageEntity = placesService.getPlasesByStatus(pageParameters, status);
	       System.out.println(pageEntity);

	    }
}
