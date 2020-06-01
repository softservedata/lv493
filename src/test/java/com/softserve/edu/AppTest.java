package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void checkApp() {
        System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
        System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
        Assert.assertTrue(true);
    }
}
