package com.softserve.edu.opencart.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFilters {

	public List<String> getElemets(List<WebElement> products, By by, String pattern) {
		List<String> result = new ArrayList<>();
		//String pattern = "^\\s*.?((\\d{1,3},)*\\d{1,3}\\.\\d{2})";
		Pattern p = Pattern.compile(pattern);
		//
		for (WebElement current : products) {
			WebElement priceElemet = current.findElement(by);
			String price = priceElemet.getText().trim();
			Matcher m = p.matcher(price);
			if (m.find()) {
				result.add(price.substring(m.start(1), m.end(1)));
			}
		}
		return result;
	}

	public boolean isSorted(List<String> originLists, Comparator<String> comparator) {
		List<String> checkedList = new ArrayList<>(originLists);
		Collections.sort(checkedList, comparator);
		//ollections.sort(checkedList);
		System.out.println("originLists " + originLists);
		System.out.println("checkedList " + checkedList);
		return originLists.equals(checkedList);
	}
}
