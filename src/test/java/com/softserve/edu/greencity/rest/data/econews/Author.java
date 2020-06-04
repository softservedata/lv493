package com.softserve.edu.greencity.rest.data.econews;

import com.softserve.edu.greencity.rest.entity.econewsEntity.AuthorEntity;

/**
 *
 */
public class Author {
    private int id;
    private String name;

    public Author(){
        id = -1;
        name = "";
    }

    public Author(int id, String name) {
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


    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


