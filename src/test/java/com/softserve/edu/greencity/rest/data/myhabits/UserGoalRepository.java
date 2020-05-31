package com.softserve.edu.greencity.rest.data.myhabits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserGoalRepository {
    private static volatile UserGoalRepository instance = null;

    private UserGoalRepository() {
    }

    public static UserGoalRepository get() {
        if (instance == null) {
            synchronized (UserGoalRepository.class) {
                if (instance == null) {
                    instance = new UserGoalRepository();
                }
            }
        }
        return instance;
    }

    public UserGoal getDefault() {
        return buyComposter();
    }

    // TODO from exel
    public UserGoal buyComposter() {
        return new UserGoal("Buy composter", "ACTIVE");
    }

    public UserGoal sortingTrash() {
        return new UserGoal("Start sorting trash", "ACTIVE");
    }

    public UserGoal recyclingBatteries() {
        return new UserGoal("Start recycling batteries", "ACTIVE");
    }

    public UserGoal bookVegans() {
        return new UserGoal("Finish book about vegans", "ACTIVE");
    }

    public UserGoal buyBambooBrush() {
        return new UserGoal("Buy a bamboo brush", "ACTIVE");
    }

    public UserGoal buyComposterUK() {
        return new UserGoal("Купіть компостер", "ACTIVE");
    }

    public UserGoal sortingTrashUK() {
        return new UserGoal("Почніть сортувати сміття", "ACTIVE");
    }

    public UserGoal recyclingBatteriesUK() {
        return new UserGoal("Почніть переробляти батарейки", "ACTIVE");
    }

    public UserGoal bookVegansUK() {
        return new UserGoal("Прочитайте книгу про вегетаріанство", "ACTIVE");
    }

    public UserGoal buyBambooBrushUK() {
        return new UserGoal("Купіть бамбукову щітку", "ACTIVE");
    }

    public UserGoal sortingTrashDone() {
        return new UserGoal("Start sorting trash", "DONE");
    }

    public UserGoal sortingTrashDoneUK() {
        return new UserGoal("Почніть сортувати сміття", "DONE");
    }

    public UserGoal buyGroceryBags() {
        return new UserGoal("Buy grocery bags");
    }

    public UserGoal buyWaterBottle() {
        return new UserGoal("Buy water bottle");
    }

    public UserGoal buyNaturalFood() {
        return new UserGoal( "Buy natural food");
    }

    public UserGoal buyGrowNaturalFood() {
        return new UserGoal("Buy / grow natural food");
    }

    public UserGoal buyNaturalCleaningProducts() {
        return new UserGoal("Buy natural cleaning products");
    }

    public UserGoal bringPlants() {
        return new UserGoal("Bring plants into your home");
    }

    public List<UserGoal> selectedGoals() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyComposter());
        result.add(buyBambooBrush());
        result.add(buyNaturalFood());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> availableGoals() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyComposter());
        result.add(buyBambooBrush());
        result.add(bookVegans());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> availableGoalsUK() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyComposterUK());
        result.add(buyBambooBrushUK());
        result.add(bookVegansUK());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> typicalGoal() {
        List<UserGoal> result = new ArrayList<>();
        result.add(sortingTrash());
        result.add(recyclingBatteries());
        result.add(bringPlants());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> typicalGoalUK() {
        List<UserGoal> result = new ArrayList<>();
        result.add(sortingTrashUK());
        result.add(recyclingBatteriesUK());
        result.add(bringPlants());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> availableCustomGoals() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyNaturalFood());
        result.add(buyNaturalCleaningProducts());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> customGoals() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyNaturalFood());
        result.add(buyNaturalCleaningProducts());
        result.add(bringPlants());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> customGoalsForCreating() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyGroceryBags());
        result.add(buyWaterBottle());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> createdCustomGoals() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyGroceryBags());
        result.add(buyWaterBottle());
        //result.addAll(customGoals());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> customGoalsForAdding() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyNaturalFood());
        return result;
    }

    public List<UserGoal> updatedCustomGoals() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyGrowNaturalFood());
        Collections.sort(result);
        return result;
    }

    public List<UserGoal> customGoalsForUpdating() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyNaturalFood());
        return result;
    }

    public List<UserGoal> customGoalsForReUpdating() {
        List<UserGoal> result = new ArrayList<>();
        result.add(buyGrowNaturalFood());
        return result;
    }
}
