package com.softserve.edu.opencart.data;

import org.openqa.selenium.By;

import com.softserve.edu.opencart.data.comparator.StrPriceDescComparator;

public final class SearchRefineRepository {

	private SearchRefineRepository() {
	}
	
	public static SearchRefine getDefault() {
		return getPriceDescUsd();
	}
	
	public static SearchRefine getPriceDescUsd() {
		return new SearchRefine(true, "Price (High > Low)", "15",
				Currencies.US_DOLLAR, new StrPriceDescComparator(),
				By.cssSelector("p.price"), "^\\s*.?((\\d{1,3},)*\\d{1,3}\\.\\d{2})");
	}
	
	public static SearchRefine getExTaxPriceDescUsd() {
		return new SearchRefine(true, "Price (High > Low)", "15",
				Currencies.US_DOLLAR, new StrPriceDescComparator(),
				By.cssSelector("p.price"), ": *.?((\\d{1,3},)*\\d{1,3}\\.\\d{2})");
	}
}
