package com.softserve.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest2 {

	@BeforeSuite
	public void beforeSuite1() {
		System.out.println("class TestNGTest2, @BeforeSuite beforeSuite1()");
	}

	@BeforeSuite
	public void beforeSuite2() {
		System.out.println("class TestNGTest2, @BeforeSuite beforeSuite2()");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\tclass TestNGTest2, @BeforeTest beforeTest()");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\tclass TestNGTest2, @AfterTest afterTest()");
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void divisionWithException() {
		int i = 1 / 0;
	}

	@Test(enabled = false)
	public void disableTest() {
		System.out.println("Method is not ready yet");
	}

}
