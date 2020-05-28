package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.econews.News;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.PageEntity;
import com.softserve.edu.greencity.rest.resources.econews.EconewsResource;
import com.softserve.edu.greencity.rest.resources.econews.EconewsTagsResource;
import com.softserve.edu.greencity.rest.resources.econews.NewsByIdResource;

import java.util.List;
import java.util.stream.Collectors;

public class EconewsGuestService extends GuestService {
    protected EconewsResource econewsResource;
    protected EconewsTagsResource econewsTagsResource;
    protected NewsByIdResource newsByIdResource;

    public EconewsGuestService() {
        super();
        econewsResource = new EconewsResource();
        econewsTagsResource = new EconewsTagsResource();
        newsByIdResource = new NewsByIdResource();
    }

    public EconewsResource getEconewsResource() {
        return econewsResource;
    }

    public EconewsTagsResource getEconewsTagsResource() {
        return econewsTagsResource;
    }

    public NewsByIdResource getNewsByIdResource() {
        return newsByIdResource;
    }

    public List<News> getAllNews(String page, String size) { // available for guest
        MethodParameters methodParameters = new MethodParameters();

        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.ID, "");

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        RestParameters urlParameter = new RestParameters()
                .addParameter(KeyParameters.PAGE, page)
                .addParameter(KeyParameters.SIZE, size);
        PageEntity newsResponse = econewsResource
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addUrlParameters(urlParameter)
                        .addPathVariables(pathVariables));
        return News.converToNewsList(newsResponse.getPage());
    }

    public List<News> getNewsByTags(String page, String size, List<String> tags) { // available for guest
        MethodParameters methodParameters = new MethodParameters();

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());

        RestParameters urlParameter = new RestParameters()
                .addParameter(KeyParameters.PAGE, page)
                .addParameter(KeyParameters.SIZE, size)
                .addParameter(KeyParameters.TAGS, tags.stream().collect(Collectors.joining(",")));

        System.out.println(urlParameter.getParameter(KeyParameters.TAGS));

        PageEntity newsResponse = econewsTagsResource
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addUrlParameters(urlParameter));
        return News.converToNewsList(newsResponse.getPage());
    }


    public News getNewsById(String id) { // available for guest
        MethodParameters methodParameters = new MethodParameters();

        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.ID, id);

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());

        NewsEntity news = newsByIdResource
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addPathVariables(pathVariables));
        return News.converToNews(news);
    }
}
