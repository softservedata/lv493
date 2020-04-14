package com.softserve.edu.opencart.data;

public class SearchItem {
	private String searchText;
	private String categoryName;
	private boolean searchSubcategories;
	private boolean searchDescriptions;

	public SearchItem(String searchText, String categoryName,
			boolean searchSubcategories, boolean searchDescriptions) {
		this.searchText = searchText;
		this.categoryName = categoryName;
		this.searchSubcategories = searchSubcategories;
		this.searchDescriptions = searchDescriptions;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public boolean isSearchSubcategories() {
		return searchSubcategories;
	}

	public boolean isSearchDescriptions() {
		return searchDescriptions;
	}

}
