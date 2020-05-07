package com.softserve.edu.greencity.ui.tools;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomizer {

    public static String getRamdomString(int length, boolean useLetters, boolean useNumbers) {
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
    
    public static String getRamdomPassword() {
        int leftLimit = 33; // ASCII symbol '!'
        int rightLimit = 126; // ASCII symbol '~'
        int targetStringLength = 15;
        Random random = new Random();

        String generatedPassword = random.ints(leftLimit, rightLimit + 1)
//                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength).collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedPassword;
    }
}
