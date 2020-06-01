package com.softserve.edu.greencity.rest.data.econews;

import com.softserve.edu.greencity.rest.entity.econewsEntity.AuthorEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.tools.Verifiable;

import java.util.ArrayList;
import java.util.List;

public class News implements Verifiable {
    private int id;
    private String imagePath;
    private String title;
    private String text;
    private String source;
    private List<String> tags;
    private Author author;

    public News() {
        this.id = -1;
        this.imagePath = "";
        this.title = "";
        this.text = "";
        this.source = "";
        this.tags = new ArrayList<>();
        this.author = new Author();
    }

    public News(String imagePath, String title, String text, String source) {
        this.id = -1;
        this.imagePath = imagePath;
        this.title = title;
        this.text = text;
        this.source = source;
        this.tags = new ArrayList<>();
        this.author = new Author();
    }

    public News(String imagePath, String title, String text, String source, List<String> tags) {
        this.imagePath = imagePath;
        this.title = title;
        this.text = text;
        this.source = source;
        this.tags = tags;
    }

    public News(int id, String imagePath, String title, String text,
                String source, List<String> tags, Author author) {
        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
        this.text = text;
        this.source = source;
        this.tags = tags;
        this.author = author;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

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

    public News addTags(String tag) {
        tags.add(tag);
        return this;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    // getters

    public int getId() {
        return id;
    }

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
        return new News(newsEntity.getId(), newsEntity.getImagePath(), newsEntity.getTitle(),
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
        return "\nNews{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", tags=" + tags +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean isValid() {
        return (id != -1)
                &&(title != null) && (title.length() > 0 )
                &&(text != null) && (text.length() > 0 )
                &&(tags != null) && (tags.size() > 0 );
    }
}
