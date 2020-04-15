package com.softserve.edu.opencart.data;

public enum Currencies {
	EURO("Euro", "EUR"),
	POUND_STERLING("Pound Sterling", "GBP"),
	US_DOLLAR("US Dollar", "USD");

	//
	private String name;
	private String attributeName;

	private Currencies(String name, String attributeName) {
		this.name = name;
		this.attributeName = attributeName;
	}

	public String getAttributeName() {
		return attributeName;
	}

	@Override
	public String toString() {
		return name;
	}

}
