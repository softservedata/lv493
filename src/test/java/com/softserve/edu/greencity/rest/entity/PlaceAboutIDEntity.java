package com.softserve.edu.greencity.rest.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class PlaceAboutIDEntity {

    private int id;
    private String name;
    private LocationEntity location;
    private CategoryEntity category;
    private ArrayList<DiscountValuesEntity> discountValues;
    private ArrayList<OpeningHoursListEntity> openingHoursList;

    public PlaceAboutIDEntity() {
        System.out.println("******PlaceAboutIDEntity default**");
        this.id = -1;
        this.name = "";
        this.location = new LocationEntity();
        this.category = new CategoryEntity();
        this.discountValues = null;
        this.openingHoursList = null;
    }

    public PlaceAboutIDEntity(int id, String name, LocationEntity location, CategoryEntity category,
            ArrayList<DiscountValuesEntity> discountValues, ArrayList<OpeningHoursListEntity> openingHoursList) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.category = category;
        this.discountValues = discountValues;
        this.openingHoursList = openingHoursList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocationEntity getLocationEntity() {
        return location;
    }

    public CategoryEntity getCategoryEntity() {
        return category;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ArrayList<DiscountValuesEntity> getDiscountValues() {
        return discountValues;
    }

    public ArrayList<OpeningHoursListEntity> getOpeningHoursList() {
        return openingHoursList;
    }

    @Override
    public String toString() {
        return "PlaceAboutIDEntity [id=" + id + ", name=" + name + ", location=" + location + ", category=" + category
                + ", discountValues=" + discountValues + ", openingHoursList=" + openingHoursList + "]";
    }

}
