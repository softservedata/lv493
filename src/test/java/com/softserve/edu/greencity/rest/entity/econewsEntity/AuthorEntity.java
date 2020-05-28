package com.softserve.edu.greencity.rest.entity.econewsEntity;

import com.softserve.edu.greencity.rest.data.econews.Author;

public class AuthorEntity {
	
	private int id;
    private String name;

	public AuthorEntity(){
		id = -1;
		name = "";
	}

    public AuthorEntity(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
    
	public String getName() {
		return name;
	}

	public static Author convertToAuthor(AuthorEntity authorEntity) {
		return new Author(authorEntity.getId(), authorEntity.getName() );
	}
    

}
