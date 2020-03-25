package com.softserve.edu.taqs;

/**
 * Realization of Task 86 with using String
 */
public class SecondTask86 implements Task86 {

    @Override
    public int countNums(int n) {
        String num = Integer.toString(n);
        return num.length();
    }

    @Override
    public int sumNums(int n) {
        char[] num = Integer.toString(n).toCharArray();
        int sum = 0;
        for (char i: num) {
            sum += i - '0';
        }
        return sum;
    }
}
