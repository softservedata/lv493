package com.softserve.edu.greencity.rest.entity;

public class LocationEntity {

    private String address;
    private String lat;
    private String lng;
    public LocationEntity() {
        this.address = "";
        this.lat = "";
        this.lng = "";
    }
    public LocationEntity(String address, String lat, String lng) {
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }
    public String getAddress() {
        return address;
    }
    public String getLat() {
        return lat;
    }
    public String getLng() {
        return lng;
    }
    @Override
    public String toString() {
        return "LocationEntity [address=" + address + ", lat=" + lat + ", lng=" + lng + "]";
    }
    
    
}
