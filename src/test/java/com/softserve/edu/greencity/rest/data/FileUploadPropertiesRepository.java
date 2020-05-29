package com.softserve.edu.greencity.rest.data;

public final class FileUploadPropertiesRepository {
	private static volatile FileUploadPropertiesRepository instance = null;

	private FileUploadPropertiesRepository() {
	}

	public static FileUploadPropertiesRepository get() {
		if (instance == null) {
			synchronized (FileUploadPropertiesRepository.class) {
				if (instance == null) {
					instance = new FileUploadPropertiesRepository();
				}
			}
		}
		return instance;
	}

	public FileUploadProperties getDefault() {
		return simpleNews();
	}
	
	public FileUploadProperties simpleNews() {
		return new FileUploadProperties(
				new News("imagePath01", "title01", "text01text01text01text01", "source01")
					.addTags("news"),
				new	FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
	}
	
}
