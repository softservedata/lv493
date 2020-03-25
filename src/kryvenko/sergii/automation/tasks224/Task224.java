/** The solution of task N224.*/
package kryvenko.sergii.automation.tasks224;

import java.util.List;

/**
 * Task N224. Get all natural divisors of natural number n.
 */
public final class Task224 {

    /** Default constructor. */
    private Task224() {
    }

    /**
     * Main method.
     * @param args Command line Arguments.
     */
    public static void main(final String[] args) {

        System.out.println("Exercise N224");

        System.out.print("Enter natural number n ");
        int naturalNumber = new ReadFromConsle().readNumber();
        IntDivisors divisor = new Divisors();
        List<Integer> arrayDivisors = divisor.findDivisors(naturalNumber);
        new Print().printDivisors(naturalNumber, arrayDivisors);

    }
}
