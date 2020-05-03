package com.softserve.edu.greencity.ui.data;

import java.util.List;

public class NewsData {

	  	private String title;
	    private List<Tag> tags;
	    private String source;
	    private String content;

	    public NewsData( List<Tag> tags,  String title, String content) {
	        this.title = title;
	        this.tags = tags;
	        this.content = content;
	    }
	    
	    public NewsData(List<Tag> tags, String title, String source, String content) {
	        this.title = title;
	        this.tags = tags;
	        this.source = source;
	        this.content = content;
	    }

	public NewsData( List<Tag> tags,  String title, String source, String content, String path) {
		this.title = title;
		this.tags = tags;
		this.source = source;
		this.content = content;
	}
	    public String getTitle() {
	        return title;
	    }

	    public List<Tag> getTags() {
	        return tags;
	    }

	    public String getSource() {
	        return source;
	    }

	    public String getContent() {
	        return content;
	    }
}
