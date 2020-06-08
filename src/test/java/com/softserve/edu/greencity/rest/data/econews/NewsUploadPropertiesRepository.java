package com.softserve.edu.greencity.rest.data.econews;

public final class NewsUploadPropertiesRepository {
    private static volatile NewsUploadPropertiesRepository instance = null;

    private NewsUploadPropertiesRepository() {
    }

    public static NewsUploadPropertiesRepository get() {
        if (instance == null) {
            synchronized (NewsUploadPropertiesRepository.class) {
                if (instance == null) {
                    instance = new NewsUploadPropertiesRepository();
                }
            }
        }
        return instance;
    }

    public NewsUploadProperties getDefault() {
        return intermediateSymbolsNews();
    }

    // valid data for positive tests
    public NewsUploadProperties maxSymbolsNews() {
        return new NewsUploadProperties(
                NewsRepository.get().getMaxSymbolsNews(),
                new FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
    }

    public NewsUploadProperties intermediateSymbolsNews() {
        return new NewsUploadProperties(
                NewsRepository.get().getIntermediateSymbolsNews(),
                new FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
    }

    public NewsUploadProperties minSymbolsNews() {
        return new NewsUploadProperties(
                NewsRepository.get().minSymbolsNews(),
                new FileUploadParameters("image", "@111.jpg", "middleSize.jpg"));
    }

    // invalid data for negative tests
    public NewsUploadProperties emptyNews() {
        return new NewsUploadProperties(
                new News(),
                new FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
    }

    public NewsUploadProperties titleSizeInvalidOfNews() {
        return new NewsUploadProperties(
                NewsRepository.get().getTitleSizeInvalidOfNews(),
                new FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
    }

    public NewsUploadProperties emptyTagsOfNews() {
        return new NewsUploadProperties(
                NewsRepository.get().getEmptyTagsNews(),
                new FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
    }

    public NewsUploadProperties tooManyTagsOfNews() {
        return new NewsUploadProperties(
                NewsRepository.get().getTooManyTagsNews(),
                new FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
    }

    public NewsUploadProperties emptyTitleOfNews() {
        return new NewsUploadProperties(
                NewsRepository.get().getEmptyTitleNews(),
                new FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
    }

    public NewsUploadProperties emptyTextOfNews() {
        return new NewsUploadProperties(
                NewsRepository.get().getEmptyTextNews(),
                new FileUploadParameters("image", "@111.jpg", "simpleNews.jpeg"));
    }
}
