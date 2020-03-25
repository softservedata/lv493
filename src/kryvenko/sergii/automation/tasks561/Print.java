/**
 * The solution of task N561.
 */
package kryvenko.sergii.automation.tasks561;

/**
 * Print result.
 */
public class Print {

    /**
     * Natural number.
     */
    private int naturalNumber;

    /**
     * Constructor.
     * @param num Natural number
     */
    public Print(final int num) {
        this.naturalNumber = num;
    }

    /**
     * Print incoming array.
     * @param array int[]
     */
    public void numbers(final int[] array) {
        int i = 1;
        for (int number : array) {
            if (number != 0) {
                System.out.printf(
                        "%s:\tNumber %s from 1 to %s where last symbol"
                        + " square of the number (%s) equals this number\n",
                        i, number, naturalNumber, new FindNumbers()
                                .squareNumber(number));
                i++;
            }
        }
    }

}
