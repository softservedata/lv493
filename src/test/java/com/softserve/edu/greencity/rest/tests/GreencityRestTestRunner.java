package com.softserve.edu.greencity.rest.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.softserve.edu.greencity.rest.services.GuestService;

import io.qameta.allure.Step;

public abstract class GreencityRestTestRunner {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@BeforeSuite
	public void beforeSuite() {
	}

	@BeforeClass
	public void setUpBeforeClass() {
	}

	@AfterClass(alwaysRun = true)
	public void tearDownAfterClass() throws Exception {
		// TODO Logout
	}

	@BeforeMethod
	public void setUp() throws Exception {
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if (!result.isSuccess()) {
			logger.warn("Error Test " + result.getName());
			// TODO Logout
		}
		logger.info("Done Test " + result.getName());
		// logout, delete cookie, delete cache
	}
	
	@Step("Load_Application")
	public GuestService loadApplication() {
		return new GuestService();
	}
	
}
