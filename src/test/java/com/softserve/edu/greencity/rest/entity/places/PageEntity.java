package com.softserve.edu.greencity.rest.entity.places;

import java.util.List;
/**
 * Return page with plases
 * 
 * @author lv-493
 *
 */
public class PageEntity {
	
	private List<String> pages;
	private List<PlaceEntity> page;
	private int totalElements;
	private int currentPage;
	
	private String message;
	
	public PageEntity() {
		this.page = null;
		this.totalElements = 0;
		this.currentPage = 0;
	}
	
	//for expected error message
	
	public PageEntity(String message) {
		this.message = message;
	}

	public PageEntity(List<String> pages, List<PlaceEntity> page, int totalElements, int currentPage, String message) {
		
		this.pages = pages;
		this.page = page;
		this.totalElements = totalElements;
		this.currentPage = currentPage;
		this.message = message;
	}

	public PageEntity(List<PlaceEntity> page, int totalElements, int currentPage) {
		this.page = page;
		this.totalElements = totalElements;
		this.currentPage = currentPage;
	}
	
	//geters
	
	public List<PlaceEntity> getPage() {
		return page;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return "PageEntity [page=" + page + ", totalElements=" + totalElements + ", currentPage=" + currentPage + "]";
	}
	
	

}