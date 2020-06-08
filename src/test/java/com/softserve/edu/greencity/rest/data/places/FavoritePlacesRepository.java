package com.softserve.edu.greencity.rest.data.places;

import com.softserve.edu.greencity.rest.entity.places.FavoritePlaceEntity;

public class FavoritePlacesRepository {

    private static FavoritePlacesRepository instance = null;

    private FavoritePlacesRepository() {
    }

    public static FavoritePlacesRepository get() {
        if (instance == null) {
            synchronized (FavoritePlacesRepository.class) {
                if (instance == null) {
                    instance = new FavoritePlacesRepository();
                }
            }
        }
        return instance;
    }

    public int getDefault() {
        return 3;
    }

    public FavoritePlaceEntity getDefaultPlace() {
        return new FavoritePlaceEntity(3, "My Place");
    }

    public FavoritePlaceEntity getUpdatePlace() {
        return new FavoritePlaceEntity(3, "Victoria Gardens");
    }
}
