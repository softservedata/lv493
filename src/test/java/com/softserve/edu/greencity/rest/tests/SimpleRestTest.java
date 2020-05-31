package com.softserve.edu.greencity.rest.tests;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
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
        return "LoginEntity [userId=" + userId + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + ", name=" + name
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
        return "userGoals [id=" + id + ", text=" + text + ", status=" + status + "]";
    }

}

public class SimpleRestTest {

    // @Test
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
        request = new Request.Builder().url("http://localhost:8080/reset").get().build();
        response = client.newCall(request).execute();
        actual = response.body().string().replace("{\"content\":", "").replace("}", "");
        System.out.println("actual = " + actual);
        Assert.assertEquals("true", actual);
        //
        // Get tokenlifetime
        request = new Request.Builder().url("http://localhost:8080/tokenlifetime").get().build();
        response = client.newCall(request).execute();
        // System.out.println(response.body().string());
        actual = response.body().string().replace("{\"content\":", "").replace("}", "");
        System.out.println("actual = " + actual);
        Assert.assertEquals("300000", actual);
        //
        // login
        formBody = new FormBody.Builder().add("name", "admin").add("password", "qwerty")
//		  .add("token", "SG1B5Z6BQPJWLGI6WW861FV9OA719YVB")
//		  .add("time", "1900000")
                .build();
        request = new Request.Builder().url("http://localhost:8080/login").post(formBody).build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        actual = textBody.replace("{\"content\":", "").replace("}", "").replace("\"", "");
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
        formBody = new FormBody.Builder().add("token", token).add("time", "900000").build();
        request = new Request.Builder().url("http://localhost:8080/tokenlifetime").put(formBody).build();
        response = client.newCall(request).execute();
        // System.out.println(response.body().string());
        actual = response.body().string().replace("{\"content\":", "").replace("}", "");
        System.out.println("actual = " + actual);
        Assert.assertEquals("true", actual);
        //
        // logout
        formBody = new FormBody.Builder().add("name", "admin").add("token", token).build();
        request = new Request.Builder().url("http://localhost:8080/logout").post(formBody).build();
        response = client.newCall(request).execute();
        actual = response.body().string().replace("{\"content\":", "").replace("}", "").replace("\"", "");
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
        request = new Request.Builder().url("https://greencity.azurewebsites.net/ownSecurity/signIn").header("accept", "*/*")
                // .addHeader("Content-Type", "application/json")
                .post(formBody).build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        //
        System.out.println("Http Code: " + response.code());
        System.out.println("JSON = " + textBody);
        // loginEntity = gson.fromJson(textBody, LoginEntity.class);
        loginEntity = gson.fromJson(textBody, new TypeToken<LoginEntity>() {
        }.getType());
        System.out.println(loginEntity);
        //
        // Get goals of current user.
        request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/user/" + loginEntity.getUserId() + "/goals?language=en")
                .header("accept", "*/*").header("Authorization", "Bearer " + loginEntity.getAccessToken()).get().build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        //
        System.out.println("Http Code: " + response.code());
        System.out.println("JSON = " + textBody);
        //
        // Type type = new TypeToken<List<UserGoalsEntity>>(){}.getType();
        Type type = new GenericConverter<List<UserGoalsEntity>>() {
        }.getGenericType();
        String typeStr = type.toString();
        System.out.println("+++typeStr=" + typeStr);
        // Type type2 = Class.forName(typeStr, false,
        // ClassLoader.getSystemClassLoader()); // Error
        // String typeStr2 = type.toString();
        // System.out.println("+++typeStr2=" + typeStr2);
        // @SuppressWarnings("unchecked")
        // Class<List<UserGoalsEntity>> cls =
        // (Class<List<UserGoalsEntity>>)(Object)List.class;
        // Class<List<UserGoalsEntity>> cls = (Class<List<UserGoalsEntity>>) new
        // ArrayList<UserGoalsEntity>().getClass();
        // System.out.println("+++cls=" + ((Type) cls).toString());
        //
        // userGoalsEntities = gson.fromJson(textBody, new
        // TypeToken<List<UserGoalsEntity>>(){}.getType());
        userGoalsEntities = gson.fromJson(textBody, type);
        // userGoalsEntities = gson.fromJson(textBody, (Type) Class.forName(typeStr));
        System.out.println(userGoalsEntities);
    }

//    @Test
    public void checkEcoNews() throws Exception {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody;
        Request request;
        Response response;
        String textBody;
        // String token =
        // "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlcmdyZWVuQGdtYWlsLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE1OTA1ODQ1NjksImV4cCI6MTU5MDU5MTc2OX0.T4kxAY_aqQudX2R7awVBY1owKdoNQBI1qAS-VlyXw-c";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJncmVlbi5jaXR5Lm1hcmphbmFAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJpYXQiOjE1OTA1ODU2NTcsImV4cCI6MTU5MDU5Mjg1N30.rSCi1SVbHwvXgMG7A0tCwjR2uMIQd8QudmmFqRK3uuA";
        //
        /*-
        formBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "D:\\Title1.jpeg",
                        RequestBody.create(MediaType.parse("image/*"),
                                new File("D:\\Title1.jpeg")))
                .addFormDataPart("addEcoNewsDtoRequest", "{" +
                        "\"imagePath\": \"string0\"," +
                        "\"source\": \"string1\"," +
                        "\"tags\": [\"news\"]," +
                        "\"text\": \"string12345string1234500022\"," +
                        "\"title\": \"string2\"}")
                .build();
        */
        formBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("image", "@111.jpg", RequestBody.create(MediaType.parse("image/jpeg"), new File("D:\\Title1.jpeg")))
                .addFormDataPart("addEcoNewsDtoRequest", "{" + "\"imagePath\": \"string0\"," + "\"source\": \"string1\","
                        + "\"tags\": [\"news\"]," + "\"text\": \"string12345string1234500044\"," + "\"title\": \"string2\"}")
                .build();
        //
        request = new Request.Builder().url("https://greencity.azurewebsites.net/econews").header("accept", "*/*")
                .header("Authorization", "Bearer " + token)
                // .addHeader("Content-Type", "application/json")
                .post(formBody).build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        //
        System.out.println("Http Code: " + response.code());
        System.out.println("textBody = " + textBody);
    }

}
