package com.softserve.edu.greencity.rest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SimpleRestTest {

	@Test
	public void checkTokenLifetime() throws Exception {
		OkHttpClient client = new OkHttpClient();
		RequestBody formBody;
		Request request;
		Response response;
		String actual;
		String token;
		//
		// Reset Application
		request = new Request.Builder()
				.url("http://localhost:8080/reset")
				.get()
				.build();
		response = client.newCall(request).execute();
		actual = response.body().string()
				.replace("{\"content\":", "").replace("}", "");
		System.out.println("actual = " + actual);
		Assert.assertEquals("true", actual);
		//
		// Get tokenlifetime
		request = new Request.Builder()
				.url("http://localhost:8080/tokenlifetime")
				.get()
				.build();
		response = client.newCall(request).execute();
		//System.out.println(response.body().string());
		actual = response.body().string()
				.replace("{\"content\":", "").replace("}", "");
		System.out.println("actual = " + actual);
		Assert.assertEquals("300000", actual);
		//
		// login
		formBody = new FormBody.Builder()
	      .add("name", "admin")
	      .add("password", "qwerty")
//		  .add("token", "SG1B5Z6BQPJWLGI6WW861FV9OA719YVB")
//		  .add("time", "1900000")
	      .build();
		request = new Request.Builder()
				.url("http://localhost:8080/login")
				.post(formBody)
				.build();
		response = client.newCall(request).execute();
		actual = response.body().string()
				.replace("{\"content\":", "")
				.replace("}", "")
				.replace("\"", "");
		System.out.println("actual = " + actual);
		Assert.assertTrue(actual.length() == 32);
		token = actual;
		//
		// Update tokenlifetime
		formBody = new FormBody.Builder()
			  .add("token", token)
			  .add("time", "900000")
		      .build();
		request = new Request.Builder()
				.url("http://localhost:8080/tokenlifetime")
				.put(formBody)
				.build();
		response = client.newCall(request).execute();
		//System.out.println(response.body().string());
		actual = response.body().string()
				.replace("{\"content\":", "").replace("}", "");
		System.out.println("actual = " + actual);
		Assert.assertEquals("true", actual);
		//
		// logout
		formBody = new FormBody.Builder()
		        .add("name", "admin")
		        .add("token", token)
		        .build();
		request = new Request.Builder()
				.url("http://localhost:8080/logout")
				.post(formBody)
				.build();
		response = client.newCall(request).execute();
		actual = response.body().string()
				.replace("{\"content\":", "")
				.replace("}", "")
				.replace("\"", "");
		System.out.println("actual = " + actual);
		Assert.assertEquals("true", actual);
		//
	}
}
