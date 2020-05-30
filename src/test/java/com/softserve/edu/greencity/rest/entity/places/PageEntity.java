package com.softserve.edu.greencity.rest.entity.places;

import java.util.List;

public class PageEntity {
	
	private List<PlaceEntity> page;
	private int totalElements;
	private int currentPage;
	
	private String message;
	
	public PageEntity() {
		this.page = null;
		this.totalElements = 0;
		this.currentPage = 0;
	}
	
	public PageEntity(String message) {
		this.page = null;
		this.totalElements = 0;
		this.currentPage = 0;
		this.message = message;
	}
	
	public PageEntity(List<PlaceEntity> page, int totalElements, int currentPage) {
		this.page = page;
		this.totalElements = totalElements;
		this.currentPage = currentPage;
	}
	
	public List<PlaceEntity> getPage() {
		return page;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "PageEntity [page=" + page + ", totalElements=" + totalElements + ", currentPage=" + currentPage
				+ ", message=" + message + "]";
	}
	
	

}
