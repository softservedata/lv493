package com.softserve.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondNg {
	private boolean isTestSuccessful = false;

//	@BeforeSuite
//	public void beforeSuite() {
//		System.out.println("@BeforeSuite class SecondNg beforeSuite()");
//	}

//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("@AfterSuite class SecondNg afterSuite()");
//	}

//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("\t@BeforeTest class SecondNg beforeTest()");
//	}

//	@AfterTest
//	public void afterTest() {
//		System.out.println("\t@AfterTest class SecondNg afterTest()");
//	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("\t\t@BeforeClass class SecondNg beforeClass()");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("\t\t@AfterClass class SecondNg afterClass()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\t@BeforeMethod class SecondNg beforeMethod()");
		isTestSuccessful = false;
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\t\t\t@AfterMethod class SecondNg afterMethod()");
		//throw new RuntimeException("@AfterMethod afterMethod()");
		if (!isTestSuccessful) {
			System.out.println("***test failed");
		}
	}

	@Test//(alwaysRun = true)
	public void three() {
		System.out.println("\t\t\t\t@Test class SecondNg three()");
		isTestSuccessful = true;
	}

	@Test//(alwaysRun = true)
	public void four() {
		System.out.println("\t\t\t\t@Test class SecondNg four()");
		//throw new RuntimeException("@Test four()");
		//isTestSuccessful = true;
	}

}
