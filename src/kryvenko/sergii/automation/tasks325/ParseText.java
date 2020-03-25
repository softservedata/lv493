/** The solution of task N325.*/
package kryvenko.sergii.automation.tasks325;

import java.util.regex.Pattern;

/**
 * Parse string to number.
 */
public class ParseText implements IntParseNumber {

    /**
     * Pattern for finding numbers.
     */
    private static final Pattern IS_NUMBER;
    static {
        IS_NUMBER = Pattern.compile("\\s*-?\\d+\\s*");
    }

    @Override
    public final Integer toInteger(final String text) {
        Integer number = null;

        if (IS_NUMBER.matcher(text).matches()) {
            try {
                number = Integer.parseInt(text);
                if (number < 1) {
                    throw new NotNaturalNumberException(
                            "Number " + number + " isn't natural");
                }
            } catch (NumberFormatException e1) {
            }
        }

        return number;
    }

}
