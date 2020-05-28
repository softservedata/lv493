package com.softserve.edu.greencity.rest.entity;

import com.softserve.edu.greencity.rest.data.HabitRate;

public class HabitStatisticEntity {

    private int id;
    private int amountOfItems;
    private String createdOn;
    private HabitRate habitRate;

    public HabitStatisticEntity() {
        amountOfItems = -1;
        createdOn = null;
        habitRate = HabitRate.DEFAULT;
        id = -1;
    }

    public HabitStatisticEntity(int id, String createdOn, HabitRate habitRate,
            int amountOfItems) {
        this.amountOfItems = amountOfItems;
        this.createdOn = createdOn;
        this.habitRate = habitRate;
        this.id = id;
    }

    public int getAmountOfItems() {
        return amountOfItems;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public HabitRate getHabitRate() {
        return habitRate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HabitStatisticEntity [amountOfItems=" + amountOfItems
                + ", createdOn=" + createdOn + ", habitRate=" + habitRate
                + ", id=" + id + "]";
    }

}
