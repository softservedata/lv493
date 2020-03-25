/** The solution of task N325.*/
package kryvenko.sergii.automation.tasks325;

/**
 * Print result to console.
 */
public class Print {

    /**
     * Method for printing to console.
     * @param array int[]
     * @param number integer natural number
     */
    public void arrayDivisors(final int[] array, final int number) {
        int i = 0;
        if (array.length < 1) {
            System.out.println("No prime numbers for natural number " + number);
        } else {
            System.out.printf("Your natural number %s has prime divisors:\n",
                    number);
            for (int primeNumber : array) {
                System.out.println(i + ":\t" + primeNumber);
                i++;
            }
        }
    }

}
