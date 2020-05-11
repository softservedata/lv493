package com.softserve.edu.greencity.ui.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static String getValueAfterColon(String text) { // tools > RegexUtils
        //text = "Date: April 26, 2020";
        final Matcher matcher = Pattern.compile("[a-zA-Z]: ").matcher(text);
        if (matcher.find()) {
            System.out.println(text.substring(matcher.end()).trim());
        }
        return text.substring(matcher.end()).trim();
    }
}
