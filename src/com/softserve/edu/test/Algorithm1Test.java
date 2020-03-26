/**
 *
 *
 */
package com.softserve.edu.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.Algorithm1;

/**
 * @author mJana
 *
 */
public class Algorithm1Test {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Positive test with input = 3. Expected result false.
     */
    @Test
    public void test1() {
        int input = 3;
        Algorithm1 systemUnderTest = new Algorithm1();
        boolean actual = systemUnderTest.solve(input);
        Assert.assertFalse("Wrong result", actual);
    }

    /**
     * Negative test with input = 0. Expected result false.
     */
    @Test
    public void test2() {
        Algorithm1 systemUnderTest = new Algorithm1();
        boolean actual = systemUnderTest.solve(0);
        Assert.assertFalse("Wrong result", actual);
    }

    /**
     * Positive test with input = 12365. Expected result true.
     */
    @Test
    public void test3() {
        Algorithm1 systemUnderTest = new Algorithm1();
        boolean actual = systemUnderTest.solve(12365);
        Assert.assertTrue("Wrong result", actual);
    }

    /**
     * Negative test with input = 234567. Expected result false.
     */
    @Test
    public void test4() {
        Algorithm1 systemUnderTest = new Algorithm1();
        boolean actual = systemUnderTest.solve(234567);
        Assert.assertFalse("Wrong result", actual);
    }

    /**
     * Negative test with input = -46340. Expected result true.
     */
    @Test
    public void test5() {
        Algorithm1 systemUnderTest = new Algorithm1();
        boolean actual = systemUnderTest.solve(-46340);
        Assert.assertTrue("Wrong result", actual);
    }

    /**
     * Positive test with input = 46340. Expected result true.
     */
    @Test
    public void test6() {
        Algorithm1 systemUnderTest = new Algorithm1();
        boolean actual = systemUnderTest.solve(46340);
        Assert.assertTrue("Wrong result", actual);
    }

    /**
     * Negative test with input = -46341. Expected result false.
     */
    @Test
    public void test7() {
        Algorithm1 systemUnderTest = new Algorithm1();
        boolean actual = systemUnderTest.solve(-46341);
        Assert.assertFalse("Wrong result", actual);
    }

    /**
     * Negative test with input = 46341. Expected result false.
     */
    @Test
    public void test8() {
        Algorithm1 systemUnderTest = new Algorithm1();
        boolean actual = systemUnderTest.solve(46341);
        Assert.assertFalse("Wrong result", actual);
    }
}
