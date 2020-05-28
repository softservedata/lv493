package com.softserve.edu.greencity.rest.entity;

import java.util.List;

public class UserHabitEntity {
    private String createDate;
    private String description;
    private HabitDictionary habitDictionary;
    private String habitItem;
    private String habitName;
    private List<HabitStatisticEntity> habitStatistics;
    private int id;
    private String name;
    private boolean status;

    public UserHabitEntity() {
        createDate = "";
        description = "";
        habitDictionary = null;
        habitItem = "";
        habitName = "";
        habitStatistics = null;
        id = -1;
        name = "";
        status = false;
    }

    public UserHabitEntity(int id, String habitName) {
        createDate = "";
        description = "";
        habitDictionary = null;
        habitItem = "";
        this.habitName = habitName;
        habitStatistics = null;
        this.id = id;
        name = "";
        status = false;
    }

    public UserHabitEntity(String createDate, String description,
            HabitDictionary habitDictionary, String habitItem, String habitName,
            List<HabitStatisticEntity> habitStatistics, int id, String name,
            boolean status) {
        this.createDate = createDate;
        this.description = description;
        this.habitDictionary = habitDictionary;
        this.habitItem = habitItem;
        this.habitName = habitName;
        this.habitStatistics = habitStatistics;
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getDescription() {
        return description;
    }

    public HabitDictionary getHabitDictionary() {
        return habitDictionary;
    }

    public String getHabitItem() {
        return habitItem;
    }

    public String getHabitName() {
        return habitName;
    }

    public List<HabitStatisticEntity> getHabitStatistics() {
        return habitStatistics;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "UserHabitsEntity [createDate=" + createDate + ", description="
                + description + ", habitDictionary=" + habitDictionary
                + ", habitItem=" + habitItem + ", habitName=" + habitName
                + ", habitStatistics=" + habitStatistics + ", id=" + id
                + ", name=" + name + ", status=" + status + "]";
    }

    public class HabitDictionary {
        private String description;
        private String habitItem;
        private int id;
        private String image;
        private String name;

        public HabitDictionary() {
            description = "";
            habitItem = "";
            id = -1;
            image = "";
            name = "";
        }

        public HabitDictionary(int id) {
            description = "";
            habitItem = "";
            this.id = id;
            image = "";
            name = "";
        }

        public HabitDictionary(String description, String habitItem, int id,
                String image, String name) {
            this.description = description;
            this.habitItem = habitItem;
            this.id = id;
            this.image = image;
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public String getHabitItem() {
            return habitItem;
        }

        public int getId() {
            return id;
        }

        public String getImage() {
            return image;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "HabitDictionary [description=" + description
                    + ", habitItem=" + habitItem + ", id=" + id + ", image="
                    + image + ", name=" + name + "]";
        }

    }

}