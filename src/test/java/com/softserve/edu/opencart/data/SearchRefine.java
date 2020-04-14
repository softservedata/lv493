package com.softserve.edu.opencart.data;

import java.util.Comparator;

public class SearchRefine {
	private boolean visibleByList;
	private String sortBy;
	private String show;
	private Comparator<String> comparator;

	public SearchRefine(boolean visibleByList, String sortBy, String show, Comparator<String> comparator) {
		this.visibleByList = visibleByList;
		this.sortBy = sortBy;
		this.show = show;
		this.comparator = comparator;
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

	public Comparator<String> getComparator() {
		return comparator;
	}

}
