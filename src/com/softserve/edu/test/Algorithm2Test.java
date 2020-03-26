/**
 *
 */
package com.softserve.edu.test;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.Algorithm2;

/**
 * @author mJana
 *
 */
public class Algorithm2Test {

    /**
     * Positive test with valid input = 5.
     */
    @Test
    public void test1() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 5;
        int actual = systemUnderTest.getReverse(5);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with valid input = 48.
     */
    @Test
    public void test2() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 84;
        int actual = systemUnderTest.getReverse(48);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with valid input = 497.
     */
    @Test
    public void test3() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 794;
        int actual = systemUnderTest.getReverse(497);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with valid input = 123456.
     */
    @Test
    public void test4() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 654321;
        int actual = systemUnderTest.getReverse(123456);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with input value = 1.
     */
    @Test
    public void test5() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 1;
        int actual = systemUnderTest.getReverse(1);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with input value = 2147483647.
     */
    @Test
    public void test6() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 0;
        int actual = systemUnderTest.getReverse(2147483647);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Negative test with input = -12365.
     */
    @Test
    public void test7() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = -56321;
        int actual = systemUnderTest.getReverse(-12365);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Negative test with input = -2147483648.
     */
    @Test
    public void test8() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 0;
        int actual = systemUnderTest.getReverse(-2147483648);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Negative test with input value = 0.
     */
    @Test
    public void test9() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 0;
        int actual = systemUnderTest.getReverse(0);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test with input value = 012345.
     */
    @Test
    public void test10() {
        Algorithm2 systemUnderTest = new Algorithm2();
        int expected = 54321;
        int actual = systemUnderTest.getReverse(012345);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}
