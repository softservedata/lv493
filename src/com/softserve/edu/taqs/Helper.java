package com.softserve.edu.taqs;

import java.util.ArrayList;
import java.util.List;

/**
 * Help methods class
 */
public class Helper {

    /**
     * The divider for getting last num in number
     */
    public static final int TEN = 10;

    /**
     * @param n - natural number
     * @return list of nums in number n
     */
    static public List<Integer> getDividers(int n) {
        List<Integer> dividers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                dividers.add(i);
            }
        }
        return dividers;
    }

    /**
     * @param a - first number
     * @param b - second number
     * @return Greatest common divider of number a and b
     */
    static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    /**
     * @param n - natural number
     * @return list of nums in number n
     */
    public static ArrayList<Integer> getNums(int n) {
        ArrayList<Integer> nums = new ArrayList<>();

        while (n > 0) {
            int last = n % TEN;

            n -= last;
            n /= TEN;

            nums.add(last);
        }
        return nums;
    }
}
