package com.softserve.edu.greencity.ui.rest.tests;
class SimpleEntity {

	private String content;

	public SimpleEntity(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "SimpleEntity [content=" + content + "]";
	}
}