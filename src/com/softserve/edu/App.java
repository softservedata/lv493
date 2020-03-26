/*
 * My first Programming task
 */
package com.softserve.edu;

import com.softserve.edu.utils.InputUtil;

/**
 * @author mJana
 * @version 1.0 09 March 2020
 */
public final class App {
    /**
     * Default Constructor.
     */
    private App() {
    }

    /**
     * @param args Command line Arguments.
     */
    public static void main(final String[] args) {

        Algorithm1 algorithm1 = new Algorithm1();
        Algorithm2 algorithm2 = new Algorithm2();
        Algorithm3 algorithm3 = new Algorithm3();
        int result;
        boolean resBoolean;
        resBoolean = algorithm1.solve(InputUtil.getInstance().getInt());
        System.out.println("Algorithm1 result: " + resBoolean);
        result = algorithm2.getReverse(InputUtil.getInstance().getInt());
        System.out.println("Algorithm2 result1: " + result);
        result = algorithm2.getReverse(Integer.parseInt("0123456"));
        System.out.println("Algorithm2 result2: " + result);
        int range = InputUtil.getInstance().getInt();
        result = algorithm3.checkMaxSum(range);
        System.out.println("Algorithm3 result: " + result);
        InputUtil.close();

    }
}
