package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.News;
import com.softserve.edu.greencity.rest.data.NewsRepository;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.services.EconewsGuestService;
import com.softserve.edu.greencity.rest.services.EconewsUserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        System.out.println(news.toString());

    }

    @Test
    public void getNewestNews() {
        logger.info("Start getNewestNews");
        EconewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();
        List<News> news = econewsGuestService.getNewestNews();
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

        System.out.println(news.toString());

    }

    @DataProvider
    public Object[][] id() {
        return new Object[][]{new Object[]{"491"}};
    }

    @Test(dataProvider = "id")
    public void getNewsById(String id) {
        logger.info("Start getNewsById(" + id + ")");

        EconewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();

        System.out.println(econewsGuestService.getNewsById(id));

    }

    @DataProvider
    public Object[][] newsData() {
        return new Object[][]{{UserRepository.get().getAdminUser(), NewsRepository.get().getDefault()}};
    }

    @Test(dataProvider = "newsData")
    public void createNews(User user, News news) {
        logger.info("Start createNews(" + user + ")");

        EconewsUserService econewsUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoEconewsUserService();

        System.out.println("logginedUserEntity = "
                + econewsUserService.getLogginedUserEntity());

        System.out.println(econewsUserService.createNews(news));

    }

    @DataProvider
    public Object[][] admins() {
        return new Object[][]{{UserRepository.get().getAdminUser(), "508"}};
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




