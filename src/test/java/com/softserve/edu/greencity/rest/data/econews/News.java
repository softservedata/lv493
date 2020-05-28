package com.softserve.edu.greencity.rest.data.econews;

import com.softserve.edu.greencity.rest.entity.econewsEntity.AuthorEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class News {
    private String imagePath;
    private String title;
    private String text;
    private String source;
    private List<String> tags;
    private Author author;

    public News(String imagePath, String title, String text, String source, List<String> tags, Author author) {
        this.imagePath = imagePath;
        this.title = title;
        this.text = text;
        this.source = source;
        this.tags = tags;
        this.author = author;
    }

// setters

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
// getters

    public String getImagePath() {
        return imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getSource() {
        return source;
    }

    public List<String> getTags() {
        return tags;
    }

    public Author getAuthor() {
        return author;
    }

    // static factory

    public static News converToNews(NewsEntity newsEntity) {
        return new News(newsEntity.getImagePath(), newsEntity.getTitle(),
                newsEntity.getText(), newsEntity.getSource(), newsEntity.getTags(), AuthorEntity.convertToAuthor(newsEntity.getAuthor()));
    }

    public static List<News> converToNewsList(List<NewsEntity> newsEntities) {
        List<News> result = new ArrayList<>();
        for (NewsEntity newsEntity : newsEntities) {
            result.add(converToNews(newsEntity));
        }
        return result;
    }


    @Override
    public String toString() {
        return "\n **News = " +
                "imagePath='" + imagePath + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", tags=" + tags +
                ", author=" + author + ";";
    }
}
