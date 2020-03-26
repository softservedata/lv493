package com.gmail.okstrishch;

import java.util.Arrays;
/**
 * @author Oksana
 * Task Lagrange sum 4 square.
 */
public class Lagrange {
    /**
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(new Lagrange().decompose(16)));

    }
    /**
     * @param number
     * @return
     */
    public int[] decompose(int number) {
        Helper h = new Helper();
        h.decompose(number, 4);
        return h.result;
    }
    /**
     * Class Helper.
     */
    private static class Helper {
        int[] result;
        final int MAX = 4;
        Helper() {
            result = new int[MAX];
        }
        /**
         * @param number digit which divide by number into squares.
         * @param terms
         * @return
         */
        boolean decompose(int number, int terms) {
            if ((number == 0) && (terms == 0)) {
                return true;
            }
            if (terms == 0) {
                return false;
            }
            for (int i = 0; i * i <= number; i++) {
                result[terms - 1] = i;
                if (decompose(number - i * i, terms - 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
