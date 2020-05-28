package com.softserve.edu.greencity.rest.entity;

import java.util.List;

public class CustomGoalSaveEntity {

    private List<CustomGoal> customGoalSaveRequestDtoList;

    public CustomGoalSaveEntity(List<CustomGoal> customGoalSaveRequestDtoList) {
        this.customGoalSaveRequestDtoList = customGoalSaveRequestDtoList;
    }

    public List<CustomGoal> getCustomGoalSaveRequestDtoList() {
        return customGoalSaveRequestDtoList;
    }

    @Override
    public String toString() {
        return "CustomGoalSaveEntity [customGoalSaveRequestDtoList="
                + customGoalSaveRequestDtoList + "]";
    }

    public static class CustomGoal {
        private String text;

        public CustomGoal(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return "CustomGoal [text=" + text + "]";
        }

    }
}
