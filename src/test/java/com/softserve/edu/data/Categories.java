/**
 * 
 */
package com.softserve.edu.data;

/**
 * @author Kristina
 *
 */
public enum Categories {
	
	ALL_CATEGORIES( "All Categories"),
	DESCTOPS ("Desktops"),
	LAPTOPS_AND_NOTEBOOKS ("Laptops &amp; Notebooks"),
	COMPONENTS("Components"), 
	TABLETS("Tablets"),
	SOFTWARE("Software"),
	PHONES("Phones &amp; PDAs"),
	CAMERAS("Cameras"),
	MP3_PLAYERS("MP3 Players");
                                               
	private String categoriesName;

	private Categories(String categoriesName) {
		this.categoriesName = categoriesName;
	}

	public String getCategorieseName() {
		return categoriesName;
	}


	
}
