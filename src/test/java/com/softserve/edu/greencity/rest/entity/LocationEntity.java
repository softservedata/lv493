package com.softserve.edu.greencity.rest.entity;

public class LocationEntity {

    private String address;
    private double lat;
    private double lng;
    public LocationEntity() {
        this.address = "";
        this.lat = -1;
        this.lng = -1;
    }
    public LocationEntity(String address, double lat, double lng) {
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }
    public String getAddress() {
        return address;
    }
    public double getLat() {
        return lat;
    }
    public double getLng() {
        return lng;
    }
    @Override
    public String toString() {
        return "LocationEntity [address=" + address + ", lat=" + lat + ", lng=" + lng + "]";
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setLat(int lat) {
        this.lat = lat;
    }
    public void setLng(int lng) {
        this.lng = lng;
    }
    
    
}
