package com.softserve.edu.greencity.rest.entity;

import java.util.List;

public class BaseEntity {
	private List<String> base;

	public BaseEntity(List<String> base) {
		this.base = base;
	}

	public List<String> getBase() {
		return base;
	}

	@Override
	public String toString() {
		return "BaseEntity [base=" + base + "]";
	}

}
