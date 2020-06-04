package com.softserve.edu.greencity.rest.entity.places;

import com.softserve.edu.greencity.rest.entity.econewsEntity.AuthorEntity;
import com.softserve.edu.greencity.rest.tools.Verifiable;

import java.util.List;

public class PlaceEntity implements Verifiable {

    private int id;
    private String name;
    private LocationEntity location;
    private CategoryEntity category;
    private List<OpeningHoursEntity> openingHoursList;
    private AuthorEntity author;
    private String status;
    private String modifiedDate;

    public PlaceEntity() {

        this.id = -1;
        this.name = "";
        this.location = null;
        this.category = null;
        this.openingHoursList = null;
        this.author = null;
        this.status = "";
        this.modifiedDate = "";
    }

    public PlaceEntity(int id, String name, LocationEntity location, CategoryEntity category,
                       List<OpeningHoursEntity> openingHoursList, AuthorEntity author, String status, String modifiedDate) {

        this.id = id;
        this.name = name;
        this.location = location;
        this.category = category;
        this.openingHoursList = openingHoursList;
        this.author = author;
        this.status = status;
        this.modifiedDate = modifiedDate;
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

    public CategoryEntity getCategory() {
        return category;
    }

    public List<OpeningHoursEntity> getOpeningHoursList() {
        return openingHoursList;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public String toString() {
        return "PlaceEntity [id=" + id + ", name=" + name + ", location=" + location + ", category=" + category
                + ", openingHoursList=" + openingHoursList + ", author=" + author + ", status=" + status
                + ", modifiedDate=" + modifiedDate + "]";
    }


    @Override
    public boolean isValid() {
        return (id > -1) && (name != null)
                && (name.length() > 0) && (location != null);
    }
}
