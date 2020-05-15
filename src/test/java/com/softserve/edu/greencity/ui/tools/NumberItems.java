package com.softserve.edu.greencity.ui.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class NumberItems {

    public int numberItems(String text) {
        
        final Matcher matcher = Pattern.compile("[0-9]+").matcher(text);
        if (matcher.find()) {
           text.substring(matcher.start(), matcher.end());
        }

        return Integer.valueOf(text.substring(matcher.start(), matcher.end()));
    }

}
