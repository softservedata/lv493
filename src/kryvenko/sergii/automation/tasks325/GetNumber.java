/** The solution of task N325.*/
package kryvenko.sergii.automation.tasks325;

/**
 * Using ReadFromConsole and ParseText to getting integer number from console.
 */
public class GetNumber {

    /**
     * Get text from console and return the integer number.
     * @return integer number.
     */
    public int fromConsole() {
        Integer number = null;
        try (ReadFromConsole reading = new ReadFromConsole()) {
            ParseText parseText = new ParseText();
            while (number == null) {
                System.out.println("Enter natural number n ");
                String text = reading.getEnteredtext();

                if (text == null) {
                    return 0;
                } else {
                    number = parseText.toInteger(text);
                }

                if (number == null) {
                    System.out.println("You entered the wrong number: " + text);
                }
            }
        }
        return number;
    }

}
