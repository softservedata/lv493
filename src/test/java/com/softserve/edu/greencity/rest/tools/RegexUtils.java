package com.softserve.edu.greencity.rest.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {
    private RegexUtils() {
    }

    public static String getValueAfterColon(String text) { // tools > RegexUtils
        //text = "Date: April 26, 2020";
        final Matcher matcher = Pattern.compile("[a-zA-Z]: ").matcher(text);
        if (matcher.find()) {
            System.out.println(text.substring(matcher.end()).trim());
        }
        return text.substring(matcher.end()).trim();
    }
    
    public static String getToken(String text) {
        String verifyEmailURL = text;
        Pattern pattern;
        Matcher matcher;
        String token = "";
        String id = "";
        pattern = Pattern.compile(".*token=(.+)&.*id=(.+)");
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            token = matcher.group(1);
            id = matcher.group(2);
//            System.out.println("url: " + matcher.group(1));
//            System.out.println("id: " + matcher.group(2));
        }
        return token;
    }
    
    public static int getId(String text) {
        String verifyEmailURL = text;
        Pattern pattern;
        Matcher matcher;
        String token = "";
        String id = "";
        pattern = Pattern.compile(".*token=(.+)&.*id=(.+)");
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            token = matcher.group(1);
            id = matcher.group(2);
//            System.out.println("url: " + matcher.group(1));
//            System.out.println("id: " + matcher.group(2));
        }
        return Integer.parseInt(id);
    }
}
