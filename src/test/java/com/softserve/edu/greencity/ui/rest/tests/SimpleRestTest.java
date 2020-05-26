package com.softserve.edu.greencity.ui.rest.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SimpleRestTest {

    @Test
    public void checkSwaggerGreenCity() throws Exception {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody;
        Request request;
        Response response;
        String actual;
        String email = "sergii.taqc@gmail.com";
        String password = "A475asd123*";
        String userID = "430";
        String token;
        String text;
        Pattern pattern;
        Matcher matcher;
        List<String> list = new ArrayList<>();
        //
        // login
        formBody = RequestBody.create(MediaType
                .parse("application/json"), "{ \"email\": \"cvtslchenwwhqhqxhx@awdrt.net\", \"password\": \"A475asd123*\"}");
        System.out.println("formBody.toString(): " + formBody.toString());
            request = new Request.Builder()
//                .url("https://greencity.azurewebsites.net/ownSecurity/signIn")
                .url("http://192.168.0.103:8080/ownSecurity/signIn")
                .header("accept", "*/*")
//                .header("Content-Type", "application/json")
                .post(formBody)
                .build();
        System.out.println("request.toString(): " + request.toString());
        response = client.newCall(request).execute();
        System.out.println("response.body().string()" + response.body().string());
//        actual = response.body().string()
//                .replace("{\"content\":", "")
//                .replace("}", "")
//                .replace("\"", "");
//        System.out.println("actual = " + actual);
////        Assert.assertTrue(actual.length() == 32);
//        token = actual;
//        token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZXJnaWkudGFxY0BnbWFpbC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNTg5NzI2NzkyLCJleHAiOjE1ODk3MzM5OTJ9.PfuZxsjGDgFM_KlFx4fnyuPrKdOhXbq1c7xw6U-GY44";
//        //
//        // Get category
//        request = new Request.Builder()
//                .url("https://greencity.azurewebsites.net/category").get()
//                .build();
//        response = client.newCall(request).execute();
//        // System.out.println(response.body().string());
//        actual = response.body().string().replace("[{\"name\":\"", "")
//                .replace("\"}]", "");
//        System.out.println("actual = " + actual);
//        Assert.assertEquals(actual, "Food");
//        //
//        // Get findAllSpecification
//        request = new Request.Builder()
//                .url("https://greencity.azurewebsites.net/specification").get()
//                .build();
//        response = client.newCall(request).execute();
//        // [{\"name\":\"Animal\"},{\"name\":\"Own
//        // cup\"},{\"name\":\"Karaoke\"},{\"name\":\"Shopping\"},{\"name\":\"Ukrainian
//        // food\"},{\"name\":\"Dance\"}]
//        text = response.body().string().trim();
//        pattern = Pattern.compile(":\\\"(.+?)\"\\}");
//        matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            list.add(matcher.group(1));
//        }
//        System.out.println(list.toString());
//        //
//        Assert.assertEquals(list.get(0), "Animal");
//        Assert.assertEquals(list.get(1), "Own cup");
//        Assert.assertEquals(list.get(2), "Karaoke");
//        Assert.assertEquals(list.get(3), "Shopping");
//        Assert.assertEquals(list.get(4), "Ukrainian food");
//        Assert.assertEquals(list.get(5), "Dance");
//        //
//        // Get findAllSpecification
//        request = new Request.Builder().url(
//                "https://greencity.azurewebsites.net/user/emailNotifications")
//                .get().build();
//        response = client.newCall(request).execute();
//        // ["DISABLED","IMMEDIATELY","DAILY","WEEKLY","MONTHLY"]
//        text = response.body().string().trim();
//        pattern = Pattern.compile("\"(.+?)\"");
//        matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            list.add(matcher.group(1));
//        }
//        System.out.println(list.toString());
//        //
//        Assert.assertEquals(list.get(0), "DISABLED");
//        Assert.assertEquals(list.get(1), "IMMEDIATELY");
//        Assert.assertEquals(list.get(2), "DAILY");
//        Assert.assertEquals(list.get(3), "WEEKLY");
//        Assert.assertEquals(list.get(4), "MONTHLY");
//        //
//        // Get User dto by principal (email) from access token
//        formBody = new FormBody.Builder()
//                .add("token", token)
//                .build();
//        request = new Request.Builder()
//                .url("https://greencity.azurewebsites.net/user")
//                .header("accept", "*/*")
//                .header("Authorization", token)
//                .build();
//        System.out.println("request.toString(): " + request.toString());
//        response = client.newCall(request).execute();
//        System.out.println(response.body().string());
//        //
////        actual = response.body().string().replace("[{\"name\":\"", "")
////                .replace("\"}]", "");
////        System.out.println("actual = " + actual);
////        Assert.assertEquals(actual, "Food");
//        //
//     // Get goals of current user.
//        formBody = new FormBody.Builder()
//                .add("token", token)
//                .build();
//        request = new Request.Builder()
//                .url("https://greencity.azurewebsites.net/user/" + userID + "/goals?language=en")
//                .header("accept", "*/*")
//                .header("Authorization", token)
//                .build();
//        System.out.println("request.toString(): " + request.toString());
//        response = client.newCall(request).execute();
//        System.out.println(response.body().string());
        //
        // Get available goals for current user.
//        formBody = new FormBody.Builder().add("token", token).build();
//        request = new Request.Builder()
//                .url("https://greencity.azurewebsites.net/user/" + userID
//                        + "/goals/available?language=en")
//                .header("accept", "*/*").header("Authorization", token).build();
//        System.out.println("request.toString(): " + request.toString());
//        response = client.newCall(request).execute();
//        System.out.println(response.body().string());
        // [{"id":2,"text":"Buy composter"},{"id":3,"text":"Start sorting
        // trash"},{"id":4,"text":"Start recycling
        // batteries"},{"id":5,"text":"Finish book about
        // vegans"},{"id":1,"text":"Buy a bamboo toothbrush"}]
//        text = response.body().string().trim();
//        pattern = Pattern.compile("{(.+?)}");
//        matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            list.add(matcher.group(1));
//        }
//        System.out.println(list.toString());
        //
    }
}