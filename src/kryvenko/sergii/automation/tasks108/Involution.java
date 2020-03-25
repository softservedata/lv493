/** The solution of task N108.*/
package kryvenko.sergii.automation.tasks108;

/**
 * Find solution for task N108.
 */
public class Involution implements IntInvolution {

    /**
     * degree.
     */
    private int degree;

    /**
     * natural number.
     */
    private final int naturalNumber;

    /**
     * Constructor.
     * @param num Our natural number
     */
    public Involution(final int num) {
        this.degree = 1;
        this.naturalNumber = num;
    }

    /**
     * Exponentiation 2^r.
     * @param r degree
     * @return Result 2^r
     */
    protected int exponentiation(final int r) {
        int result = 1;
        for (int i = 1; i <= r; i++) {
            result *= 2;
        }
        return result;
    }

    /**
     * Finding the necessary degree r.
     * @return Degree r.
     */
    public int numberR() {
        for (int r = 1; r <= naturalNumber; r++) {
            if (exponentiation(r) > naturalNumber) {
                degree = r;
                break;
            }
        }
        return degree;
    }

}
