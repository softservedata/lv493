package algorithm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithm.PascalTriangle;


/**
 * Class with test methods of PascalTriangle class.
 */
public class PascalTriangleTest {
    /**
     * Array that contains expected elements.
     */
    private static int[][] pascalArray;

    /**
     * Variable that define rows count in arrays.
     */
    private static final int ROWS_COUNT = 4;

    /**
     * Fill expected array with appropriate values.
     */
    @BeforeClass
    public static void setUp() {
        pascalArray = new int[ROWS_COUNT][];
        for (int j = 0; j < ROWS_COUNT; j++) {
            pascalArray[j] = new int[j + 1];
            pascalArray[j][0] = 1;
            for (int i = 1; i < j; i++) {
                pascalArray[j][i] = pascalArray[j - 1][i - 1]
                        + pascalArray[j - 1][i];
            }
            pascalArray[j][j] = 1;
        }
    }

    /**
     * Test positive scenario that means method execution with proper rows count
     * value.
     */
    @Test
    public void testPositivePath() {
        PascalTriangle triangle = new PascalTriangle();
        int[][] actual = triangle.calculateTriangle(ROWS_COUNT);

        Assert.assertArrayEquals(pascalArray, actual);
    }

    /**
     * Test negative scenario that means entering negative rows count.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePath() {
        PascalTriangle triangle = new PascalTriangle();
        triangle.calculateTriangle(0);
    }


}











