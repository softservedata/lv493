/*
 * Task1 - 88 в) Переставить первую и последнюю цифры числа n.
 */
package com.gmail.okstrishch;

import java.util.Scanner;

/**
 * Class about solution task 88b.
 */
final class Exercise {
    /**
     * Default constructor.
     */
    private Exercise() {
    }
    /**
     * @param number
     *            user added number.
     * @return issues change first with last digit place.
     */
   static int changeDigits(int number) {
        String text = String.valueOf(number);
        text = text.substring(text.length() - 1)
                + text.substring(1, text.length() - 1) + text.substring(0, 1);
       number = Integer.parseInt(text);
        return number;

    }

    static int scanConsole() {
        Scanner enter = new Scanner(System.in);
        System.out.println("Entere number, please: ");
        int num =  enter.nextInt();
        enter.close();
        return num;
    }

    /**
     * @param args
     *            Command line Arguments.
     */

    public static void main(final String[] args) {
        System.out.println(changeDigits(scanConsole()));
    }
}
