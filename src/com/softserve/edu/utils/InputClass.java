/**
 * package for utilities classes.
 */
package com.softserve.edu.utils;

import java.util.Scanner;

/**
 * @author mJana
 *
 */
public final class InputClass {

    /**
     * Scanner object is used for input from Console.
     */
    private static Scanner sc = new Scanner(System.in);

    private InputClass() {

    }

    /**
     * @return integer value.
     */
    public static int getInt() {
        int result = 0;
        String input;
        input = sc.next();
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            System.err.println("Error. Wrong input!");
        }
        return result;
    }

    /**
     * Scanner closing.
     */
    public static void close() {
        sc.close();
    }
}
