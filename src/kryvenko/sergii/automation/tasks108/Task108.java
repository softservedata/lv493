/** The solution of task N108.*/
package kryvenko.sergii.automation.tasks108;

/**
 * Task N108. Find the least number, which looks like 2^r, and bigger than n -
 * natural number. The natural number always positive and bigger than 0.
 */
public final class Task108 {

    /** Natural number. */
    private static final int N = 15;

    /** Default constructor. */
    private Task108() {
    }

    /**
     * Main method.
     * @param args Command line Arguments.
     */
    public static void main(final String[] args) {

        System.out.println("Exercise N108");

        Involution degree = new Involution(N);
        new Print(degree.numberR(), N).printResult();
    }

}
