package com.softserve.edu.taqs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Task323Test {

    Task323 t;

    @BeforeEach
    void setUp() {
        t = new Task323();
    }

    @Test
    void getSimpleTest() {
        List<Integer> actual = t.getSimple(10);
        List<Integer> expected = Arrays.asList(1, 3, 7, 9);

        Assertions.assertIterableEquals(expected, actual);
        Assertions.assertEquals(expected, actual);
    }

}
