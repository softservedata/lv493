package com.softserve.edu.greencity.rest.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.rest.services.GuestService;

public abstract class GreencityRestTestRunner {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@BeforeSuite
//	public void beforeSuite() {
//	}
//
//	@BeforeClass
//	public void setUpBeforeClass() {
//	}
//
//	@AfterClass(alwaysRun = true)
//	public void tearDownAfterClass() throws Exception {
//		// TODO Logout
//	}
//
//	@BeforeMethod
//	public void setUp() throws Exception {
//	}

//	@AfterMethod(description = "Check result of test executing")
//	public void tearDown(ITestResult result) throws Exception {
//		if (!result.isSuccess()) {
//			logger.warn("Error Test " + result.getName());
//			// TODO Logout
//		}
//		logger.info("Done Test " + result.getName());
//		// logout, delete cookie, delete cache
//	}
//
	public GuestService loadApplication() {
		return new GuestService();
	}

}
