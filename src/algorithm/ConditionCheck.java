package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Class designed to find count of elements that match the condition.
 */
public final class ConditionCheck {

    /**
     * List that contains elements.
     */
    private List<Integer> numbers;

    /**
     * Constructor for class without parameters.
     */
    public ConditionCheck() {
        numbers = new ArrayList<>();
    }

    /**
     * Constructor for class with parameter.
     *
     * @param nums - array of numbers
     */
    public ConditionCheck(final List<Integer> nums) {
        numbers = new ArrayList<>(nums);
    }

    /**
     * Set-method for numbers.
     *
     * @param nums - array of numbers
     */
    public void setNumbers(final List<Integer> nums) {
        numbers = new ArrayList<>(nums);
    }

    /**
     * Count numbers of elements that match the condition: element less than
     * previous element added next one and divided by 2.
     *
     * @return count of elements that match the condition
     */
    public int findNumbersCountLessThanCondition() {

        if (numbers.size() == 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        for (int i = 1; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < (numbers.get(i - 1) + numbers.get(i + 1))
                    / 2) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculate factorial of entered number.
     *
     * @param n
     * @return value of factorial
     */

    private int calculateFactorial(final int n) {

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    /**
     * Count numbers of elements that match the condition: element less than
     * factorial of sequence number and more than 2^sequence number.
     *
     * @return count of elements that match the condition
     */
    public int findNumbersCountBetweenConditions() {

        if (numbers.size() == 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < calculateFactorial(i + 1)
                    && numbers.get(i) > Math.pow(2, i + 1)) {
                count++;
            }
        }
        return count;
    }
}
