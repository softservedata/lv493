package com.softserve.edu.greencity.rest.entity;

public class AchievementEntity {
    private String description;
    private int id;
    private String message;
    private String title;

    public AchievementEntity() {
        description = "";
        id = -1;
        message = "";
        title = "";
    }

    public AchievementEntity(String description, int id, String message,
            String title) {
        this.description = description;
        this.id = id;
        this.message = message;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "AchievementEntity [description=" + description + ", id=" + id
                + ", message=" + message + ", title=" + title + "]";
    }

}
