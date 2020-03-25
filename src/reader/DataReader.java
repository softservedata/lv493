package reader;

import java.io.InputStream;

public interface DataReader<T> {
    /**
     * Read data from input stream.
     * @param in - stream
     * @return data according to T type
     */
    T read(InputStream in);
}
