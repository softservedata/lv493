package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArrayReader implements DataReader<List<Integer>> {

    @Override
    public final List<Integer> read(final InputStream in) {
        BufferedReader reader = null;
        String n = null;

        try {
            reader = new BufferedReader(new InputStreamReader(in));
            n = reader.readLine();

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
        List<Integer> nums = new ArrayList<>();
        if (n != null) {
            String[] numbersLine = n.split(" ");

            for (int i = 0; i < nums.size(); i++) {
                nums.add(Integer.parseInt(numbersLine[i]));
            }
        }
        return nums;
    }

}
