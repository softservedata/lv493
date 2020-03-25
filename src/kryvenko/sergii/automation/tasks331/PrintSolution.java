/** The solution of task N331.*/
package kryvenko.sergii.automation.tasks331;

import java.util.ArrayList;
import java.util.List;

/**
 * Print result.
 */
public class PrintSolution {

    /**
     * Natural number.
     */
    private int naturalNumber;

    /**
     * List of different variants x, y, z.
     */
    private List<Variables> listVar = new ArrayList<Variables>();

    /**
     * Constructor.
     * @param num Natural number.
     * @param list List<Variables> variables.
     */
    public PrintSolution(final int num, final List<Variables> list) {
        this.naturalNumber = num;
        this.listVar = list;
    }

    /**
     * Print result a).
     */
    public void printResultA() {
        if (listVar.size() > 0) {
            int x = listVar.get(0).getX();
            int y = listVar.get(0).getY();
            int z = listVar.get(0).getZ();
            System.out.println("Solution a)");
            System.out.print("x = " + x + "; y = " + y + "; z = " + z);
            System.out.print("\t (" + naturalNumber + " = " + x * x + " + "
                    + y * y + " + " + z * z + ")\n\n");
        } else {
            System.out.println(
                    "Natural number n=" + naturalNumber + " hasn't results");
        }
    }

    /**
     * Print result b).
     */
    public void printResultB() {
        if (listVar.size() > 0) {
            System.out.println("Solution b)");
            int i = 1;
            for (Variables variables : listVar) {
                int quadrateX = variables.getX() * variables.getX();
                int quadrateY = variables.getY() * variables.getY();
                int quadrateZ = variables.getZ() * variables.getZ();
                System.out.printf("Solution %s:\t x = %s; y = %s; z = %s\t", i,
                        variables.getX(), variables.getY(), variables.getZ());
                System.out.printf("(%s = %s + %s + %s)\n", naturalNumber,
                        quadrateX, quadrateY, quadrateZ);
                i++;
            }
        }
    }
}
