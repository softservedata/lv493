package com.softserve.edu.greencity.rest.entity.myhabits;

import java.util.ArrayList;
import java.util.List;

public class GoalsEntity {
    private List<CustomGoal> userCustomGoal;
    private List<Goal> userGoals;

    public GoalsEntity(List<CustomGoal> userCustomGoal, List<Goal> userGoals) {
        this.userCustomGoal = userCustomGoal;
        this.userGoals = userGoals;
    }

    public List<CustomGoal> getUserCustomGoal() {
        return userCustomGoal;
    }

    public List<Goal> getUserGoals() {
        return userGoals;
    }

    @Override
    public String toString() {
        return "GoalsEntity [userCustomGoal=" + userCustomGoal + ", userGoals="
                + userGoals + "]";
    }

    public static class CustomGoal {
        private Id customGoal;

        public CustomGoal(Id customGoal) {
            this.customGoal = customGoal;
        }

        public Id getCustomGoal() {
            return customGoal;
        }

        @Override
        public String toString() {
            return "CustomGoal [customGoal=" + customGoal + "]";
        }


    }

    public static class Goal {
        private Id goal;

        public Goal(Id goal) {
            this.goal = goal;
        }

        public Id getGoal() {
            return goal;
        }

        @Override
        public String toString() {
            return "Goal [goal=" + goal + "]";
        }


    }

    public static class Id {
        private int id;

        public Id(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Id [id=" + id + "]";
        }

    }

    public static GoalsEntity convertToGoalsEntity(List<UserGoalEntity> goals, List<UserGoalEntity> customGoals) {
        List<GoalsEntity.Goal> userGoals = new ArrayList<>();
        goals.forEach(goal -> userGoals.add(new Goal(new Id(goal.getId()))));

        List<GoalsEntity.CustomGoal> userCustomGoals = new ArrayList<>();
        customGoals.forEach(goal -> userCustomGoals.add(new CustomGoal(new Id(goal.getId()))));

        return new GoalsEntity(userCustomGoals, userGoals);
    }
}
