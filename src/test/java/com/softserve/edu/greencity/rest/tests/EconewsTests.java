package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.econews.FileUploadProperties;
import com.softserve.edu.greencity.rest.data.econews.FileUploadPropertiesRepository;
import com.softserve.edu.greencity.rest.data.econews.News;
import com.softserve.edu.greencity.rest.data.econews.NewsRepository;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.econewsEntity.NewsEntity;
import com.softserve.edu.greencity.rest.services.EconewsGuestService;
import com.softserve.edu.greencity.rest.services.EconewsUserService;
import com.softserve.edu.greencity.rest.tools.VerifyUtils;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EconewsTests extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] news() {
        return new Object[][]{{"0", "5"}};
    }

    @Test(dataProvider = "news")
    public void getAllNews(String page, String size) {
        logger.info("Start getAllNews");
        EconewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();
        List<News> news = econewsGuestService.getAllNews(page, size);
        Assert.assertTrue(VerifyUtils.verifyClass(news));
        Assert.assertEquals(news.size(),Integer.parseInt(size));
        System.out.println(news.toString());

    }

    @DataProvider
    public Object[][] tags() {
        return new Object[][]{{"0", "5"}};
    }

    @Test(dataProvider = "tags")
    public void getNewsByTags(String page, String size) {
        logger.info("Start checkUserGoals");

        EconewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();

        List<String> tags = new ArrayList<>();
        tags.add("courses");
        tags.add("events");

        List<News> news = econewsGuestService.getNewsByTags(page, size, tags);

        Assert.assertTrue(VerifyUtils.verifyClass(news));
        Assert.assertEquals(news.size(),Integer.parseInt(size));
        Assert.assertTrue((news.get(0).getTags().contains("courses"))||(news.get(0).getTags().contains("events")));
    }

    @DataProvider
    public Object[][] id() {
        return new Object[][]{new Object[]{"538"}};
    }

    @Test(dataProvider = "id")
    public void getNewsById(String id) {
        logger.info("Start getNewsById(" + id + ")");

        EconewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();
        News news = econewsGuestService.getNewsById(id);

        List<News> newsList = new ArrayList<>();
        newsList.add(news);

        Assert.assertTrue(VerifyUtils.verifyClass(newsList));

    }

    @DataProvider
    public Object[][] userNews() {
        return new Object[][] {
                { UserRepository.get().temporary(),
                        FileUploadPropertiesRepository.get().simpleNews() }
        };
    }

    @Test(dataProvider = "userNews")
    public void checkUploadEconews(User user, FileUploadProperties fileUploadProperties) {
        logger.info("Start checkUploadEconews(" + user + ")");
        EconewsUserService econewsUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoEconewsUserService();
        System.out.println("logginedUserEntity = "
                + econewsUserService.getLogginedUserEntity());
        News news = econewsUserService.uploadNews(fileUploadProperties);
        System.out.println("newsEntity = "+ news.toString());
        //Assert.assertEquals(newsEntity, expectedGoals);
    }
    @DataProvider
    public Object[][] admins() {
        return new Object[][]{{UserRepository.get().getAdminUser(), "566"}};
    }

    @Test(dataProvider = "admins")
    public void deleteNews(User user, String id) {
        logger.info("Start deleteNews(" + id + ")");
        EconewsUserService econewsUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoEconewsUserService();
        System.out.println("logginedUserEntity = "
                + econewsUserService.getLogginedUserEntity());

        Assert.assertEquals(econewsUserService.deleteNews(id), 200);

        EconewsGuestService econewsGuestService = loadApplication().gotoEconewsGuestService();

       // Assert.assertNotEquals(econewsGuestService.getNewsById(id), null);
    }
}




