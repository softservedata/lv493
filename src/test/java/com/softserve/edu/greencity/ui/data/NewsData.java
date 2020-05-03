package com.softserve.edu.greencity.ui.data;

import java.util.List;

public class NewsData {
    private String title;
    private List<NewsFilter> tags;
    private String source;
    private String content;
    private String filePath;

    public NewsData(String title, List<NewsFilter> tags, String source, String content, String filePath) {
        this.title = title;
        this.tags = tags;
        this.source = source;
        this.content = content;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getTitle() {
        return title;
    }

    public List<NewsFilter> getTags() {
        return tags;
    }

    public String getSource() {
        return source;
    }

    public String getContent() {
        return content;
    }
}
