package algorithm;

import reader.NumberReader;

/**
 * Class designed to demonstrate a work of PascalTriangle class.
 */
final class AppPascalTriangle {
    private AppPascalTriangle() {

    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        NumberReader reader = new NumberReader();

        System.out.println("Pascal triangle. \nEnter count of rows:");
        int rowCount = reader.read(System.in);
        PascalTriangle triangle = new PascalTriangle();
        int[][] pascalTriangleRows = triangle.calculateTriangle(rowCount);

        for (int i = 0; i < pascalTriangleRows.length; i++) {
            for (int j = 0; j < pascalTriangleRows[i].length; j++) {
                System.out.print(pascalTriangleRows[i][j] + " ");
            }
            System.out.println();
        }

    }
}
