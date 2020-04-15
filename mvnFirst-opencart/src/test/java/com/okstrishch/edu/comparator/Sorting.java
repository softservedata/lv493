package com.okstrishch.edu.comparator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sorting implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return 1;
        } else if (o2 == null) {
            return -1;
        }
        BigDecimal bd1 = new BigDecimal(o1.replace(",", ""));
        BigDecimal bd2 = new BigDecimal(o2.replace(",", ""));
        return bd1.compareTo(bd2);
    }

    protected List<String> getPrices(List<WebElement> products) {
        List<String> result = new ArrayList<>();
        String pattern = "^\\s*.?((\\d{1,3},)*\\d{1,3}\\.\\d{2})";
        Pattern p = Pattern.compile(pattern);

        for (WebElement current : products) {
            WebElement priceElemet = current.findElement(By.cssSelector("p.price"));
            String price = priceElemet.getText().trim();
            Matcher m = p.matcher(price);
            if (m.find()) {
                result.add(price.substring(m.start(1), m.end(1)));
            }
        }
        return result;
    }

    protected boolean isSortedByIncrease(List<String> originLists) {
        List<String> checkedList = new ArrayList<>(originLists);
        Collections.sort(checkedList, new Sorting());
        System.out.println("originLists " + originLists);
        System.out.println("checkedList " + checkedList);
        return originLists.equals(checkedList);
    }
}
