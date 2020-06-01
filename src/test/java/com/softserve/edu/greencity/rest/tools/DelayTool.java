package com.softserve.edu.greencity.rest.tools;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DelayTool {
    public static void wait(TimeUnit unit, int val) {
        long start = new Date().getTime();
        long delay = unit.toMillis(val);
        while(new Date().getTime() - start < delay){}
    }
}
