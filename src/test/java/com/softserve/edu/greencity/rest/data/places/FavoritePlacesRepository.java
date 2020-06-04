package com.softserve.edu.greencity.rest.data.places;

import com.softserve.edu.greencity.rest.entity.places.FavoritePlaceEntity;
import com.softserve.edu.greencity.rest.tools.ConnectionToDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        return 2;
    }

    public FavoritePlaceEntity getDefaultPlace() {
        return new FavoritePlaceEntity(2, "My Place");
    }

    public FavoritePlaceEntity getUpdatePlace() {
        return new FavoritePlaceEntity(2, "Victoria Gardens");
    }

    public String temporary() {
        return getPlaceId();
    }

    private String getPlaceId() {
        ConnectionToDatabase connection = new ConnectionToDatabase();
        String query1 = "select place_id from favorite_places\n" +
                "limit 1;";
        String q = "";
        try (ResultSet rs = connection.createStatement().executeQuery(query1)) {
            if (rs.next()) {
                q = rs.getObject("place_id").toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q;
    }
}
