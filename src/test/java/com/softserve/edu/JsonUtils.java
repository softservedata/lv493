package com.softserve.edu;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * Utils for deserialization json
 */

public class JsonUtils {
    /**
     * Deserialization json from file
     * @param path to json file
     * @return DataProvider in simple array format
     * @throws FileNotFoundException if file is not found
     */
    public static DataProviderClass.CategoryData[] deserializeJson(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        Reader input = new FileReader(path);
        return gson.fromJson(input, DataProviderClass.CategoryData[].class);
    }
}
