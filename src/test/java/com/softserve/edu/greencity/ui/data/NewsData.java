package com.softserve.edu.greencity.ui.data;

import java.util.List;

public class NewsData {
    private String title;
    private List<String> tags;
    private String source;
    private String content;

    public NewsData(String title, List<String> tags, String source, String content) {
        this.title = title;
        this.tags = tags;
        this.source = source;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getSource() {
        return source;
    }

    public String getContent() {
        return content;
    }
}
