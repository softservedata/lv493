package com.softserve.edu.greencity.rest.dto;

public class FileUploadParameters {
	private String name;
	private String filename;
	private String filepath;

	public FileUploadParameters(String name, String filename, String filepath) {
		this.name = name;
		this.filename = filename;
		this.filepath = filepath;
	}

	public String getName() {
		return name;
	}

	public String getFilename() {
		return filename;
	}

	public String getFilepath() {
		return filepath;
	}

}
