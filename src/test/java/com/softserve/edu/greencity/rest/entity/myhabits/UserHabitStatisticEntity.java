package com.softserve.edu.greencity.rest.entity.myhabits;

import java.util.ArrayList;
import java.util.List;

public class UserHabitStatisticEntity {
    private List<Items> allItemsPerMonth;
    private String createDate;
    private List<Items> differenceUnTakenItemsWithPreviousDay;

    public UserHabitStatisticEntity() {
        allItemsPerMonth = new ArrayList<>();
        createDate = "";
        differenceUnTakenItemsWithPreviousDay = new ArrayList<>();
    }

    public UserHabitStatisticEntity(List<Items> allItemsPerMonth,
            String createDate,
            List<Items> differenceUnTakenItemsWithPreviousDay) {
        this.allItemsPerMonth = allItemsPerMonth;
        this.createDate = createDate;
        this.differenceUnTakenItemsWithPreviousDay = differenceUnTakenItemsWithPreviousDay;
    }

    public List<Items> getAllItemsPerMonth() {
        return allItemsPerMonth;
    }

    public String getCreateDate() {
        return createDate;
    }

    public List<Items> getDifferenceUnTakenItemsWithPreviousDay() {
        return differenceUnTakenItemsWithPreviousDay;
    }

    @Override
    public String toString() {
        return "UserHabitsStatisticEntity [allItemsPerMonth=" + allItemsPerMonth
                + ", createDate=" + createDate
                + ", differenceUnTakenItemsWithPreviousDay="
                + differenceUnTakenItemsWithPreviousDay + "]";
    }

    class Items {
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

        @Override
        public String toString() {
            return "Items [habitItemAmount=" + habitItemAmount
                    + ", habitItemName=" + habitItemName + "]";
        }

    }
}