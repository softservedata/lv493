package com.softserve.edu.greencity.rest.services;


import com.softserve.edu.greencity.rest.data.econews.*;
import com.softserve.edu.greencity.rest.data.econews.FileUploadParameters;
import com.softserve.edu.greencity.rest.dto.*;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.PageEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.TagsEntity;
import com.softserve.edu.greencity.rest.resources.econews.*;

import java.util.List;

/**
 * EcoNewsUserService class implements methods from Eco News Controller
 * which are available only for authorized user
 *
 */
public class EcoNewsUserService extends LogginedUserService {

    private NewestNewsResource newestNewsResource;
    private TagsResurse tagsResurse;
    private PageResourse pageResource;
    protected EconewsResource ecoNewsResource;
    protected EconewsTagsResource econewsTagsResource;

    public EcoNewsUserService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        newestNewsResource = new NewestNewsResource();
        tagsResurse = new TagsResurse();
        pageResource = new PageResourse();
        ecoNewsResource = new EconewsResource();
        econewsTagsResource = new EconewsTagsResource();
    }

    // getters

    public NewestNewsResource getNewestNewsResource() {
        return newestNewsResource;
    }

    public TagsResurse gettagsResurse() {
        return tagsResurse;
    }

    public PageResourse getPageResource() {
        return pageResource;
    }

    // Functionals

    public List<NewsEntity> getNewsEntity() {
        MethodParameters methodParameters = new MethodParameters();
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

        List<NewsEntity> newsEntities = newestNewsResource
                .httpGetAsListEntity(methodParameters
                        .addHeaderParameters(headerParameters));

        return newsEntities;
    }
    
    public TagsEntity getTags() {
        MethodParameters methodParameters = new MethodParameters();
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        TagsEntity tagsEntity = tagsResurse
                .httpGetAsEntity(methodParameters
                        .addHeaderParameters(headerParameters));

        return tagsEntity;
    }

    public PageEntity getPageEntity(PageParameters pageParameters) {
        MethodParameters methodParameters = new MethodParameters();
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.PAGE, pageParameters.getPage())
                .addParameter(KeyParameters.SIZE, pageParameters.getSize());
        PageEntity pageEntity = pageResource
                .httpGetAsEntity(methodParameters
                        .addUrlParameters(urlParameters)
                        .addHeaderParameters(headerParameters));
       
        return pageEntity;
    }


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
     * @param newsUploadProperties
     *
     * @return News
     */
    public News uploadNews(NewsUploadProperties newsUploadProperties) {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.IMAGE_JPEG)
                .addFormDataPartKey(KeyParameters.ECO_NEWS_DTO);
        FileUploadParameters fileUploadParameters = newsUploadProperties.getFileUploadParameters();

        RestParameters formDataPartParameters = new RestParameters()
                .addParameter(KeyParameters.IMAGE_PATH, newsUploadProperties.getNews().getImagePath())
                .addParameter(KeyParameters.SOURCE, newsUploadProperties.getNews().getSource())
                .addParameter(KeyParameters.TEXT, newsUploadProperties.getNews().getText())
                .addParameter(KeyParameters.TITLE, newsUploadProperties.getNews().getTitle());

        for (String currentTag : newsUploadProperties.getNews().getTags()) {
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

        NewsIdRepository.get().addNewsId(newsEntity.getId());

        return News.convertToNews(newsEntity);
    }
    // Business Logic

    

}
