package com.softserve.edu.greencity.rest.data.econews;

/**
 *
 */
public class NewsUploadProperties {
    private News news;
    private FileUploadParameters fileUploadParameters;

    public NewsUploadProperties(News news, FileUploadParameters fileUploadParameters) {
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
        return "NewsUploadProperties{" +
                "news=" + news +
                ", fileUploadParameters=" + fileUploadParameters +
                '}';
    }
}
