package com.softserve.edu.data;

public class SearchInCategoriesRepository {
	
	private SearchInCategoriesRepository() {
	}
	
	public static SearchItem searchDefault() {
		return searchAllCategories();
	}
	
	public static SearchItem searchAllCategories() {
		return new SearchItem("mac", Categories.ALL_CATEGORIES);
	}
	
	public static SearchItem searchCategoryDesctops() {
		return new SearchItem("apple", Categories.DESCTOPS);
	}
	
	public static SearchItem searchCategoryCameras() {
		return new SearchItem("canon", Categories.CAMERAS);
	}
	
	public static SearchItem searchCategoryComponents() {
		return new SearchItem("apple", Categories.COMPONENTS);
	}
	
	public static SearchItem searchCategoryLaptops() {
		return new SearchItem("macbook", Categories.LAPTOPS_AND_NOTEBOOKS);
	}
	
	public static SearchItem searchCategoryMp3Players() {
		return new SearchItem("ipod", Categories.MP3_PLAYERS);
	}
	
	public static SearchItem searchCategoryPhones() {
		return new SearchItem("htc", Categories.PHONES);
	}
	
	public static SearchItem searchCategorySoftware() {
		return new SearchItem("htc", Categories.SOFTWARE);
	}
	
	public static SearchItem searchCategoryTablets() {
		return new SearchItem("samsung", Categories.TABLETS);
	}
}
