package com.softserve.edu.taqs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task330Test {

    Task330 t;

    @BeforeEach
    void setUp() {
        t = new Task330();
    }

    @Test
    void getIdealsTest() {
        List<Integer> actual = t.getIdeals(10);
        List<Integer> expected = Collections.singletonList(6);

        Assertions.assertIterableEquals(expected, actual);
    }
}
