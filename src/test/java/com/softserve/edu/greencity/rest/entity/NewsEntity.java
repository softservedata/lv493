package com.softserve.edu.greencity.rest.entity;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.json.Json;

public class NewsEntity extends AllNewsResponseEntity {
	private int id;
	private String creationDate;
	private String imagePath;
	private String title;
	private String text;
	private String source;
	private Json author;
	private List<String> tags;

	public NewsEntity() {
		id = -1;
		creationDate = "";
		imagePath = "";
		title = "";
		text = "";
		source = "";
		author = new Json();
		tags = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getSource() {
		return source;
	}

	public Json getAuthor() {
		return author;
	}

	public List<String> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "NewsEntity [id=" + id
				+ ", creationDate=" + creationDate
				+ ", imagePath=" + imagePath
				+ ", title=" + title
				+ ", text=" + text
				+ ", source=" + source
				+ ", author=" + author
				+ ", tags=" + tags + "]";
	}
	
}
