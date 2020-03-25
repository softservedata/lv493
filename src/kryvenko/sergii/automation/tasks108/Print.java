/** The solution of task N108.*/
package kryvenko.sergii.automation.tasks108;

/**
 * Print solution for task N108.
 */
public class Print {

    /**
     * degree.
     */
    private final int r;

    /**
     * result 2^r.
     */
    private int resultExp;

    /**
     * natural number.
     */
    private final int naturalNumber;

    /**
     * Constructor.
     * @param degree r
     * @param num Our natural number
     */
    public Print(final int degree, final int num) {
        this.naturalNumber = num;
        this.r = degree;
        this.resultExp = new Involution(num).exponentiation(degree);
    }

    /**
     * Print our result.
     */
    public void printResult() {
        System.out.println("Solution: n= " + naturalNumber + "; degree r= " + r
                + "; result 2^r= " + resultExp);
    }
}
