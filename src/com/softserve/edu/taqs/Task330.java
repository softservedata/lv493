package com.softserve.edu.taqs;

import java.util.ArrayList;
import java.util.List;

import static com.softserve.edu.taqs.Helper.getDividers;

public class Task330 {

    /**
     * @param n - natural number for checking the following conditional
     * @return true if number n is ideal, otherwise false
     */
    private boolean isIdeal(int n) {
        List<Integer> dividers = getDividers(n);
        int sum = dividers.stream().mapToInt(Integer::intValue).sum();
        return sum == n;
    }

    public List<Integer> getIdeals(int n) {
        List<Integer> ideals = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (isIdeal(i)) {
                ideals.add(i);
            }
        }
        return ideals;
    }
}
