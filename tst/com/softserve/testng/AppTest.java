package com.softserve.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AppTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("class AppTest, @BeforeSuite beforeSuite()");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("class AppTest, @AfterSuite afterSuite()");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\tclass AppTest, @BeforeTest beforeTest()");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\tclass AppTest, @AfterTest afterTest()");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\t\tclass AppTest, @BeforeClass beforeClass()");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\t\tclass AppTest, @AfterClass afterClass()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\tclass AppTest, @BeforeMethod beforeMethod()");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\t\t\tclass AppTest, @AfterMethod afterMethod()");
	}

	@Test
	public void check1() {
		System.out.println("\t\t\t\tclass AppTest, @Test check1()");
	}

	@Test
	public void check2() {
		System.out.println("\t\t\t\tclass AppTest, @Test check2()");
	}

}
