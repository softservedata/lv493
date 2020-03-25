package com.softserve.edu.taqs;

import java.util.HashMap;

import static com.softserve.edu.taqs.Helper.getDividers;

public class Task560 {

    /**
     * @param a - first number
     * @param b - second number
     * @return true if numbers a and b are friendly and false if they aren't
     */
    private boolean isFriendly(int a, int b) {
        return (getDividers(a).stream().mapToInt(Integer::intValue).sum() == b)
                && (getDividers(b).stream().mapToInt(Integer::intValue).sum() == a);
    }

    /**
     * @param from - low limit
     * @param to - high limit
     * @return all pairs of numbers which are friendly
     */
    public HashMap<Integer, Integer> getFriendNumbers(int from, int to) {

        HashMap<Integer, Integer> list = new HashMap<>();

        for (int i = from; i <= to; i++){
            for (int j = from; j <= i; j++) {
                if (isFriendly(i, j)) {
                    list.put(i, j);
                }
            }
        }
        return list;
    }
}