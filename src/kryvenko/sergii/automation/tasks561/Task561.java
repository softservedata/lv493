/**
 * The solution of task N561.
 */
package kryvenko.sergii.automation.tasks561;

/**
 * Task N561. Find all numbers from 1 to n (natural number) where last symbol
 * square of the number equals the last symbol this number.
 */
public final class Task561 {

    /** Natural number. */
    private static final int N = 10;

    /** Default constructor. */
    private Task561() {
    }

    /**
     * Main method.
     * @param args Command line Arguments.
     */
    public static void main(final String[] args) {

        System.out.println("Task N561");
        int[] numbers1 = new FindNumbers(N).numberCheck();
        new Print(N).numbers(numbers1);

    }

}
