package com.softserve.edu.taqs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Task560Test {
    Task560 t;

    @BeforeEach
    void setUp() {
        t = new Task560();
    }


    @Test
    void getFriendlyNumberTest() {
        HashMap<Integer, Integer> actual = t.getFriendNumbers(1, 10);
        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(6, 6);

        Assertions.assertEquals(expected, actual);
    }
}
