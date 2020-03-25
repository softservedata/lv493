/** The test solution of task N224.*/
package kryvenko.sergii.automation.tasks224;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Test for Task N224.
 */
class TestTask224 {

    /**
     * Positive testing finding divisors of natural number 25.
     */
    @Test
    void testFindDivisors1() {
        final int naturalNumber = 25;
        final int[] array = {1, 5, 25 };
        List<Integer> actual = new Divisors().findDivisors(naturalNumber);
        List<Integer> expected = new ArrayList<Integer>();
        for (int n : array) {
            expected.add(n);
        }
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

    /**
     * Negative testing finding divisors of natural number 2.
     */
    @Test
    void testFindDivisors2() {
        final int naturalNumber = 5;
        final int[] array = {2, 3, 4};
        List<Integer> actual = new Divisors().findDivisors(naturalNumber);
        List<Integer> expected = new ArrayList<Integer>();
        for (int n : array) {
            expected.add(n);
        }
        Assert.assertNotEquals(expected.size(), actual.size());
    }

}
