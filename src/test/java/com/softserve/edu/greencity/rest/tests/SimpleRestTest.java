package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class SimpleEntity {

	private String content;

	public SimpleEntity(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "SimpleEntity [content=" + content + "]";
	}
}

class LoginEntity {

	private int userId;
	private String accessToken;
	private String refreshToken;
	private String name;
	private boolean ownRegistrations;
	
	public LoginEntity(int userId, String accessToken, String refreshToken, String name, boolean ownRegistrations) {
		this.userId = userId;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.name = name;
		this.ownRegistrations = ownRegistrations;
	}

	public int getUserId() {
		return userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public String getName() {
		return name;
	}

	public boolean isOwnRegistrations() {
		return ownRegistrations;
	}

	@Override
	public String toString() {
		return "LoginEntity [userId=" + userId
				+ ", accessToken=" + accessToken
				+ ", refreshToken=" + refreshToken
				+ ", name=" + name
				+ ", ownRegistrations=" + ownRegistrations + "]";
	}
}

class UserGoalsEntity {
	public int id;
	public String text;
	public String status;
	
	public UserGoalsEntity() {
		id = 0;
		text = "";
		status = "";
	}
	
	public UserGoalsEntity(int id, String text, String status) {
		this.id = id;
		this.text = text;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "userGoals [id=" + id
				+ ", text=" + text
				+ ", status=" + status + "]";
	}
	
}


public class SimpleRestTest {

	//@Test
	public void checkTokenLifetime() throws Exception {
		OkHttpClient client = new OkHttpClient();
		RequestBody formBody;
		Request request;
		Response response;
		String actual;
		String token;
		String textBody;
		//
		Gson gson = new Gson();
		SimpleEntity simpleEntity;
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
		textBody = response.body().string();
		actual = textBody
				.replace("{\"content\":", "")
				.replace("}", "")
				.replace("\"", "");
		System.out.println("actual = " + actual);
		Assert.assertTrue(actual.length() == 32);
		token = actual;
		//
		System.out.println("JSON = " + textBody);
		simpleEntity = gson.fromJson(textBody, SimpleEntity.class);
		System.out.println(simpleEntity);
		token = simpleEntity.getContent();
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
	
	@Test
	public void checkLoginGreenCity() throws Exception {
		OkHttpClient client = new OkHttpClient();
		RequestBody formBody;
		Request request;
		Response response;
		String textBody;
		//
		Gson gson = new Gson();
		LoginEntity loginEntity;
		List<UserGoalsEntity> userGoalsEntities;
		//
		//
		// login
		formBody = RequestBody.create(MediaType.parse("application/json"),
				"{\"email\":\"xdknxusqvjeovowpfk@awdrt.com\", \"password\":\"Temp#001\"}");
//		formBody = new FormBody.Builder()
//				.add("email", "xdknxusqvjeovowpfk@awdrt.com")
//				.add("password", "Temp#001")
//				.build();
		request = new Request.Builder()
				.url("https://greencity.azurewebsites.net/ownSecurity/signIn")
				.header("accept", "*/*")
				//.addHeader("Content-Type", "application/json")
				.post(formBody)
				.build();
		response = client.newCall(request).execute();
		textBody = response.body().string();
		//
		System.out.println("Http Code: " + response.code());
		System.out.println("JSON = " + textBody);
		//loginEntity = gson.fromJson(textBody, LoginEntity.class);
		loginEntity = gson.fromJson(textBody, new TypeToken<LoginEntity>(){}.getType());
		System.out.println(loginEntity);
		//
		// Get goals of current user.
		request = new Request.Builder()
				.url("https://greencity.azurewebsites.net/user/" + loginEntity.getUserId() + "/goals?language=en")
				.header("accept", "*/*")
				.header("Authorization", "Bearer " + loginEntity.getAccessToken())
				.get()
				.build();
		response = client.newCall(request).execute();
		textBody = response.body().string();
		//
		System.out.println("Http Code: " + response.code());
		System.out.println("JSON = " + textBody);
		userGoalsEntities = gson.fromJson(textBody, new TypeToken<List<UserGoalsEntity>>(){}.getType());
		System.out.println(userGoalsEntities);
	}
}
