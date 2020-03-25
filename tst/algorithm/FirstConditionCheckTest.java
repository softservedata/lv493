package algorithm;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import algorithm.ConditionCheck;

/**
 * Class with test methods of ConditionCheck class that check condition:
 * element less than previous element added next one and divided by 2.
 */
public class FirstConditionCheckTest {

    /**
     * Test method execution with array that contains elements that match
     * condition.
     */
    @Test
    public void testPositivePath() {
        List<Integer> list = Arrays.asList(1, 3, 8, 0, 1);
        ConditionCheck condCheck = new ConditionCheck(list);
        int expectedCount = 2;
        int actualCount = condCheck.findNumbersCountLessThanCondition();
        Assert.assertEquals(expectedCount, actualCount);
    }

    /**
     * Test method with array that doesn't contain elements that match
     * condition.
     */
    @Test
    public void testWithoutRightValues() {
        List<Integer> list = Arrays.asList(1, 3);
        ConditionCheck condCheck = new ConditionCheck();
        condCheck.setNumbers(list);
        int expectedCount = 0;
        int actualCount = condCheck.findNumbersCountLessThanCondition();
        Assert.assertEquals(expectedCount, actualCount);
    }

    /**
     * Test negative scenario that means finding elements that match condition
     * in empty array.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePathWithEmptyArray() {
        List<Integer> list = Arrays.asList();
        ConditionCheck condCheck = new ConditionCheck(list);
        condCheck.findNumbersCountLessThanCondition();
    }
    /**
     * Test negative scenario with null value as array.
     */
    @Test(expected = NullPointerException.class)
    public void testNegativePathWithNull() {
        ConditionCheck condCheck = new ConditionCheck(null);
    }
}
