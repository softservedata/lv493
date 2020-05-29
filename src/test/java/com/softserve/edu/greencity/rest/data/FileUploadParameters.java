package com.softserve.edu.greencity.rest.data;

public class FileUploadParameters {
	private String name;
	private String filename;
	private String filepath;

	public FileUploadParameters(String name, String filename, String filepath) {
		this.name = name;
		this.filename = filename;
		if (filepath.contains("/") || filepath.contains("\\")) {
			this.filepath = filepath;
		} else {
			this.filepath = FileUploadParameters.class.getResource("/" + filepath).getPath();
		}
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
