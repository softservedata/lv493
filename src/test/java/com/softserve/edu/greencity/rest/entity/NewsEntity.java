package com.softserve.edu.greencity.rest.entity;

import org.openqa.selenium.json.Json;

import java.util.ArrayList;
import java.util.List;

public class NewsEntity extends AllNewsResponseEntity {
    private int id;
    private String creationDate;
    private String imagePath;
    private String title;
    private String text;
    private String source;
    private Json author;
    private List<String> tags;

    public NewsEntity() {
        id = -1;
        creationDate = "";
        imagePath = "";
        title = "";
        text = "";
        source = "";
        author = new Json();
        tags = new ArrayList<>();
    }

    public NewsEntity(int id, String creationDate, String imagePath, String title,
                      String text, String source, Json author, List<String> tags) {
        this.id = id;
        this.creationDate = creationDate;
        this.imagePath = imagePath;
        this.title = title;
        this.text = text;
        this.source = source;
        this.author = author;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Json getAuthor() {
        return author;
    }

    public void setAuthor(Json author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
