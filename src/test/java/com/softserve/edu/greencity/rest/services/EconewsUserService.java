package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.News;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.resources.EconewsResource;
import com.softserve.edu.greencity.rest.resources.EconewsTagsResource;
import com.softserve.edu.greencity.rest.resources.NewestNewsResource;

public class EconewsUserService extends LogginedUserService {
    protected EconewsResource econewsResource;
    protected NewestNewsResource newestNewsResource;
    protected EconewsTagsResource econewsTagsResource;

    public EconewsUserService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        econewsResource = new EconewsResource();
        newestNewsResource = new NewestNewsResource();
        econewsTagsResource = new EconewsTagsResource();
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


    public int deleteNews(String id) { // available only for admin
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.ECONEWS_ID, id);

        MethodParameters methodParameters = new MethodParameters();

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        ResponseCodeEntity responseCode = econewsResource
                .httpDeleteAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addPathVariables(pathVariables));
        return responseCode.getResponsecode();
    }

    public int createNews(News news) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.MULTIPART_FORM_DATA);

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken())
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString());

        RestParameters mediaTypeParameters = new RestParameters()
                .addParameter(KeyParameters.TYPE, "image/jpeg")
                .addParameter(KeyParameters.ADD_ECONEWS_DTO_REQUEST, "{\"tags\": [\"news\"], \"text\": \"Text test\", \"title\": \"Test title 25\"}")
                .addParameter(KeyParameters.FILE, news.getImagePath())
                .addParameter(KeyParameters.MEDIA_TYPE, "application/octet-stream");

        ResponseCodeEntity econewsService = econewsResource
                .httpPostAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addMediaTypeParameters(mediaTypeParameters));
        return econewsService.getResponsecode();
    }
}
