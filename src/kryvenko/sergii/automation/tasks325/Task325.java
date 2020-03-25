/** The solution of task N325.*/
package kryvenko.sergii.automation.tasks325;

/**
 * Task N325. Get all prime divisors of natural number n. As example number
 * 42=2*3*7; 23244 includes 2, 3, 13, 149 prime numbers.
 */
public final class Task325 {

    /** Default constructor. */
    private Task325() {
    }

    /**
     * Main method.
     * @param args Command line Arguments.
     * @throws NotNaturalNumberException
     */
    public static void main(final String[] args)
            throws NotNaturalNumberException {

        System.out.println("Task N325");

        int[] array;
        Integer number = new GetNumber().fromConsole();

        array = new Divisor(number).findDivisors();
        new Print().arrayDivisors(array, number);
    }

}
