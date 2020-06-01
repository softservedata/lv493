package com.softserve.edu.greencity.rest.entity.places;

public class LocationEntity {
	
	private int id;
	private double lat;
	private double lng;;
	private String address;
	
	public LocationEntity() {
		
		this.id = -1;
		this.lat = -1;
		this.lng = -1;
		this.address = "";
	}
	
	public LocationEntity(int id, double lat, double lng, String address) {
		
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "LocationEntity [id=" + id + ", lat=" + lat + ", lng=" + lng + ", address=" + address + "]";
	}
	
	

}
