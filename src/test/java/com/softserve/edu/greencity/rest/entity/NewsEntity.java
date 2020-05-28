package com.softserve.edu.greencity.rest.entity;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.json.Json;

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

}
