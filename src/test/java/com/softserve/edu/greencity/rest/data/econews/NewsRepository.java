package com.softserve.edu.greencity.rest.data.econews;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {

    private static  NewsRepository instance = null;

    private NewsRepository() {
    }

    public static NewsRepository get() {
        if (instance == null) {
            synchronized (NewsRepository.class) {
                if (instance == null) {
                    instance = new NewsRepository();
                }
            }
        }
        return instance;
    }

    public News getDefault() {
        return temporary();
    }

    public News temporary() {
        List <String > tags = new ArrayList<>();
        tags.add("news");
        tags.add("events");
        return new News("C:\\Users\\mJana\\Documents\\GitHub\\lv493\\src\\test\\resources\\ecobag.jpg", "Reusable shopping bag",
                "A reusable shopping bag, sometimes called bag-for-life in the UK", "", tags, null );
    }

}