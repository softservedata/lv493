package com.softserve.edu.greencity.ui.data;

public class GoalRepository {
    private GoalRepository() {
    }

    public static Goal getGoal() {
        return new Goal("Buy composter");
    }
}
