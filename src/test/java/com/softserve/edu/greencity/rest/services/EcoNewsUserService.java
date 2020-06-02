package com.softserve.edu.greencity.rest.services;


import com.softserve.edu.greencity.rest.data.econews.FileUploadParameters;
import com.softserve.edu.greencity.rest.data.econews.FileUploadProperties;
import com.softserve.edu.greencity.rest.data.econews.News;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.resources.econews.*;

/**
 * EcoNewsUserService class implements methods from Eco News Controller
 * which are available only for authorized user
 *
 * @author Mariana
 */
public class EcoNewsUserService extends LogginedUserService {

    protected EconewsResource ecoNewsResource;

    public EcoNewsUserService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        ecoNewsResource = new EconewsResource();
    }

    // getters

    public EconewsResource getEcoNewsResource() {
        return ecoNewsResource;
    }


    // Functional

    /**
     * Method to delete eco news by id.
     *
     * @param id
     *
     * @return int responseCode
     */
    public int deleteNews(String id) {
        RestParameters pathVariables = new RestParameters()
                .addParameter(KeyParameters.ECONEWS_ID, id);

        MethodParameters methodParameters = new MethodParameters();

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        ResponseCodeEntity responseCode = ecoNewsResource
                .httpDeleteAsEntity(methodParameters
                        .addHeaderParameters(headerParameters)
                        .addPathVariables(pathVariables));
        return responseCode.getResponsecode();
    }

    /**
     * Method to add new eco news.
     *
     * @param fileUploadProperties
     *
     * @return News
     */
    public News uploadNews(FileUploadProperties fileUploadProperties) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.IMAGE_JPEG)
                .addFormDataPartKey(KeyParameters.ECO_NEWS_DTO);
        FileUploadParameters fileUploadParameters = fileUploadProperties.getFileUploadParameters();

        RestParameters formDataPartParameters = new RestParameters()
                .addParameter(KeyParameters.IMAGE_PATH, fileUploadProperties.getNews().getImagePath())
                .addParameter(KeyParameters.SOURCE, fileUploadProperties.getNews().getSource())
                .addParameter(KeyParameters.TEXT, fileUploadProperties.getNews().getText())
                .addParameter(KeyParameters.TITLE, fileUploadProperties.getNews().getTitle());
        for (String currentTag : fileUploadProperties.getNews().getTags()) {
            formDataPartParameters.addListParameter(KeyParameters.TAGS, currentTag);
        }

        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        NewsEntity newsEntity = ecoNewsResource
                .httpPostAsEntity(methodParameters
                        .addFileUploadParameters(fileUploadParameters)
                        .addFormDataPartParameters(formDataPartParameters)
                        .addHeaderParameters(headerParameters));

        return News.converToNews(newsEntity);
    }
    // Business Logic
}
