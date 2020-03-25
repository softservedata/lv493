/** The solution of task N224.*/
package kryvenko.sergii.automation.tasks224;

import java.util.Scanner;

/**
 * Read entered number from console.
 */
public class ReadFromConsle {

    /**
     * Default constructor.
     */
    public ReadFromConsle() {
    }

    /**
     * Read number from console.
     * @return int number
     */
    public int readNumber() {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        scn.close();
        return number;
    }
}
