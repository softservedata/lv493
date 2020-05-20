package com.softserve.edu.greencity.rest.dto;

public class MethodParameters {
	private RestParameters pathVariables;
	private RestParameters urlParameters;
	private RestParameters bodyParameters;
	private RestParameters mediaTypeParameters;
	private RestParameters headerParameters;
	private ContentTypes contentType;
	private int index;

	public MethodParameters() {
		pathVariables = null;
		urlParameters = null;
		bodyParameters = null;
		mediaTypeParameters = null;
		headerParameters = null;
		contentType = null;
		index = 0;
	}

	// setters
	
	public MethodParameters addPathVariables(RestParameters pathVariables) {
		this.pathVariables = pathVariables;
		return this;
	}

	public MethodParameters addUrlParameters(RestParameters urlParameters) {
		this.urlParameters = urlParameters;
		return this;
	}

	public MethodParameters addBodyParameters(RestParameters bodyParameters) {
		this.bodyParameters = bodyParameters;
		return this;
	}

	public MethodParameters addMediaTypeParameters(RestParameters mediaTypeParameters) {
		this.mediaTypeParameters = mediaTypeParameters;
		return this;
	}

	public MethodParameters addHeaderParameters(RestParameters headerParameters) {
		this.headerParameters = headerParameters;
		return this;
	}

	public MethodParameters addContentType(ContentTypes contentType) {
		this.contentType = contentType;
		return this;
	}

	public MethodParameters setIndex(int index) {
		this.index = index;
		return this;
	}
	
	// getters
	
	public RestParameters getPathVariables() {
		return pathVariables;
	}

	public RestParameters getUrlParameters() {
		return urlParameters;
	}

	public RestParameters getBodyParameters() {
		return bodyParameters;
	}

	public RestParameters getMediaTypeParameters() {
		return mediaTypeParameters;
	}

	public RestParameters getHeaderParameters() {
		return headerParameters;
	}

	public ContentTypes getContentType() {
		return contentType;
	}

	public int getIndex() {
		return index;
	}
	
}
