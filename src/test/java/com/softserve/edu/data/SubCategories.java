package com.softserve.edu.data;

public enum SubCategories {

	PC("PC"), 
	MAC("Mac"), 
	MACS("Macs"), 
	WINDOWS("Windows"), 
	MICE_AND_TRACKBALLS("Mice and Trackballs"),
	MONITORS("Monitors"), 
	PRINTERS("Printers"), 
	SCANNERS("Scanners"), 
	WEB_CAMERAS("Web Cameras");

	private String subCategoriesName;

	private SubCategories(String categoriesName) {
		this.subCategoriesName = categoriesName;
	}

	public String getAttributeName() {
		return subCategoriesName;
	}
}
