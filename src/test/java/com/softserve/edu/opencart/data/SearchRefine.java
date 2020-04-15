package com.softserve.edu.opencart.data;

import java.util.Comparator;

import org.openqa.selenium.By;

public class SearchRefine {
	private boolean visibleByList;
	// TODO
	private String sortBy;
	private String show;
	//
	private Currencies currencies;
	private Comparator<String> comparator;
	private By by;
	private String pattern;

	public SearchRefine(boolean visibleByList,
			String sortBy, String show, Currencies currencies,
			Comparator<String> comparator, By by, String pattern) {
		this.visibleByList = visibleByList;
		this.sortBy = sortBy;
		this.show = show;
		this.currencies = currencies;
		this.comparator = comparator;
		this.by = by;
		this.pattern = pattern;
	}

	public boolean isVisibleByList() {
		return visibleByList;
	}

	public String getSortBy() {
		return sortBy;
	}

	public String getShow() {
		return show;
	}

	public Currencies getCurrencies() {
		return currencies;
	}

	public Comparator<String> getComparator() {
		return comparator;
	}

	public By getBy() {
		return by;
	}

	public String getPattern() {
		return pattern;
	}

}
