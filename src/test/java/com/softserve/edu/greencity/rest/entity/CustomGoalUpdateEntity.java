package com.softserve.edu.greencity.rest.entity;

import java.util.List;

public class CustomGoalUpdateEntity {

    private List<CustomGoal> customGoals;

    public CustomGoalUpdateEntity(List<CustomGoal> customGoalSaveRequestDtoList) {
        this.customGoals = customGoalSaveRequestDtoList;
    }

    public List<CustomGoal> getcustomGoals() {
        return customGoals;
    }

    public static class CustomGoal {
        private int id;
        private String text;

        public CustomGoal(int id, String text) {
            this.id = id;
            this.text = text;
        }

        public int getId() {
            return id;
        }

        public String getText() {
            return text;
        }
    }
}
