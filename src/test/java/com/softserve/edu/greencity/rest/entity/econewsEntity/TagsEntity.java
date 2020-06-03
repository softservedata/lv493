package com.softserve.edu.greencity.rest.entity.econewsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class contains information about tagd
 * @author lv-493
 *
 */
public class TagsEntity {

    private List<String> tags;
	private int responsecode;
   
    public TagsEntity() {
    	 tags = new ArrayList<String>();
    }
    
	public TagsEntity(List<String> tags, int responsecode) {

		this.tags = tags;
		this.responsecode = responsecode;
	}
	
	//getters
	
	public int getResponsecode() {
		return responsecode;
	}

	public List<String> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "TagsEntity [tags=" + tags + ", responsecode=" + responsecode + "]";
	}

	
	
	
    
	
    

   

   

    


}
	
	
	


