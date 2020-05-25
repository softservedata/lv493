package com.softserve.edu.greencity.rest.tests;

import java.lang.reflect.Type;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.services.LogginedUserService;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Subscriber extends GreencityRestTestRunner {
 

    @DataProvider
    public Object[][] users() {
        return new Object[][] { { UserRepository.get().temporary() }, { UserRepository.get().ashot() } };
    }

    @Test(dataProvider = "users")
    public void checkLogin(User user) {
        logger.info("Start checkLogin(" + user + ")");
        LogginedUserService logginedUserService = loadApplication().successfulUserLogin(user);
        System.out.println("logginedUserEntity = " + logginedUserService.getLogginedUserEntity());
        Assert.assertEquals(logginedUserService.getLogginedUserEntity().getName(), user.getName());
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
        formBody = RequestBody.create(MediaType.parse("application/json"),
                "{\"email\":\"almyyhvxddxxnoczzt@ttirv.com\", \"password\":\"QwertY12!\"}");
        request = new Request.Builder().url("https://greencity.azurewebsites.net/ownSecurity/signIn")
                .header("accept", "*/*").post(formBody).build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        System.out.println("Http Code: " + response.code());
        System.out.println("JSON = " + textBody);
        loginEntity = gson.fromJson(textBody, new TypeToken<LoginEntity>() {
        }.getType());
        System.out.println(loginEntity);
        request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/user/" + loginEntity.getUserId() + "/goals?language=en")
                .header("accept", "*/*").header("Authorization", "Bearer " + loginEntity.getAccessToken()).get()
                .build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        System.out.println("Http Code: " + response.code());
        System.out.println("JSON = " + textBody);
        Type type = new GenericConverter<List<UserGoalsEntity>>() {
        }.getGenericType();
        String typeStr = type.toString();
        System.out.println("+++typeStr=" + typeStr);
        userGoalsEntities = gson.fromJson(textBody, type);
        System.out.println(userGoalsEntities);

    }

   // @Test
    public void Autorization() {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody;
        Request request;
        Response response;
        String textBody;
        //
        Gson gson = new Gson();
        LoginEntity loginEntity;
//        List<UserGoalsEntity> userGoalsEntities;
        formBody = RequestBody.create(MediaType.parse("application/json"),"{\"email\":\"acheuusdukwyhuhfab@ttirv.com", \"password\":\"QwertY12!\"}");
        request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/user/" + loginEntity.getUserId() + "/goals?language=en")
                .header("accept", "*/*").header("Authorization", "Bearer " + loginEntity.getAccessToken()).get()
                .build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        System.out.println("Http Code: " + response.code());
        System.out.println("JSON = " + textBody);
    }
}
