package com.softserve.edu.greencity.ui.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for testing EconewsPage;
 * @author lv-493
 *
 */
public class NewsRepository {

    private NewsRepository() {
    }

    public static NewsData getDefault() {
        return getAllFildsNews();
    }

    public static NewsData getAllFildsNews() {
        List<Tag> tags = new ArrayList<>();
        tags.add(Tag.NEWS);
        tags.add(Tag.ADS);
        return new NewsData(tags, "title", "text");
    }
    
    public static List<Tag> getNewsByTags() {
    	 List<Tag> tags = new ArrayList<>();
         tags.add(Tag.NEWS);
         return tags;
    }
}

