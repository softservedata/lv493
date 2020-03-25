/** The solution of task N224.*/
package kryvenko.sergii.automation.tasks224;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all natural divisors of natural number n.
 */
public class Divisors implements IntDivisors {


    /**
     * Find divisors.
     * @param naturalNumber
     * @return List<Integer> of divisors
     */
    @Override
    public List<Integer> findDivisors(final int naturalNumber) {
        List<Integer> array = new ArrayList<Integer>();
        for (int divisor = 1; divisor <= naturalNumber; divisor++) {
            if (naturalNumber % divisor == 0) {
                array.add(divisor);
            }
        }
        return array;
    }

}
