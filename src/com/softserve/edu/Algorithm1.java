/*
 * My first Programming task
 */
package com.softserve.edu;

/**
 * @author mJana
 * @version 1.0 09 March 2020 Class Algorithm1 for task: Check if numeric n^2
 *          contains number "3"
 */
public class Algorithm1 {

    /**
     * @param number - user input
     * @return boolean result = true if number^2 contains number "3"
     */
    public final boolean solve(final int number) {
        boolean result = false;
        if (number < Math.sqrt(Integer.MAX_VALUE)) {
            int sqr = number * number;
            String stringForChecking = Integer.toString(sqr);
            result = stringForChecking.contains("3");
        } else {
            System.out.println("Can't check. Number " + number + " is too big.");
        }
        return result;
    }
}
