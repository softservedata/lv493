package com.softserve.edu.greencity.rest.entity;

public class CategoryEntity {

    private String name;

    public CategoryEntity() {
        this.name = "";
    }
    public CategoryEntity(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "CategoryEntity [name=" + name + "]";
    }
    
}
