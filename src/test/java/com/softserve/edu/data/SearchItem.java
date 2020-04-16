package com.softserve.edu.data;

/*
 * class with paremeters of searching product
 */
public class SearchItem {
	
	private String searchText;
	private Categories categories;
	
	public SearchItem(String searchText, Categories categories) {
		this.searchText = searchText;
		this.categories = categories;
	}

	public Categories getCategories() {
		return categories;
	}

	public String getSearchText() {
		return searchText;
	}
}
