package com.softserve.edu.greencity.rest.entity.places;



public class SpecificationEntity {
	
	 private String name;
	 
	 public SpecificationEntity() {
         this.name = "";
     }

     public SpecificationEntity(String name) {
         this.name = name;
     }

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "SpecificationEntity [name=" + name + "]";
	}
 
    

}
