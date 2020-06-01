package com.softserve.edu.greencity.rest.entity.places;

import java.util.List;

public class PlaceInfoEntity {
	
	private int id;
	private String name;
	private LocationEntity location;
	private List<OpeningHoursEntity> openingHoursList;
	private List<DiscountValuesEntity> discountValues;
	private List<String> comments;
	private int rate;
	
	private String message;
	
	public PlaceInfoEntity() {
		
		this.id = 0;
		this.name = "";
		this.location = null;
		this.openingHoursList = null;
		this.discountValues = null;
		this.comments = null;
		this.rate = 0;
	}
	
	

	public PlaceInfoEntity(String message) {
	
		this.message = message;
		this.id = 0;
		this.name = "";
		this.location = null;
		this.openingHoursList = null;
		this.discountValues = null;
		this.comments = null;
		this.rate = 0;
	}

	public PlaceInfoEntity(int id, String name, LocationEntity location, List<OpeningHoursEntity> openingHoursList,
			List<DiscountValuesEntity> discountValues, List<String> comments, int rate) {
		
		this.id = id;
		this.name = name;
		this.location = location;
		this.openingHoursList = openingHoursList;
		this.discountValues = discountValues;
		this.comments = comments;
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public List<OpeningHoursEntity> getOpeningHoursList() {
		return openingHoursList;
	}

	public List<DiscountValuesEntity> getDiscountValues() {
		return discountValues;
	}

	public List<String> getComments() {
		return comments;
	}

	public int getRate() {
		return rate;
	}

	public String getMessage() {
		return message;
	}
	
	
	@Override
	public String toString() {
		return "PlaceInfoEntity [id=" + id + ", name=" + name + ", location=" + location + ", openingHoursList="
				+ openingHoursList + ", discountValues=" + discountValues + ", comments=" + comments + ", rate=" + rate
				+ "]";
	}
}
