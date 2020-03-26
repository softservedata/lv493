package com.gmail.okstrishch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Exercise88Test {
  /**
   * test1 321 --> 1321.
   */
    @Test
    public void test1() {
        assertEquals("321 ", 13211, Exercise88.addNumberTo(321));
    }
    /**
     * test2 23 --> 1231.
     */
    @Test
    public void test2(){
        assertEquals("23 ", 1231, Exercise88.addNumberTo(23));
    }
    /**
     *  test3 10 -->1101.
     */
    @Test
    public void test3(){
        assertEquals("10 ", 1101, Exercise88.addNumberTo(10));
    }


}
