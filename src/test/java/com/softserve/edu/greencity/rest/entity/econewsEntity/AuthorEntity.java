package com.softserve.edu.greencity.rest.entity.econewsEntity;

import com.softserve.edu.greencity.rest.data.econews.Author;

public class AuthorEntity {
	
	private int id;
    private String name;
    private String email;   // added 

	public AuthorEntity(){
		id = -1;
		name = "";
	}

    public AuthorEntity(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public AuthorEntity(int id, String name, String email) { //new
		
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}
    
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "AuthorEntity [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public static Author convertToAuthor(AuthorEntity authorEntity) {
		return new Author(authorEntity.getId(), authorEntity.getName() );
	}
    

}
