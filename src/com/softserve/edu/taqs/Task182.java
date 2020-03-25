package com.softserve.edu.taqs;


public class Task182 {

    /**
     * @param a number for checking the following condition
     * @return true if number divides into 5 and does't divide into 7, otherwise return false
     */
    private boolean divideFilter(int a) {
        return (a % 5 == 0) && (a % 7 != 0);
    }

    /**
     * @param n - count of a params
     * @param a - list of numbers
     * @return sum of elements of a which divide into 5 and don't divide into 7
     */
    public int elementsSum(int n, int ... a) {
        int sum = 0;
        for(int i: a) {
            if (divideFilter(i)) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     *
     * @param n - count of a params
     * @param a - list of numbers
     * @return amount of elements of a which divide into 5 and don't divide into 7
     */
    public int elementsCount(int n, int ... a) {
        int count = 0;
        for(int i: a) {
            if (divideFilter(i)) {
                count ++;
            }
        }
        return count;
    }
}
