package com.softserve.edu.greencity.ui.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateUtils {

    public static String getCurrentDate() { //tools > DateUtil > static
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MMMM dd, yyyy").toFormatter();
        return date.format(formatter);
    }
}
