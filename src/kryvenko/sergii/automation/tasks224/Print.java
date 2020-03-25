/** The solution of task N224.*/
package kryvenko.sergii.automation.tasks224;

import java.util.List;

/**
 * Print result.
 */
public class Print {

    /**
     * Print our divisors.
     * @param naturalNumber
     * @param arrayDivisors List<Integer> of divisors
     */
    public void printDivisors(final int naturalNumber,
            final List<Integer> arrayDivisors) {
        int i = 1;
        for (int a : arrayDivisors) {
            if (a != 0) {
                System.out.printf("%s divisor of the natural number %s is %s\n",
                        i, naturalNumber, a);
                i++;
            }
        }
    }
}
