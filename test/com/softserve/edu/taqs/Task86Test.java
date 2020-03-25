package com.softserve.edu.taqs;

import org.junit.jupiter.api.*;

public class Task86Test {
    @Test
    void createFirstTask86Test() {
        Task86 r = new FirstTask86();
        Assertions.assertNotNull(r);
    }

    @Test
    void createSecondTask86Test() {
        Task86 r = new FirstTask86();
        Assertions.assertNotNull(r);
    }

    @Test
    void sameCountTest() {
        Task86 r1 = new FirstTask86();
        Task86 r2 = new SecondTask86();

        Assertions.assertEquals(r1.countNums(10), r2.countNums(10));

    }

    @Test
    void sameSumTest() {
        Task86 r1 = new FirstTask86();
        Task86 r2 = new SecondTask86();

        Assertions.assertEquals(r1.sumNums(10), r2.sumNums(10));
    }

    @Test
    void correctFirstSumTest() {
        Task86 r = new FirstTask86();
        Assertions.assertEquals(r.sumNums(1230), 6);
    }

    @Test
    void correctSecondSumTest() {
        Task86 r = new SecondTask86();
        Assertions.assertEquals(r.sumNums(1230), 6);
    }


    @Test
    void correctFirstCountTest() {
        Task86 r = new FirstTask86();
        Assertions.assertEquals(r.countNums(1230), 4);
    }


    @Test
    void correctSecondCountTest() {
        Task86 r = new FirstTask86();
        Assertions.assertEquals(r.countNums(1230), 4);
    }

}
