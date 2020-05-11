package com.softserve.edu.greencity.ui.data;

import java.util.ArrayList;
import java.util.List;

public class NewsDataRepository {

    private NewsDataRepository() {
    }

    public static NewsData getDefault() {
        return getAllFieldsNews();
    }

    public static NewsData getAllFieldsNews() {
        List<Tag> tags = new ArrayList<>();
        tags.add(Tag.EVENTS);
        tags.add(Tag.NEWS);
        return new NewsData("Green Day", tags, "https://news.com",
                "Content = description", "D:\\news.png");
    }

    public static NewsData getInvalidData() {
        List<Tag> tags = new ArrayList<>();
        tags.add(Tag.EVENTS);
        tags.add(Tag.NEWS);
        tags.add(Tag.COURCES);
        tags.add(Tag.ADS);
        return new NewsData("For some of the contribution workflows, " +
                "you need to have GreenCity running locally. For example, " +
                "previewing coding challenges or debugging and fixing bugs in the codebase.",
                tags, "news.com", "Content", "C:\\Users\\mJana\\Desktop\\giphy.gif");
    }
}
