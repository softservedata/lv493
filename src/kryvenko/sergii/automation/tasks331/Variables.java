/** The solution of task N331.*/
package kryvenko.sergii.automation.tasks331;

/**
 * Class of three variables x, y, z.
 */
public class Variables {

    /**
     * The variable x.
     */
    private int x;
    /**
     * The variable y.
     */
    private int y;
    /**
     * The variable z.
     */
    private int z;

    /**
     * Constructor.
     * @param var1 The variable x.
     * @param var2 The variable y.
     * @param var3 The variable z.
     */
    public Variables(final int var1, final int var2, final int var3) {
        this.x = var1;
        this.y = var2;
        this.z = var3;
    }

    /**
     * Getter x.
     * @return integer x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter y.
     * @return integer y
     */
    public int getY() {
        return y;
    }

    /**
     * Getter z.
     * @return integer z
     */
    public int getZ() {
        return z;
    }

}
