package com.softserve.edu.greencity.ui.data;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {

    private NewsRepository() {
    }

    public static OneNewsData getDefault() {
        return getAllFildsNews();
    }

    public static OneNewsData getAllFildsNews() {
        List<String> tags = new ArrayList<>();
        tags.add("News");
        tags.add("Events");
        return new OneNewsData( tags,  "Green Day", "Content = description");
    }
}

