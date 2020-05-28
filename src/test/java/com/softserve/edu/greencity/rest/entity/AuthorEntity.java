package com.softserve.edu.greencity.rest.entity;

import com.softserve.edu.greencity.rest.data.Author;
import com.softserve.edu.greencity.rest.data.News;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Author convertToAuthor(AuthorEntity authorEntity) {
        return new Author(authorEntity.getId(), authorEntity.getName() );
    }
}


