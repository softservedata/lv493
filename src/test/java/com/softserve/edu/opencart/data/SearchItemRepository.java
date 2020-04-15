package com.softserve.edu.opencart.data;

public final class SearchItemRepository {

	private SearchItemRepository() {
	}
	
	public static SearchItem getDefault() {
		return getAllItem();
	}
	
	public static SearchItem getAllItem() {
		return new SearchItem("%", "All Categories", false, false);
	}
	
	public static SearchItem getMacItem() {
		return new SearchItem("mac", "All Categories", false, false);
	}
}
