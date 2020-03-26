package com.gmail.okstrishch;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.*;
import org.junit.Test;

public class ExerciseTest {
/**
 * testchageDigit 321-->123.
 */
    @Test
    public void testchangeDigit() {
       assertEquals("321", 123, Exercise.changeDigits(321));
    }
    /**
     * testchangeDigit1 128-->821.
     */
    @Test
    public void testchangeDigit1() {
       assertEquals("128", 821, Exercise.changeDigits(128));
    }
    /**
     * testChangeDigit4569  4569-->4569.
     */
    @Test
    public void testChangeDigit4569() {
        assertEquals("4569", 9564, Exercise.changeDigits(4569));
    }
    /**
     * testChangeDigit999  999 == 999.
     */
    @Test
    public void testChangeDigit999() {
        assertEquals("999", 999, Exercise.changeDigits(999));
    }
    /**
     * testChangeDigit999  10 == 01.
     */
    @Test
    public void testChangeDigit10() {
        assertEquals("10", 01, Exercise.changeDigits(10));
    }
}
