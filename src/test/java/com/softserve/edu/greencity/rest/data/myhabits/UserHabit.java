package com.softserve.edu.greencity.rest.data.myhabits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.myhabits.UserHabitEntity;

public class UserHabit  implements Comparable<UserHabit>{
    private String name;

    public UserHabit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(UserHabit userHabit) {
        return getName().compareTo(userHabit.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        UserHabit other = (UserHabit) obj;
        if (((name == null) && (other.name != null)
                || (name != null) && (other.name == null))
                && (!name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserHabit [name=" + name + "]";
    }

    // static factory

    public static UserHabit converToUserHabit(UserHabitEntity userHabitEntity) {
        return new UserHabit(userHabitEntity.getName());
    }

    public static List<UserHabit> converToUserHabitList(List<UserHabitEntity> userHabitsEntities) {
        List<UserHabit> result = new ArrayList<>();
        for (UserHabitEntity userHabitEntity : userHabitsEntities) {
            result.add(converToUserHabit(userHabitEntity));
        }
        Collections.sort(result);
        return result;
    }
}
