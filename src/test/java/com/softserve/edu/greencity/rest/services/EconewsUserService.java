package com.softserve.edu.greencity.rest.services;


import com.softserve.edu.greencity.rest.data.econews.FileUploadParameters;
import com.softserve.edu.greencity.rest.data.econews.FileUploadProperties;
import com.softserve.edu.greencity.rest.data.econews.News;
import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.PageEntity;
import com.softserve.edu.greencity.rest.resources.econews.*;

import java.util.List;

/**
 * EconewsUserService class implements methods from Eco News Controller
 * which are available only for authorized user
 */
public class EconewsUserService extends LogginedUserService {

    private NewestNewsResource newestNewsResource;
    private TagsResurse tagsResurse;
    private PageResourse pageResource;
    protected EconewsResource econewsResource;
    protected EconewsTagsResource econewsTagsResource;
    private News currentNews = new News();

    public EconewsUserService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        newestNewsResource = new NewestNewsResource();
        tagsResurse = new TagsResurse();
        pageResource = new PageResourse();
        econewsResource = new EconewsResource();
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

    //	public List<NewsItems> getNewsEntity() {
    public List<NewsEntity> getNewsEntity() {
        MethodParameters methodParameters = new MethodParameters();
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());

        List<NewsEntity> newsEntities = newestNewsResource
                .httpGetAsListEntity(methodParameters
                        .addHeaderParameters(headerParameters));

        System.out.println("***newsEntities = " + newsEntities);
//		return NewsItems.converToNewsItemsList(newsEntities);
        return newsEntities;
    }

    public String getTags() {
        MethodParameters methodParameters = new MethodParameters();
        RestParameters headerParameters = new RestParameters()
                .addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
                .addParameter(KeyParameters.AUTHORIZATION,
                        KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
        String tagsEntity = tagsResurse
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
        //   			.httpGetAsListEntity(methodParameters
        //   					.addHeaderParameters(headerParameters));
        System.out.println("***pageEntity = " + pageEntity);
//		return NewsItems.converToNewsItemsList(newsEntities);
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
        ResponseCodeEntity responseCode = econewsResource
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
        NewsEntity newsEntity = econewsResource
                .httpPostAsEntity(methodParameters
                        .addFileUploadParameters(fileUploadParameters)
                        .addFormDataPartParameters(formDataPartParameters)
                        .addHeaderParameters(headerParameters));
        currentNews.setId(newsEntity.getId());
        System.out.println("id in create news"+currentNews.getId());
        return News.converToNews(newsEntity);
    }
    // Business Logic
}
