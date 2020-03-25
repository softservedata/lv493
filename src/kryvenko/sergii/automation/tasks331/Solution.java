/** The solution of task N331.*/
package kryvenko.sergii.automation.tasks331;

import java.util.ArrayList;
import java.util.List;

/**
 * Find three natural numbers when square of those numbers equals our natural
 * number 'n'.
 */
public class Solution implements IntSolution {

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
     * @param num Natural integer number.
     */
    public Solution(final int num) {
        this.naturalNumber = num;
    }

    @Override
    public final List<Variables> findVariables() {
        int x;
        int y;
        int z;
        for (x = 1; x <= naturalNumber; x++) {
            for (y = 1; y <= naturalNumber; y++) {
                for (z = 1; z <= naturalNumber; z++) {
                    if ((((x * x) + (y * y) + (z * z)) == naturalNumber)
                            && (x >= 1) && (y >= 1) && (z >= 1)) {
                        listVar.add(new Variables(x, y, z));
                    }
                }
            }
        }
        return listVar;
    }

}
