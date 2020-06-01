package com.softserve.edu.greencity.rest.data.myhabits;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.myhabits.UserHabitStatisticEntity;

public class UserHabitStatistic {
    private List<Items> allItemsPerMonth;
    private String creationDate;
    private List<Items> unTakenItems;

    public UserHabitStatistic() {
        allItemsPerMonth = new ArrayList<>();
        creationDate = "";
        unTakenItems = new ArrayList<>();
    }

    public UserHabitStatistic(String createDate) {
        allItemsPerMonth = new ArrayList<>();
        this.creationDate = createDate;
        unTakenItems = new ArrayList<>();
    }

    public String getCreateDate() {
        return creationDate;
    }

    public List<Items> getDifferenceUnTakenItems() {
        return unTakenItems;
    }

    public List<Items> getAllItemsPerMonth() {
        return allItemsPerMonth;
    }

    public UserHabitStatistic addItemPerMonth(int habitItemAmount, String habitItemName) {
        allItemsPerMonth.add(new Items(habitItemAmount, habitItemName));
        return this;
    }

    public UserHabitStatistic addUnTakenItem(int habitItemAmount, String habitItemName) {
        unTakenItems.add(new Items(habitItemAmount, habitItemName));
        return this;
    }

    @Override
    public String toString() {
        return "UserHabitStatistic [allItemsPerMonth=" + allItemsPerMonth
                + ", creationDate=" + creationDate
                + ", unTakenItems="
                + unTakenItems + "]";
    }


   // static factory

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((allItemsPerMonth == null) ? 0
                : allItemsPerMonth.hashCode());
        result = prime * result
                + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result
                + ((unTakenItems == null) ? 0 : unTakenItems.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        UserHabitStatistic other = (UserHabitStatistic) obj;
        if (((allItemsPerMonth == null) && (other.allItemsPerMonth != null)
                || (allItemsPerMonth != null) && (other.allItemsPerMonth == null))
                && (!allItemsPerMonth.equals(other.allItemsPerMonth))) {
            return false;
        }
        if (((creationDate == null) && (other.creationDate != null)
                || (creationDate != null) && (other.creationDate == null))
                && (!creationDate.equals(other.creationDate))) {
            return false;
        }
        if (((unTakenItems == null) && (other.unTakenItems != null)
                || (unTakenItems != null) && (other.unTakenItems == null))
                && (!unTakenItems.equals(other.unTakenItems))) {
            return false;
        }
        return true;
    }

    public static UserHabitStatistic converToUserHabitStatistic(UserHabitStatisticEntity statisticEntity) {

        UserHabitStatistic statistic = new UserHabitStatistic(statisticEntity.getCreateDate());

        statisticEntity.getAllItemsPerMonth()
            .forEach(item -> statistic.addItemPerMonth(item.getHabitItemAmount() , item.getHabitItemName()));

        statisticEntity.getDifferenceUnTakenItemsWithPreviousDay()
            .forEach(item -> statistic.addUnTakenItem(item.getHabitItemAmount() , item.getHabitItemName()));

        return statistic;

    }


    class Items implements Comparable<Items>{
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
        public int compareTo(Items items) {
            return getHabitItemName().compareTo(items.getHabitItemName()) == 0
                    ? Integer.compare(getHabitItemAmount(), items.getHabitItemAmount())
                    : getHabitItemName().compareTo(items.getHabitItemName());
        }

        @Override
        public String toString() {
            return "Items [habitItemAmount=" + habitItemAmount
                    + ", habitItemName=" + habitItemName + "]";
        }

    }
}