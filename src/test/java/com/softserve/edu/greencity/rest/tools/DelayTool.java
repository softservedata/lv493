package com.softserve.edu.greencity.rest.tools;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DelayTool {
    public static void wait(TimeUnit unit,int waitTime) {
        long start = new Date().getTime();
        long delay = unit.toMillis(waitTime);
        while(new Date().getTime() - start < delay){}  // todo
    }

    public static void wait(TimeUnit unit, int waitTime, int maxWaitTime) throws TimeoutException {
        long start = new Date().getTime();
        long delay = unit.toMillis(waitTime);
        long maxDelay = unit.toMillis(maxWaitTime);
        while(new Date().getTime() - start < delay){
            if(new Date().getTime() - start < maxDelay) {
                throw new TimeoutException();
            }
        }

    }
}
