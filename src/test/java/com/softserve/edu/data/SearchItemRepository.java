package com.softserve.edu.data;

public class SearchItemRepository {
	
	private SearchItemRepository() {
	}
	
	public static SearchItem getDefault() {
		return getAllItem();
	}
	
	public static SearchItem getAllItem() {
		return new SearchItem("%");
	}
}
