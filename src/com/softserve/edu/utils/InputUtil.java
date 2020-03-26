package com.softserve.edu.utils;

import java.util.Scanner;

/**
 * @version 1.0 Input utility class for getting user's input from Console.
 */
public final class InputUtil {

    /**
     * only one instance of an Input object can exist.
     */
    private static InputUtil singleInput = null;

    /**
     * single object for getting input.
     */
    private static Scanner scanner;

    private InputUtil() {
        scanner = new Scanner(System.in);
    }

    /**
     * @return singleInput - instance of single Input object if no Input object
     *         exists one will be created; if one already exists, it will be
     *         re-used.
     */
    public static InputUtil getInstance() {
        if (singleInput == null) {
            singleInput = new InputUtil();
        }
        return singleInput;
    }

    /**
     * @return scanner.nextInt().
     */
    public int getInt() {
        // System.out.print("Please, enter integer value");
        while (!scanner.hasNextInt()) {
            System.out.println("Number is required input.");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    /**
     * @return stringInput.
     */
    public String getString() {
        // System.out.print("Please, enter String value");
        scanner.useDelimiter("\r\n");
        String stringInput = scanner.next();
        scanner.reset();
        return stringInput;
    }

    /**
     * @return scanner.nextBoolean().
     */
    public boolean getBoolean() {
        // System.out.print("Please, enter true or false");
        return scanner.nextBoolean();
    }

    /**
     * Scanner closing, Input object = null.
     */
    public static void close() {
        if (singleInput != null) {
            scanner.close();
            singleInput = null;
            System.out.println("Scanner is closed");
        } else {
            System.out.println("Scanner is already closed");
        }
    }
}
