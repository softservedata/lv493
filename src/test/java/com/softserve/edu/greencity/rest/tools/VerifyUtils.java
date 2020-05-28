package com.softserve.edu.greencity.rest.tools;

import java.util.List;

public class VerifyUtils {
    private VerifyUtils() {
        
    }
    @SuppressWarnings("unchecked")
    public static boolean verifyClass(List<?> list) {
        boolean result = true;
        for(Verifaible current : (List<Verifaible>)list) {
            result = result && current.isValid();
            if(!result){
                break;
            }
        }
        return result;
    }
}
