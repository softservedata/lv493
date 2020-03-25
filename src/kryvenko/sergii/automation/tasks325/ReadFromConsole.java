/** The solution of task N325.*/
package kryvenko.sergii.automation.tasks325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reading text from the console and parsing it to an integer.
 */
public class ReadFromConsole implements IntReadFromConsole, AutoCloseable {

    /**
     * Entered text from console.
     */
    private String text;

    /**
     * BufferedReader.
     */
    private BufferedReader br;

    /**
     * Constructor.
     */
    public ReadFromConsole() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public final String getEnteredtext() {
        try {
            this.text = br.readLine();
            return this.text;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Close BufferedReader.
     */
    @Override
    public void close() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
