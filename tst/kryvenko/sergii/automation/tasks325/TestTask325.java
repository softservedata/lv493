/** The test solution of task N224.*/
package kryvenko.sergii.automation.tasks325;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestTask325 {

    /**
     * Positive testing finding prime divisors.
     * @throws NotNaturalNumberException
     */
    @Test
    void testFindDivisors1() throws NotNaturalNumberException {
        final int naturalNumber = 42;
        Divisor div = new Divisor(naturalNumber);
        int[] actual = div.findDivisors();
        final int[] expected = {2, 3, 7 };
        Assert.assertArrayEquals(expected, actual);
        for (int i = 0; i < actual.length; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }

    /**
     * Positive testing finding prime divisors.
     * @throws NotNaturalNumberException
     */
    @Test
    void testFindDivisors2() throws NotNaturalNumberException {
        final int naturalNumber = 23244;
        Divisor div = new Divisor(naturalNumber);
        int[] actual = div.findDivisors();
        final int[] expected = {2, 3, 13, 149 };
        Assert.assertArrayEquals(expected, actual);
        for (int i = 0; i < actual.length; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }

    /**
     * Positive testing a number 7 as a prime.
     * @throws NotNaturalNumberException
     */
    @Test
    void testIsPrimeNumber1() throws NotNaturalNumberException {
        final int truePrimeDivisor = 7;
        Divisor div = new Divisor(1);
        boolean actual = div.isPrimeNumber(truePrimeDivisor);
        Assert.assertTrue(actual);
    }

    /**
     * Negative testing a number 6 as a prime.
     * @throws NotNaturalNumberException
     */
    @Test
    void testIsPrimeNumber2() throws NotNaturalNumberException {
        final int falsePrimeDivisor = 6;
        Divisor div = new Divisor(1);
        boolean actual = div.isPrimeNumber(falsePrimeDivisor);
        Assert.assertFalse(actual);
    }

    /**
     * Positive testing parsing text "15" to an integer.
     * @throws NotNaturalNumberException
     */
    @Test
    void testParseText() {
        final int actual = new ParseText().toInteger("15");
        final int expected = 15;
        Assert.assertEquals(expected, actual);
    }

}
