package com.gmail.okstrishch;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class testLagrange {

  
/**
 *  Test1 131 -->11^2+3^2+1^2+0^2.
 */
    @Test
        public void Test1() {
        assertEquals(Arrays.toString(new Lagrange().decompose(131)), Arrays.toString(new int[] { 11, 3, 1, 0 }));
        }
    /**
     *  Test2 10 -->3^2+1^2+0^2+0^2.
     */
    @Test
        public void Test2() {
        assertEquals(Arrays.toString(new Lagrange().decompose(10)), Arrays.toString(new int[] { 3, 1, 0, 0 }));
        }
    /**
     *  Test3 6 -->2^2+1^2+1^2+0^2.
     */
    @Test
        public void Test3() {
        assertEquals(Arrays.toString(new Lagrange().decompose(6)), Arrays.toString(new int[] { 2, 1, 1, 0 }));
        }
    /**
     *  Test4 239 -->15^2+3^2+2^2+1^2.
     */
    @Test
        public void Test4() {
        assertEquals(Arrays.toString(new Lagrange().decompose(239)), Arrays.toString(new int[] { 15, 3, 2, 1 }));
        }
    /**
     *  Test5 16 -->4^2+0^2+0^2+0^2.
     */
    @Test
        public void Test5() {
        assertEquals(Arrays.toString(new Lagrange().decompose(16)), Arrays.toString(new int[] { 4, 0, 0, 0 }));
        }
    }

