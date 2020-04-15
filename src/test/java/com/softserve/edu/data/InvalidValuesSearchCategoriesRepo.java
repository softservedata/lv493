package com.softserve.edu.data;

public class InvalidValuesSearchCategoriesRepo {
	
	private InvalidValuesSearchCategoriesRepo( ) {
	}
	
	public static SearchItem searchDefault() {
		return searchAllCategories();
	}
	
	public static SearchItem searchAllCategories() {
		return new SearchItem("apple mac", Categories.ALL_CATEGORIES);
	}
	
	public static SearchItem searchCategoryDesctops() {
		return new SearchItem("canon", Categories.DESCTOPS);
	}
	
	public static SearchItem searchCategoryCameras() {
		return new SearchItem("mac", Categories.CAMERAS);
	}
	
	public static SearchItem searchCategoryComponents() {
		return new SearchItem("apple", Categories.COMPONENTS);
	}
	
	public static SearchItem searchCategoryLaptops() {
		return new SearchItem("SyncMaster", Categories.LAPTOPS_AND_NOTEBOOKS);
	}
	
	public static SearchItem searchCategoryMp3Players() {
		return new SearchItem("htc", Categories.MP3_PLAYERS);
	}
	
	public static SearchItem searchCategoryPhones() {
		return new SearchItem("ipod", Categories.PHONES);
	}
	
	public static SearchItem searchCategorySoftware() {
		return new SearchItem("samssung", Categories.SOFTWARE);
	}
	
	public static SearchItem searchCategoryTablets() {
		return new SearchItem("mac", Categories.TABLETS);
	}
}
