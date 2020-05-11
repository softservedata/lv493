package com.softserve.edu.greencity.ui.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewsData {

    private String title;
    private List<Tag> tags;
    private String source;
    private String content;
    private String filePath;

    public NewsData(List<Tag> tags, String title, String content) {
        this.title = title;
        this.tags = tags;
        this.content = content;
        this.source = "";
        this.filePath = "";
    }

    public NewsData(String title, List<Tag> tags, String source, String content, String filePath) {
        this.title = title;
        this.tags = tags;
        this.source = source;
        this.content = content;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
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
    
    public List<String> getTagsName() {
    	List<String> list = new ArrayList<>();
    	for(Tag current : getTags()) {
    		list.add(current.toString().toLowerCase());
    	}
		return list;
    }
    
    
    
    @Override
	public String toString() {
		return "NewsData [title=" + title + ", tags=" + tags.toString() + ", content=" + content + "]";
	}

	public Set<String> getTagName() {
    	Set<String> set = new HashSet<>();
    	for(Tag current : getTags()) {
    		set.add(current.toString().toLowerCase());
    	}
		return set;
    }
    
    
}
