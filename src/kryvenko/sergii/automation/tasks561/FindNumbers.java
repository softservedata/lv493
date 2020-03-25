/**
 * The solution of task N561.
 */
package kryvenko.sergii.automation.tasks561;

/**
 * Find all numbers from 1 to n where last symbol square of the
 * number equals the last symbol this number.
 */
public class FindNumbers {

    /**
     * Natural number.
     */
    private int naturalNumber;

    /**
     * Array of needed numbers.
     */
    private int[] numbers;

    /**
     * Default constructor.
     */
    public FindNumbers() {
    }

    /**
     * Constructor.
     * @param num Natural number
     */
    public FindNumbers(final int num) {
        this.naturalNumber = num;
    }

    /**
     * Number in square.
     * @param num Number
     * @return Square of number.
     */
    protected int squareNumber(final int num) {
        return (num * num);
    }

    /**
     * Find last symbol of number.
     * @param num Incoming integer
     * @return Last integer symbol of number
     */
    protected int findLastSymbolOfNumber(final int num) {
        String str = String.valueOf(num);
        char s = str.charAt(str.length() - 1);
        int number = Integer.parseInt(String.valueOf(s));
        return number;
    }

    /**
     * Checking numbers for equality to the last character of the square of
     * number.
     * @return An array of needed numbers.
     */
    public int[] numberCheck() {
        int j = 0;
        int[] array = new int[naturalNumber];
        for (int i = 1; i <= naturalNumber; i++) {
            int square = squareNumber(i);
            int lastSymbolOfSquare = findLastSymbolOfNumber(square);
            int lastSymbolOfNumber = findLastSymbolOfNumber(i);
            if (lastSymbolOfSquare == lastSymbolOfNumber) {
                array[j] = i;
                j++;
            }
        }

        int i = 0;
        numbers = new int[j];
        for (int num : array) {
            if (num != 0) {
                this.numbers[i] = num;
                i++;
            }
        }

        return this.numbers;
    }
}
