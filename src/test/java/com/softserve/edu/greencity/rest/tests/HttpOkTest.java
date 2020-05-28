package com.softserve.edu.greencity.rest.tests;

import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class HttpOkTest {
    public String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJncmVlbi5jaXR5Lm1hcmphbmFAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJpYXQiOjE1OTA1MDcyNDAsImV4cCI6MTU5MDUxNDQ0MH0.wzx25Qyq8sI3U0LsWuDxQXuQoulmxlslYDMHGuicp60";

    @Test
    public void CreateNewsTest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", "C:\\Users\\mJana\\Documents\\GitHub\\lv493\\src\\test\\resources\\ecobag.jpg",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("C:/Users/mJana/Desktop/valid.png")))
                .addFormDataPart("addEcoNewsDtoRequest", "{" +
                        "\"imagePath\": \"\"," +
                        "\"source\": \"\"," +
                        "\"tags\": [\"news\"]," +
                        "\"text\": \"Text test HTTPOK\"," +
                        "\"title\": \"Test Test title title 18\"}")
                .build();
        Request request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/econews")
                .method("POST", body)
                .addHeader("Authorization", token)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.toString());
    }

    @Test
    public void deleteNewsTest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, "{}");
        Request request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/econews/380")
                .method("DELETE", body)
                .addHeader("Authorization", token)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertEquals(response.body().string(), "");
        System.out.println(response.body().string());
    }
}
