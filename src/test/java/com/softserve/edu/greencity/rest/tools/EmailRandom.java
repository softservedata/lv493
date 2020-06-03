package com.softserve.edu.greencity.rest.tools;

import java.util.Random;

public class EmailRandom {
    /**
     * Email is created random 10 symbol and '@test.com'
     * 
     * @return random email
     */

    public String getEmailRandom() {

        final String SMALL_CHARS = "abcdefghijklmnopqrstuvwxyz";
        final String NUMBERS = "0123456789";
        String file = SMALL_CHARS + NUMBERS;
        StringBuilder bulder = new StringBuilder();
        Random random = new Random();
        while (bulder.length() < 14) {
            int index = (int) (random.nextFloat() * file.length());
            bulder.append(file.charAt(index));
        }

        String bulderStr = bulder.toString();
        return bulderStr + "@test.com";

    }
}
