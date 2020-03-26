/*
 * My first Programming task
 */
package com.softserve.edu;

/**
 * @author mJana
 * @version 1.1 15 March 2020 Class Algorithm2. Task: reverse order of number
 */
public class Algorithm2 {
    /**
     *
     * Number 10 is used to divide the input number into digits.
     */
    private final int ten = 10;

    /**
     * @param num
     * @return reverse
     */
    public final int getReverse(final int num) {
        int reverse = 0;
        int number = num;
        int remainder = 0;
        while (number != 0) {
            remainder = number % ten;
            reverse = reverse * ten + remainder;
            number = number / ten;
        }
        return reverse;
    }
}
