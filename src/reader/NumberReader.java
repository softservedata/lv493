package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NumberReader implements DataReader<Integer> {
    @Override
    public final Integer read(final InputStream in) {
        BufferedReader reader = null;
        int n = 0;
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            n = Integer.parseInt(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return n;
    }
}
