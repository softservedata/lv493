package com.softserve.rest;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApplOkHttp {

	public static void main(String[] args) throws Exception {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				//.url("https://api.github.com/orgs/dotnet/repos")
				.url("https://api.github.com/users/nikita-pivovarov")
				.get()
				.build();
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());
	}
}
