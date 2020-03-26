package com.softserve.edu.test;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.Algorithm3;

/**
 * @author mJana
 *
 */
public class Algorithm3Test {

    /**
     * Positive test with input = 50.
     */
    @Test
    public void test1() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 48;
        int actual = systemUnderTest.checkMaxSum(50);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with input = 500.
     */
    @Test
    public void test2() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 480;
        int actual = systemUnderTest.checkMaxSum(500);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with input = 4500.
     */
    @Test
    public void test3() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 4320;
        int actual = systemUnderTest.checkMaxSum(4500);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with input = 10000.
     */
    @Test
    public void test4() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 9240;
        int actual = systemUnderTest.checkMaxSum(10000);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with input = 1.
     */
    @Test
    public void test5() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 1;
        int actual = systemUnderTest.checkMaxSum(1);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Negative test with input = -10000.
     */
    @Test
    public void test6() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 0;
        int actual = systemUnderTest.checkMaxSum(-10000);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Negative test with input = -2147483648.
     */
    @Test
    public void test7() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 0;
        int actual = systemUnderTest.checkMaxSum(-2147483648);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Negative test with input = 0.
     */
    @Test
    public void test8() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 0;
        int actual = systemUnderTest.checkMaxSum(0);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Positive test with input = 2147483647.
     */
    @Test
    public void test9() {
        Algorithm3 systemUnderTest = new Algorithm3();
        int expected = 9240;
        int actual = systemUnderTest.checkMaxSum(2147483647);
        Assert.assertEquals(expected, actual);
    }
}
