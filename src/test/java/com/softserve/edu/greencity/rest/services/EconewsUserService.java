package com.softserve.edu.greencity.rest.services;

import com.softserve.edu.greencity.rest.data.FileUploadParameters;
import com.softserve.edu.greencity.rest.data.FileUploadProperties;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
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
	public NewsEntity uploadNews(FileUploadProperties fileUploadProperties) {
		MethodParameters methodParameters = new MethodParameters()
    			.addContentType(ContentTypes.IMAGE_JPEG)
    			.addFormDataPartKey(KeyParameters.ECO_NEWS_DTO);
		FileUploadParameters fileUploadParameters = fileUploadProperties.getFileUploadParameters();
		RestParameters formDataPartParameters = new RestParameters()
				.addParameter(KeyParameters.IMAGE_PATH, fileUploadProperties.getNews().getImagePath())
				.addParameter(KeyParameters.SOURCE, fileUploadProperties.getNews().getSource())
				//.addListParameter(KeyParameters.TAGS, "news")
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
		return newsEntity;
	}
}
