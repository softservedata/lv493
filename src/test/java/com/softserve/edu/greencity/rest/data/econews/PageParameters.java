package com.softserve.edu.greencity.rest.data.econews;

import java.util.ArrayList;
import java.util.List;

public class PageParameters {
	
	private  String page;
	private  String size;
	private List<String> tags;

	public PageParameters(String page, String size, List<String> tags) {
		this.page = page;
		this.size = size;
		this.tags = tags;
	}
	public PageParameters(String page, String size) {
		this.page = page;
		this.size = size;
		this.tags = new ArrayList<String>();
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

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public PageParameters addTag(String tag){
		tags.add(tag);
		return this;
	}

	public boolean verifyNewsByTags(List<News> news, List<String> tags){
		boolean result = true;
		for (News currentNews : news){
			result =  result && verifyTags(currentNews, tags);
		}
		return result;
	}

	public boolean verifyTags(News news, List<String> tags){
		boolean result = false;
		for (String currentTag : tags){
			result =  result || (news.getTags().contains(currentTag));
			if (result){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "PageParameters [page=" + page + ", size=" + size + "]";
	}

	public String toStringWithTags() {
		return "PageParameters [page=" + page + ", size=" + size + ", tags=" + tags + "]";
	}
}
