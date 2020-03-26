/*
 * My first Programming task
 */
package com.softserve.edu;

/**
 * @author mJana
 * @version 1.0 09 March 2020
 *
 */
public final class Algorithm3 {

    /**
     * @param range - method checks all numbers in this range
     * @return number with max sum of divisors
     */
    public int checkMaxSum(final int range) {
        int sumResult = 0;
        int numResult = 0;
        for (int i = 1; i <= range; i++) {
            int sum = getDivisorsSum(i);
            if (sum > sumResult) {
                sumResult = sum;
                numResult = i;
            }
        }
        return numResult;
    }

    private int getDivisorsSum(final int i) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                sum = sum + j;
            }
        }
        return sum;
    }
}
