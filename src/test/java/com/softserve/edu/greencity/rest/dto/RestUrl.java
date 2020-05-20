package com.softserve.edu.greencity.rest.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestUrl {
	private Map<RestHttpMethods, List<String>> urls;

	public RestUrl() {
		initUrlKeys();
	}

	private void initUrlKeys() {
		urls = new HashMap<>();
		for (RestHttpMethods currentUrlKey : RestHttpMethods.values()) {
			urls.put(currentUrlKey, new ArrayList<String>());
		}
	}

	public Map<RestHttpMethods, List<String>> getUrls() {
		return urls;
	}
	
	public RestUrl addUrl(RestHttpMethods key, String url) {
		// urls.put(key, url);
		urls.get(key).add(url);
		return this;
	}

	public RestUrl addUrlAsFirst(RestHttpMethods key, String url) {
		urls.get(key).add(0, url);
		return this;
	}

	public RestUrl addUrlByIndex(RestHttpMethods key, String url, int index) {
		urls.get(key).add(index, url);
		return this;
	}

	public String getUrl(RestHttpMethods key) {
		// return urls.get(key).get(0);
		return getUrl(key, 0);
	}

	public String getUrl(RestHttpMethods key, int index) {
		return urls.get(key).get(index);
	}

	// add base

	public RestUrl addBaseUrl(String url) {
		// urls.put(RestUrlKeys.BASE, url);
		urls.get(RestHttpMethods.BASE).add(url);
		return this;
	}

	public RestUrl addBaseUrlByIndex(String url, int index) {
		urls.get(RestHttpMethods.BASE).add(index, url);
		return this;
	}

	public RestUrl addBaseUrlAsFirst(String url) {
		return addBaseUrlByIndex(url, 0);
	}

	// add get

	public RestUrl addGetUrl(String url) {
		// urls.put(RestUrlKeys.GET, url);
		urls.get(RestHttpMethods.GET).add(url);
		return this;
	}

	public RestUrl addGetUrlByIndex(String url, int index) {
		urls.get(RestHttpMethods.GET).add(index, url);
		return this;
	}

	public RestUrl addGetUrlAsFirst(String url) {
		return addGetUrlByIndex(url, 0);
	}

	// add post

	public RestUrl addPostUrl(String url) {
		// urls.put(RestUrlKeys.POST, url);
		urls.get(RestHttpMethods.POST).add(url);
		return this;
	}

	public RestUrl addPostUrlByIndex(String url, int index) {
		urls.get(RestHttpMethods.POST).add(index, url);
		return this;
	}

	public RestUrl addPostUrlAsFirst(String url) {
		return addPostUrlByIndex(url, 0);
	}

	// add put

	public RestUrl addPutUrl(String url) {
		// urls.put(RestUrlKeys.PUT, url);
		urls.get(RestHttpMethods.PUT).add(url);
		return this;
	}

	public RestUrl addPutUrlByIndex(String url, int index) {
		urls.get(RestHttpMethods.PUT).add(index, url);
		return this;
	}

	public RestUrl addPutUrlAsFirst(String url) {
		return addPutUrlByIndex(url, 0);
	}

	// add delete

	public RestUrl addDeleteUrl(String url) {
		// urls.put(RestUrlKeys.DELETE, url);
		urls.get(RestHttpMethods.DELETE).add(url);
		return this;
	}

	public RestUrl addDeleteUrlByIndex(String url, int index) {
		urls.get(RestHttpMethods.DELETE).add(index, url);
		return this;
	}

	public RestUrl addDeleteUrlAsFirst(String url) {
		return addDeleteUrlByIndex(url, 0);
	}

	// add patch

	public RestUrl addPatchUrl(String url) {
		// urls.put(RestUrlKeys.PATCH, url);
		urls.get(RestHttpMethods.PATCH).add(url);
		return this;
	}

	public RestUrl addPatchUrlByIndex(String url, int index) {
		urls.get(RestHttpMethods.PATCH).add(index, url);
		return this;
	}

	public RestUrl addPatchUrlAsFirst(String url) {
		return addPatchUrlByIndex(url, 0);
	}

	// read base

	public String readBaseUrl() {
		// return urls.get(RestUrlKeys.BASE);
		return readBaseUrlByIndex(0);
	}

	public String readBaseUrlByIndex(int index) {
		return urls.get(RestHttpMethods.BASE).get(index);
	}

	// read get

	public String readGetUrl() {
		// return readBaseUrl() + urls.get(RestUrlKeys.GET);
		return readGetUrlByIndex(0, 0);
	}

	public String readGetUrlByIndex(int indexGet) {
		return readGetUrlByIndex(0, indexGet);
	}

	public String readGetUrlByIndex(int indexBase, int indexGet) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestHttpMethods.GET).get(indexGet);
	}

	// read post

	public String readPostUrl() {
		// return readBaseUrl() + urls.get(RestUrlKeys.POST);
		return readPostUrlByIndex(0, 0);
	}

	public String readPostUrlByIndex(int indexGet) {
		return readPostUrlByIndex(0, indexGet);
	}
	
	public String readPostUrlByIndex(int indexBase, int indexPost) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestHttpMethods.POST).get(indexPost);
	}

	// read put

	public String readPutUrl() {
		// return readBaseUrl() + urls.get(RestUrlKeys.PUT);
		return readPutUrlByIndex(0, 0);
	}

	public String readPutUrlByIndex(int indexGet) {
		return readPutUrlByIndex(0, indexGet);
	}
	
	public String readPutUrlByIndex(int indexBase, int indexPut) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestHttpMethods.PUT).get(indexPut);
	}

	// read delete

	public String readDeleteUrl() {
		// return readBaseUrl() + urls.get(RestUrlKeys.DELETE);
		return readDeleteUrlByIndex(0, 0);
	}

	public String readDeleteUrlByIndex(int indexGet) {
		return readDeleteUrlByIndex(0, indexGet);
	}
	
	public String readDeleteUrlByIndex(int indexBase, int indexDelete) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestHttpMethods.DELETE).get(indexDelete);
	}

	// read patch

	public String readPatchUrl() {
		// return readBaseUrl() + urls.get(RestUrlKeys.PATCH);
		return readPatchUrlByIndex(0, 0);
	}

	public String readPatchUrlByIndex(int indexGet) {
		return readPatchUrlByIndex(0, indexGet);
	}
	
	public String readPatchUrlByIndex(int indexBase, int indexPatch) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestHttpMethods.PATCH).get(indexPatch);
	}

	@Override
	public String toString() {
		String result = "RestUrl [";
		for (Map.Entry<RestHttpMethods, List<String>> currentList : getUrls().entrySet()) {
			result = result + "\n Method: " + currentList.getKey().name() + " Uri: " + currentList.getValue();
		}
		return result + "]";
	}

}
