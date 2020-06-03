package com.softserve.edu.greencity.rest.data.places;

import com.softserve.edu.greencity.rest.entity.places.FavoritePlaceEntity;
import com.softserve.edu.greencity.rest.tools.Verifiable;

import java.util.ArrayList;
import java.util.List;

public class FavoritePlace implements Verifiable {
    private int placeId;
    private int id;
    private String name;

    public FavoritePlace() {
        this.id = -1;
        this.placeId = -1;
        this.name = "";
    }

    public FavoritePlace(int placeId, String name) {
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

    // static factory

    public static FavoritePlace convertToPlace(FavoritePlaceEntity favoritePlaceEntity) {
        return new FavoritePlace(favoritePlaceEntity.getPlaceId(), favoritePlaceEntity.getName());
    }

    public static List<FavoritePlace> convertToPlacesList(List<FavoritePlaceEntity> favoritePlaceEntities) {
        List<FavoritePlace> result = new ArrayList<>();
        for (FavoritePlaceEntity placeEntity : favoritePlaceEntities) {
            result.add(convertToPlace(placeEntity));
        }
        return result;
    }

    @Override
    public String toString() {
        return "FavoritePlace{" +
                "placeId=" + placeId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean isValid() {
        return (placeId >= 0) && (id >= 0)
                && (name != null) && (name.length() > 0);
    }
}
