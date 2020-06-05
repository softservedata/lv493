package com.softserve.edu.greencity.rest.entity.myhabits;

import java.util.ArrayList;
import java.util.List;

public class UserHabitStatisticEntity {
    private List<Items> allItemsPerMonth;
    private String creationDate;
    private List<Items> differenceUnTakenItemsWithPreviousDay;

    public UserHabitStatisticEntity() {
        allItemsPerMonth = new ArrayList<>();
        creationDate = "";
        differenceUnTakenItemsWithPreviousDay = new ArrayList<>();
    }

    public UserHabitStatisticEntity(String createDate) {
        allItemsPerMonth = new ArrayList<>();
        this.creationDate = createDate;
        differenceUnTakenItemsWithPreviousDay = new ArrayList<>();
    }

    public String getCreateDate() {
        return creationDate;
    }

    public List<Items> getDifferenceUnTakenItemsWithPreviousDay() {
        return differenceUnTakenItemsWithPreviousDay;
    }

    public List<Items> getAllItemsPerMonth() {
        return allItemsPerMonth;
    }

    public UserHabitStatisticEntity addItemPerMonth(int habitItemAmount, String habitItemName) {
        allItemsPerMonth.add(new Items(habitItemAmount, habitItemName));
        return this;
    }

    public UserHabitStatisticEntity addUnTakenItem(int habitItemAmount, String habitItemName) {
        differenceUnTakenItemsWithPreviousDay.add(new Items(habitItemAmount, habitItemName));
        return this;
    }

    @Override
    public String toString() {
        return "UserHabitStatisticEntity [allItemsPerMonth=" + allItemsPerMonth
                + ", creationDate=" + creationDate
                + ", differenceUnTakenItemsWithPreviousDay="
                + differenceUnTakenItemsWithPreviousDay + "]";
    }


    public class Items {
        private int habitItemAmount;
        private String habitItemName;

        public Items() {
            habitItemAmount = -1;
            habitItemName = "";
        }

        public Items(int habitItemAmount, String habitItemName) {
            this.habitItemAmount = habitItemAmount;
            this.habitItemName = habitItemName;
        }

        public int getHabitItemAmount() {
            return habitItemAmount;
        }

        public String getHabitItemName() {
            return habitItemName;
        }

        @Override
        public String toString() {
            return "Items [habitItemAmount=" + habitItemAmount
                    + ", habitItemName=" + habitItemName + "]";
        }

    }
}