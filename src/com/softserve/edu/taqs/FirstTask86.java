package com.softserve.edu.taqs;

import java.util.ArrayList;
import java.util.HashSet;

import static com.softserve.edu.taqs.Helper.getNums;

/**
 * Realization of Task 86 without using String
 */
public class FirstTask86 implements Task86 {

    @Override
    public int countNums(int n) {
        return getNums(n).size();
    }

    @Override
    public int sumNums(int n) {
        return getNums(n).stream().mapToInt(Integer::intValue).sum();
    }
}
