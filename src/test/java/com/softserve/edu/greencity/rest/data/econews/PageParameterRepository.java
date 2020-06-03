package com.softserve.edu.greencity.rest.data.econews;


public final class PageParameterRepository {

	private static PageParameterRepository instance = null;

	private PageParameterRepository() {
	}

	public static PageParameterRepository get() {
		if (instance == null) {
			synchronized (PageParameterRepository.class) {
				if (instance == null) {
					instance = new PageParameterRepository();
				}
			}
		}
		return instance;
	}
	
	public static PageParameters getDefault() {
		return  getPageParameters();
	}
	
	public static PageParameters getPageParameters() {
		return new PageParameters("1","10");
	}

	public static PageParameters getTagsParameters() {
		PageParameters pageParameter = new PageParameters("1","10");
				pageParameter.addTag("news").addTag("events");
				return pageParameter;
	}
	
}
