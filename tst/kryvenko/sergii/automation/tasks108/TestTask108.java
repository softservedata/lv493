/** The test solution of task N108.*/
package kryvenko.sergii.automation.tasks108;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Test for Task N108.
 */
class TestTask108 {

    /**
     * Positive testing the exponentiation method (2^5).
     */
    @Test
    void testExponentiation1() {
        final int degree = 5;
        int actuals = new Involution(0).exponentiation(degree);
        final int expecteds = 32; // 2 raised to the power of 5 = 32
        Assert.assertEquals(expecteds, actuals);
    }

    /**
     * Negative testing the exponentiation method (2^7).
     */
    @Test
    void testExponentiation2() {
        final int degree = 7; // 2 raised to the power of 7 = 128
        int actuals = new Involution(0).exponentiation(degree);
        final int expecteds = 64; // 2 raised to the power of 6 = 64
        Assert.assertNotEquals(expecteds, actuals);
    }

    /**
     * Positive testing solution (2^5 > 16).
     */
    @Test
    void testNumberR() {
        final int naturalNumber = 16;
        int actuals = new Involution(naturalNumber).numberR();
        final int expecteds = 5; // 2 raised to the power of 5 = 32
        Assert.assertEquals(expecteds, actuals);
    }

    /**
     * Negative testing solution (2^6 > 100).
     */
    @Test
    void testNumberR2() {
        final int naturalNumber = 100;
        int actuals = new Involution(naturalNumber).numberR();
        final int expecteds = 6; // 2 raised to the power of 6 = 64
        Assert.assertNotEquals(expecteds, actuals);
    }

}
