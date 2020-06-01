package com.softserve.edu.greencity.rest.data.places;

public class PlaceId {
	
	private int id;

	public PlaceId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PlaceId [id=" + id + "]";
	}
	
	

}
