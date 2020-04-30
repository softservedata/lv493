package com.softserve.edu.greencity.ui.data;

import java.util.ArrayList;
import java.util.List;

public class NewsDataRepository {

    private NewsDataRepository() {
    }

    public static NewsData getDefault() {
        return getAllFildsNews();
    }

    public static NewsData getAllFildsNews() {
        List<String> tags = new ArrayList<>();
        tags.add("News");
        tags.add("Events");
        return new NewsData("Green Day", tags, "sourse", "Content = description");
    }
}
