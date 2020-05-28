package com.softserve.edu.greencity.rest.data.econews;

public class PageParameters {
	
	private  String page;
	private  String size;
	
	
	  public PageParameters(String page, String size) { 
		  this.page = page;
		  this.size = size; 
		  }
	
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "PageParameters [page=" + page + ", size=" + size + "]";
	}
	
	

}
