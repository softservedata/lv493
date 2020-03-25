package algorithm;

import java.util.List;

import reader.ArrayReader;

/**
 * Class designed to demonstrate a work of Condition class.
 */
final class AppMatchConditions {
    private AppMatchConditions() {

    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        ArrayReader reader = new ArrayReader();

        System.out.println("Enter numbers to match the conditions:");
        List<Integer> elementsForCondition = reader.read(System.in);
        ConditionCheck cond = new ConditionCheck(elementsForCondition);

        System.out.println(
                "\nCount numbers of elements that match the first condition: "
                        + "element less than previous one added "
                        + "next element and divided by 2.");
        System.out.println("First condition - "
                + cond.findNumbersCountLessThanCondition() + " elements.\n");

        System.out.println(
                "Count numbers of elements that match the second condition: "
                        + "element less than factorial of sequence number"
                        + "and more than 2^sequence number.");
        System.out.println("Second condition - "
                + cond.findNumbersCountBetweenConditions() + " elements.");

    }
}
