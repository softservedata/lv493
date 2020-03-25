/** The solution of task N325.*/
package kryvenko.sergii.automation.tasks325;

/**
 * Exception for not natural number.
 */
public class NotNaturalNumberException extends RuntimeException {

    /**
     * Generated serial number.
     */
    private static final long serialVersionUID = 4980568805650370604L;

    /**
     * Default constructor Exception.
     */
    public NotNaturalNumberException() {
        super();
        printException();
    }

    /**
     * Constructor Exception with incoming parameter.
     * @param text
     */
    public NotNaturalNumberException(final String text) {
        super(text);
        printException();
    }

    /**
     * Exception for not natural number.
     */
    public void printException() {
        System.err.println("Number isn't natural");
    }

}
