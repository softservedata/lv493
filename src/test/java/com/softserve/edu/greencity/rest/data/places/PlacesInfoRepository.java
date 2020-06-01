package com.softserve.edu.greencity.rest.data.places;

import com.softserve.edu.greencity.rest.data.PlaceStatus;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;

public class PlacesInfoRepository {

	private  PlacesInfoRepository() {
	}

	
	public static User getDefault() {
		return temporary();
	}
	
	public static User temporary() {
		return new User("xdknxusqvjeovowpfk@awdrt.com", "temp", "Temp#001");
	}
	
	public static PlacePredicate getPlacePredicate() {
		return new PlacePredicate(new DiscountDto(0.0, 0.0, new Specification("all")), 
				new DistanceFromUserDto(0, 0, 0), 
				new MapBoundsDto(0, 0, 0, 0),
				" ", PlaceStatus.APPROVED, "30/05/2020 11:23:00");
	}
	
	public static PlaceId getPlaceId() {
		return new PlaceId(1);
	}
	
}
