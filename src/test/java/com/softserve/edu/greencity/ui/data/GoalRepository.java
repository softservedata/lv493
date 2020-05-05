package com.softserve.edu.greencity.ui.data;

public class GoalRepository {
    private GoalRepository() {
    }

    public static Goal getGoalForSelecting() {
        return new Goal("Buy composter");
    }

    public static Goal getGoalForAdding() {
        return new Goal("Buy eco products for washing");
    }
}
