package com.softserve.edu.greencity.rest.entity;

public class FavoritePlaceEntity {
    private int placeId;
    private int id;
    private String name;

    public FavoritePlaceEntity() {
        this.id = -1;
        this.placeId = -1;
        this.name = "";
    }

    public FavoritePlaceEntity(int id, int placeId, String name) {
        this.id = id;
        this.placeId = placeId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPlaceId() {
        return placeId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nFavoritePlaceEntity{" +
                "placeId=" + placeId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
