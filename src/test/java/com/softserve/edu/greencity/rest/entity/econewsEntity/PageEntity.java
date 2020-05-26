package com.softserve.edu.greencity.rest.entity.econewsEntity;

import java.util.List;

public class PageEntity {
	
	private List<NewsEntity> page;
	private int totalElements;
	private int currentPage;
	
	public PageEntity() {
		this.page = null;
		this.totalElements = 0;
		this.currentPage = 0;
	}
	
	public PageEntity(List<NewsEntity> page, int totalElements, int currentPage) {
		this.page = page;
		this.totalElements = totalElements;
		this.currentPage = currentPage;
	}
	
	public List<NewsEntity> getPage() {
		return page;
	}
	public void setPage(List<NewsEntity> page) {
		this.page = page;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	@Override
	public String toString() {
		return "PageEntity [page=" + page + ", totalElements=" + totalElements + ", currentPage=" + currentPage + "]";
	}	
}
