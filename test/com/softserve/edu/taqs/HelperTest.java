package com.softserve.edu.taqs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.softserve.edu.taqs.Helper.*;

public class HelperTest {

    @Test
    void getDividerTest() {
        List<Integer> actual = getDividers(10);
        List<Integer> expected = Arrays.asList(1, 2, 5);

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void gcdTest() {
        int actual = gcd(6, 8);
        int expect = 2;

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void getNumsTest() {
        List<Integer> actual = getNums(235);
        List<Integer> expected = Arrays.asList(5, 3, 2); // TODO sort

        Assertions.assertIterableEquals(expected, actual);
    }
}
