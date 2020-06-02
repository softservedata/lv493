package com.softserve.edu.greencity.rest.data.econews;

/**
 *
 */
public class FileUploadProperties {
    private News news;
    private FileUploadParameters fileUploadParameters;

    public FileUploadProperties(News news, FileUploadParameters fileUploadParameters) {
        this.news = news;
        this.fileUploadParameters = fileUploadParameters;
    }

    public News getNews() {
        return news;
    }

    public FileUploadParameters getFileUploadParameters() {
        return fileUploadParameters;
    }

    @Override
    public String toString() {
        return "FileUploadProperties{" +
                "news=" + news +
                ", fileUploadParameters=" + fileUploadParameters +
                '}';
    }
}
