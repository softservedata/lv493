package com.softserve.edu.greencity.rest.data.econews;


public final class PageParameterRepository {
	
	private PageParameterRepository() {
	}
	
	public static PageParameters getDefault() {
		return  getNews();
	}
	
	public static PageParameters getNews() {
		return new PageParameters("0","10");
	}
	
}
