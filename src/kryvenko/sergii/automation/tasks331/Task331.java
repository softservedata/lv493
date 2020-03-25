/** The solution of task N331.*/
package kryvenko.sergii.automation.tasks331;

import java.util.List;

/**
 * Task N331. Find three natural numbers when square of those numbers equals our
 * natural number 'n'.
 */
public final class Task331 {

    /** Natural number. */
    private static final int N = 6;

    /** Default constructor. */
    private Task331() {
    }

    /**
     * Main method.
     * @param args Command line Arguments.
     */
    public static void main(final String[] args) {
        System.out.println("Task N331");
        System.out.println("Natural number n = " + N + "\n");
        Solution s = new Solution(N);
        List<Variables> list = s.findVariables();
        PrintSolution print = new PrintSolution(N, list);
        print.printResultA();
        print.printResultB();

    }

}
