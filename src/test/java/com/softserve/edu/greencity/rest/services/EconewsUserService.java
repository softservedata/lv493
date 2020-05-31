package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.FileUploadParameters;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.NewsEntity;
import com.softserve.edu.greencity.rest.resources.EconewsResource;

public class EconewsUserService extends LogginedUserService {
    private EconewsResource econewsResource;

    public EconewsUserService(LogginedUserEntity logginedUserEntity) {
        super(logginedUserEntity);
        econewsResource = new EconewsResource();
    }
    
    // TODO
    public NewsEntity uploadNews() {
        MethodParameters methodParameters = new MethodParameters()
                .addContentType(ContentTypes.IMAGE_JPEG)
                .addFormDataPartKey(KeyParameters.ECO_NEWS_DTO);
        FileUploadParameters fileUploadParameters = new FileUploadParameters("image", "@111.jpg", "D:\\Title1.jpeg");
        RestParameters formDataPartParameters = new RestParameters()
                .addParameter(KeyParameters.IMAGE_PATH, "string0")
                .addParameter(KeyParameters.SOURCE, "string1")
                .addParameter(KeyParameters.TAGS, "news")
                .addParameter(KeyParameters.TEXT, "string12345string1234500044")
                .addParameter(KeyParameters.TITLE, "string2");
        NewsEntity newsEntity = econewsResource
                .httpPostAsEntity(methodParameters
                        .addFileUploadParameters(fileUploadParameters)
                        .addFormDataPartParameters(formDataPartParameters));
        return newsEntity;
    }
}