package com.softserve.edu.greencity.ui.data;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {

    private NewsRepository() {
    }

    public static NewsData getDefault() {
        return getAllFildsNews();
    }

    public static NewsData getAllFildsNews() {
        List<Tag> tags = new ArrayList<>();
        tags.add(Tag.NEWS);
        tags.add(Tag.EVENTS);
        return new NewsData( tags,  "title", "text");
    }
}

