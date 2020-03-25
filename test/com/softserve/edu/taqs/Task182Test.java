package com.softserve.edu.taqs;

import org.junit.jupiter.api.*;

public class Task182Test {
    Task182 t;
    int n = 10;
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    @BeforeEach
    void setUp() {
        t = new Task182();
    }

    @Test
    void countTest() {
        int actual = t.elementsCount(n, a);
        int expected = 2;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void sumTest() {
        int actual = t.elementsSum(n ,a);
        int expected = 15;
        Assertions.assertEquals(actual, expected);
    }
}
