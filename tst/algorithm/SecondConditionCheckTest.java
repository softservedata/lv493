package algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import algorithm.ConditionCheck;

/**
 * Class with test methods of ConditionCheck class that check condition: element
 * less than factorial of sequence number and more than 2^sequence number.
 */
public class SecondConditionCheckTest {

    /**
     * Test method execution with array that contains elements that match
     * condition.
     */
    @Test
    public void testPositivePath() {
        List<Integer> list = Arrays.asList(1, 7, 2, 18, 40);
        ConditionCheck condCheck = new ConditionCheck(list);
        int expectedCount = 2;
        int actualCount = condCheck.findNumbersCountBetweenConditions();
        assertEquals(expectedCount, actualCount);
    }

    /**
     * Test method with array that doesn't contain elements that match
     * condition.
     */
    @Test
    public void testWithoutRightValues() {
        List<Integer> list = Arrays.asList(-11, 7);
        ConditionCheck condCheck = new ConditionCheck(list);
        int expectedCount = 0;
        int actualCount = condCheck.findNumbersCountBetweenConditions();
        assertEquals(expectedCount, actualCount);
    }

    /**
     * Test negative scenario that means finding elements that match condition
     * in empty array.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePathWithEmptyArray() {
        List<Integer> list = Arrays.asList();
        ConditionCheck condCheck = new ConditionCheck(list);
        condCheck.findNumbersCountBetweenConditions();
    }
    /**
     * Test negative scenario with null value as array.
     */
    @Test(expected = NullPointerException.class)
    public void testNegativePathWithNull() {
        ConditionCheck condCheck = new ConditionCheck(null);
    }

}
