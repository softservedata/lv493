package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.News;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.AllNewsResponseEntity;
import com.softserve.edu.greencity.rest.entity.EcoNewsEntity;
import com.softserve.edu.greencity.rest.resources.EconewsResource;
import com.softserve.edu.greencity.rest.resources.EconewsTagsResource;
import com.softserve.edu.greencity.rest.resources.NewestNewsResource;
import com.softserve.edu.greencity.rest.resources.NewsByIdResource;

import java.util.List;
import java.util.stream.Collectors;

public class EconewsGuestService extends GuestService {
    protected EconewsResource econewsResource;
    protected NewestNewsResource newestNewsResource;
    protected EconewsTagsResource econewsTagsResource;
    protected NewsByIdResource newsByIdResource;

    public EconewsGuestService() {
        super();
        econewsResource = new EconewsResource();
        newestNewsResource = new NewestNewsResource();
        econewsTagsResource = new EconewsTagsResource();
        newsByIdResource = new NewsByIdResource();
    }

    public EconewsResource getEconewsResource() {
        return econewsResource;
    }

    public NewestNewsResource getNewestNewsResource() {
        return newestNewsResource;
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
        AllNewsResponseEntity newsResponse = econewsResource
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addUrlParameters(urlParameter)
                        .addPathVariables(pathVariables));
        return News.converToNewsList(newsResponse.getPage());
    }

    public List<News> getNewestNews() { // available for guest
        MethodParameters methodParameters = new MethodParameters();
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());
        List<EcoNewsEntity> newsList = newestNewsResource
                .httpGetAsListEntity(methodParameters
                        .addHeaderParameters(headerParameters));
        return News.converToNewsList(newsList);
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

        AllNewsResponseEntity newsResponse = econewsTagsResource
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

        EcoNewsEntity news = newsByIdResource
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addPathVariables(pathVariables));
        return News.converToNews(news);
    }
}
