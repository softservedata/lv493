package com.softserve.edu.taqs;

import java.util.ArrayList;
import java.util.List;

import static com.softserve.edu.taqs.Helper.gcd;

public class Task323 {

    /**
     * @param n - natural input number
     * @return list on numbers which are less than n and are relatively simple with n
     */
    public List<Integer> getSimple(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(gcd(i, n) == 1)
                list.add(i);
        }
        return list;
    }
}
