package algorithm;

/**
 * Class designed to show particular number of rows of Pascal triangle.
 */
public final class PascalTriangle {

    /**
     * Calculate value of rows of Pascal triangle according to entered number of
     * rows.
     *
     * @param rowCount - count of rows that must be calculate
     * @return array of elements
     */
    public int[][] calculateTriangle(final int rowCount) {

        if (rowCount <= 0) {
            throw new IllegalArgumentException();
        }

        int[][] array = new int[rowCount][];

        for (int j = 0; j < rowCount; j++) {
            array[j] = new int[j + 1];
            array[j][0] = 1;
            for (int i = 1; i < j; i++) {
                array[j][i] = array[j - 1][i - 1] + array[j - 1][i];
            }
            array[j][j] = 1;
        }
        return array;
    }

}
