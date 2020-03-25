package kryvenko.sergii.automation.tasks561;

import org.junit.jupiter.api.Test;

import org.junit.Assert;

class FindNumbersTest {

    /**
     * Positive testing the exponentiation method (6^2).
     */
    @Test
    void testSquareNumber() {
        final int actual = new FindNumbers().squareNumber(6);
        final int excepted = 36;
        Assert.assertEquals(excepted, actual);
    }

    /**
     * Positive testing for finding the last symbol in number 574397.
     */
    @Test
    void testFindLastSymbolOfNumber() {
        final int actual = new FindNumbers().findLastSymbolOfNumber(574397);
        final int excepted = 7;
        Assert.assertEquals(excepted, actual);
    }

    /**
     * Positive testing for finding a solution for number 10.
     */
    @Test
    void testNumberCheck() {
        final int naturalNumber = 10;
        final int[] actual = new FindNumbers(naturalNumber).numberCheck();
        final int[] excepted = {1, 5, 6, 10 };
        Assert.assertArrayEquals(excepted, actual);

        int i = 0;
        for (int num : actual) {
            Assert.assertEquals(excepted[i], num);
            i++;
        }
    }

}
