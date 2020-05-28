package com.softserve.edu.greencity.rest.services;

import java.util.List;

import com.softserve.edu.greencity.rest.data.econews.PageParameters;
import com.softserve.edu.greencity.rest.dto.ContentTypes;
import com.softserve.edu.greencity.rest.dto.KeyParameters;
import com.softserve.edu.greencity.rest.dto.MethodParameters;
import com.softserve.edu.greencity.rest.dto.RestParameters;
import com.softserve.edu.greencity.rest.entity.LogginedUserEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.entity.econewsEntity.PageEntity;
import com.softserve.edu.greencity.rest.resources.econews.NewsResource;
import com.softserve.edu.greencity.rest.resources.econews.PageResourse;
import com.softserve.edu.greencity.rest.resources.econews.TagsResurse;


public class EconewsUserService extends com.softserve.edu.greencity.rest.services.LogginedUserService {
	
	private NewsResource newsResource;
	private TagsResurse tagsResurse;
	private PageResourse pageResource;

	public  EconewsUserService (LogginedUserEntity logginedUserEntity) {
		super(logginedUserEntity);
		newsResource = new NewsResource();
		tagsResurse = new TagsResurse();
		pageResource = new PageResourse();
	}

	// getters

	public NewsResource getNewsResource() {
		return newsResource;
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
    	
    	List<NewsEntity> newsEntities = newsResource
    			.httpGetAsListEntity(methodParameters
    					.addHeaderParameters(headerParameters));
    	
    	System.out.println("***newsEntities = " + newsEntities);
//		return NewsItems.converToNewsItemsList(newsEntities);
		return newsEntities;
	}

	public List<String> getTags() {
    	MethodParameters methodParameters = new MethodParameters();
    	RestParameters headerParameters = new RestParameters()
				.addParameter(KeyParameters.ACCEPT, ContentTypes.ALL_TYPES.toString())
				.addParameter(KeyParameters.AUTHORIZATION,
						KeyParameters.BEARER.toString() + getLogginedUserEntity().getAccessToken());
    	List<String> tagsEntity = tagsResurse
    			.httpGetAsListEntity(methodParameters
    					.addHeaderParameters(headerParameters));
    					 					
		return  tagsEntity;
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

	// Business Logic

	
}
