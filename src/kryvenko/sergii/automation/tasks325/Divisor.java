/** The solution of task N325.*/
package kryvenko.sergii.automation.tasks325;

/**
 * Get all prime divisors of natural number n.
 */
public class Divisor implements IntDivisor {

    /**
     * Natural number.
     */
    private int naturalNumber;

    /**
     * Constructor.
     * @param num Natural number
     * @throws NotNaturalNumberException
     */
    public Divisor(final int num) throws NotNaturalNumberException {
        if (num >= 1) {
            this.naturalNumber = num;
        } else {
            throw new NotNaturalNumberException();
        }
    }

    @Override
    public final int[] findDivisors() {
        int[] array = new int[this.naturalNumber];
        if (this.naturalNumber == 1) {
            return new int[0];
        } else {
            array = primeDivisors(naturalNumber);
        }

        return array;
    }

    /**
     * Find all prime divisors.
     * @param number natural >1
     * @return int[] array prime divisors
     */
    protected int[] primeDivisors(final int number) {
        int[] array = new int[number];
        int i = 0;
        int divisor;
        for (divisor = 2; divisor <= this.naturalNumber; divisor++) {
            if (this.naturalNumber % divisor == 0) {
                if (isPrimeNumber(divisor)) {
                    array[i] = divisor;
                    i++;
                }
            }
        }

        int[] arrayPrimeDivisors = createArrayPrimeDivisors(array, i);

        return arrayPrimeDivisors;
    }

    /**
     * Checking natural number for prime number.
     * @param divisor
     * @return Boolean
     */
    protected final boolean isPrimeNumber(final int divisor) {
        int i = 0;
        for (int s = 1; s <= divisor; s++) {
            if (divisor % s == 0) {
                i++;
            }
        }
        boolean primeNumber = (i == 2) ? true : false;
        return primeNumber;
    }

    /**
     * Create a normally filled array of prime divisors.
     * @param array array of prime divisors (with zero elements)
     * @param i quantity prime divisors
     * @return int[] array prime divisors
     */
    protected int[] createArrayPrimeDivisors(final int[] array, final int i) {
        int[] arrayPrimeDivisors = new int[i];
        int numberElement = 0;
        for (int divisors : array) {
            if (divisors != 0) {
                arrayPrimeDivisors[numberElement] = divisors;
                numberElement++;
            }
        }
        return arrayPrimeDivisors;
    }

}
