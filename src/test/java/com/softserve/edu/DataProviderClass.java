package com.softserve.edu;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

import java.io.*;

/**
 * Data provider class for testing categories
 */
public class DataProviderClass {

    /**
     * Path to properties file for testing
     */
    static String categoriesDataFilePath = "newCategories.json";

    /**
     * Strutter class for adding and deleting new category
     */
    static class CategoryData {
        String categoryName = "";
        String description = "";
        String metaTagTitle = "";
        boolean isTop = true;
        String metaTagDescription = "";
        String metaTagKeyword = "";
        String parent = "";
    }


    /**
     * Getting category data from json file
     * @return - parameters for adding and deleting new category
     * @throws FileNotFoundException - throw it if file is not exist
     */
    @DataProvider
    public static Object[][] newCategories() throws FileNotFoundException {
        Gson gson = new Gson();
        Reader input = new FileReader(categoriesDataFilePath);
        CategoryData[] data = gson.fromJson(input, CategoryData[].class);
        Object[][] categories = new Object[data.length][1];

        for (int i = 0; i < data.length; i++) {
            categories[i][0] = data[i];
        }

        return categories;
    }
}
