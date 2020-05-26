package com.softserve.edu.greencity.rest.entity.econewsEntity;

import java.util.Arrays;
import java.util.List;

import com.softserve.edu.greencity.rest.tools.Verifeible;

public class NewsEntity implements Verifeible {
	
    private String creationDate;
    private String imagePath;
    private int id;
    private String title;
    private String text;
    private String source;
    //
    private AuthorEntity author; // "id": 33, // "name": "myname"
    private  String[] tags;
    
	public NewsEntity(String creationDate, String imagePath, int id, String title, String text, String source,
			AuthorEntity author, String[] tags) {
		this.creationDate = creationDate;
		this.imagePath = imagePath;
		this.id = id;
		this.title = title;
		this.text = text;
		this.source = source;
		this.author = author;
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "NewsEntity [creationDate=" + creationDate + ", imagePath=" + imagePath + ", id=" + id + ", title="
				+ title + ", text=" + text + ", source=" + source + ", author=" + author.getName() +" " + author.getId()
				+ ", tags=" + (Arrays.asList(tags)).toString() +
				"]";
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public int getId() {
		return id;
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

	public AuthorEntity getAuthor() {
		return author;
	}

	public List<String> getTags() {
		return null;
		
	}
	@Override
	public boolean isValid () {
		return (creationDate != null) && (creationDate.length() > 0 );
		
	}
      
	


}
