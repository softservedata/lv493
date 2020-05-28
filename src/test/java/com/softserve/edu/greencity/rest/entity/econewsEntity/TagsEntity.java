package com.softserve.edu.greencity.rest.entity.econewsEntity;

import java.util.ArrayList;
import java.util.List;

public class TagsEntity {

    private String tag;

    public TagsEntity() {
        tag = "";
    }

    public TagsEntity(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TagsEntity [tags=" + tag + "]";
    }

}
	
	
	


