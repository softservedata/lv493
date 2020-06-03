package com.softserve.edu.greencity.rest.entity;

public class AdvicesRandomEntity {
    private String language;
    private int id;
    private String code;
    private String content;

    public AdvicesRandomEntity() {
        language = "";
        id = -1;
        code = "";
        content = "";
    }
    
    public AdvicesRandomEntity(String language, int id, String code, String content) {
        this.language = language;
        this.id = id;
        this.code = code;
        this.content = content;
    }
    
    public String getlanguage(){
        return language;
    }
    
    public int getId() {
        return id;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getContent() {
        return content;
    }
    
    @Override
    public String toString() {
        return "AdviceRandomEntity [ language= " + language + "id= " + id
                + "code= " + code + "content= " + content + "]";
    }
}
