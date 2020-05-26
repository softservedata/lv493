package com.softserve.edu.greencity.rest.entity;

import java.util.ArrayList;

import com.google.gson.Gson;

public class PlaceAboutIDEntity {

    private int id;
    private String name;
    private LocationEntity locationEntity;
    private CategoryEntity categoryEntity;
    private DiscountValuesEntity discountValuesEntity;
    private ArrayList<OpeningHoursListEntity> openingHoursListEntities;

    public PlaceAboutIDEntity() {
        System.out.println("******PlaceAboutIDEntity default**");
        this.id = -1;
        this.name = "";
        this.locationEntity = new LocationEntity();
        this.categoryEntity = new CategoryEntity();
        this.discountValuesEntity = new DiscountValuesEntity();
        this.openingHoursListEntities = null;
    }

    public PlaceAboutIDEntity(int id, String name, LocationEntity locationEntity, CategoryEntity categoryEntity,
            DiscountValuesEntity discountValuesEntity, ArrayList<OpeningHoursListEntity> openingHoursListEntities) {
        System.out.println("******PlaceAboutIDEntity with parameters**");
        this.id = id;
        this.name = name;
        this.locationEntity = locationEntity;
        this.categoryEntity = categoryEntity;
        this.discountValuesEntity = discountValuesEntity;
        this.openingHoursListEntities = openingHoursListEntities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public DiscountValuesEntity getDiscountValuesEntity() {
        return discountValuesEntity;
    }

    public ArrayList<OpeningHoursListEntity> getOpeningHoursListEntities() {
        return openingHoursListEntities;
    }

    @Override
    public String toString() {
        return "PlaceAboutIDEntity [id=" + id + ", name=" + name + ", locationEntity=" + locationEntity + ", categoryEntity="
                + categoryEntity + ", discountValuesEntity=" + discountValuesEntity + ", openingHoursListEntities="
                + openingHoursListEntities + "]";
    }


}
