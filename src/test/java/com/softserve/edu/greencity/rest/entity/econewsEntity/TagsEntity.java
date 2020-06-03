package com.softserve.edu.greencity.rest.entity.econewsEntity;

import java.util.ArrayList;
import java.util.List;

public class TagsEntity {

    private List<String> tags;
   
    public TagsEntity() {
    	 tags = new ArrayList<String>();
    }

	/*
	 * public TagsEntity(List<String> tags) { this.tags = tags; }
	 */
	
    
	public TagsEntity(String... tag) {
		for(String current :  tag)  {
		tags.add(current);
		}
	}

	public List<String> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "TagsEntity [tags=" + tags.toString() + "]";
	}

	
	
    
	
    

   

   

    


}
	
	
	


