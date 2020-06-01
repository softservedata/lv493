package com.softserve.edu.greencity.rest.data.places;

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

    public String temporary() {
        return getPlaceId();
    }

    public String getFreshPlace() { return getFreshFavoritePlace();}

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

    private String getFreshFavoritePlace(){
        ConnectionToDatabase connection = new ConnectionToDatabase();
        String query1 = "select place_id from favorite_places\n" +
                "limit 1;";

        String query2 = "INSERT INTO favorite_places( name, place_id, user_id) " +
                "VALUES ('value1', 0, 1);";

        String q = "-1";

        try {
            connection.createStatement().executeQuery(query2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try (   ResultSet rs = connection.createStatement().executeQuery(query1)) {
            if (rs.next()) {
                q = rs.getObject("place_id").toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("PlaceId " + q);
        return q;
    }
}
