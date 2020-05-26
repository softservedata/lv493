package com.softserve.edu.greencity.rest.entity.econewsEntity;

public class AuthorEntity {
	
	private int id;
    private String name;
	
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
   
    

}
