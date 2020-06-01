package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.econews.*;
import com.softserve.edu.greencity.rest.services.EconewsGuestService;
import com.softserve.edu.greencity.rest.services.EconewsUserService;
import com.softserve.edu.greencity.rest.tools.GreenCity400Exception;
import com.softserve.edu.greencity.rest.tools.VerifyUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for Eco News Controller
 *
 * @author Mariana
 */
public class EconewsTests extends GreencityRestTestRunner {

    /**
     * Variable int newsId
     * to path value from test checkUploadEconews to deleteNews test
     */
    private List<Integer> newsId = new ArrayList<>();

    @DataProvider
    public Object[][] news() {
        return new Object[][]{{PageParameterRepository.getNewsByTags()}};
    }

    /**
     * Test of getting news by Page parameters.
     *
     * @param pageParameters
     */
    @Test(dataProvider = "news")
    public void getAllNews(PageParameters pageParameters) {
        logger.info("Start getAllNews");
        EconewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();
        List<News> news = econewsGuestService.getAllNews(pageParameters.getPage(), pageParameters.getSize());

        logger.info(news.size() + " news were founded");

        Assert.assertTrue(VerifyUtils.verifyClass(news));

        Assert.assertEquals(news.size(), Integer.parseInt(pageParameters.getSize()));
    }

    /**
     * Test of getting news by Tags parameters.
     *
     * @param pageParameters
     */
    @Test(dataProvider = "news")
    public void getNewsByTags(PageParameters pageParameters) {
        logger.info("Start getNewsByTags with " + pageParameters.toStringWithTags());
        EconewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();

        List<News> news = econewsGuestService.getNewsByTags(pageParameters.getPage(),
                pageParameters.getSize(), pageParameters.getTags());

        logger.info(news.size() + " news were founded by tags " + pageParameters.getTags());
        //  List<String> tags1 = new ArrayList<>();
        //   tags1.add("events");
        Assert.assertTrue(VerifyUtils.verifyClass(news));
        Assert.assertEquals(news.size(), Integer.parseInt(pageParameters.getSize()));
        Assert.assertTrue(pageParameters.verifyNewsByTags(news, pageParameters.getTags()));
    }

    @DataProvider
    public Object[] NewsId() {
        Integer[] intArray = new Integer[newsId.size()];
        intArray = newsId.toArray(intArray);
        return intArray;
    }
    /**
     * Test of getting news by NewsId.
     */
    @Test(dataProvider = "NewsId", priority = 2)
    public void getNewsById(int newsId) {
        logger.info("Start getNewsById(" + newsId + ")");

        EconewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();

        News news = econewsGuestService.getNewsById(String.valueOf(newsId));

        Assert.assertTrue(news.isValid());
    }

    @DataProvider
    public Object[][] uploadNews() {
        return new Object[][]{
                {UserRepository.get().getAdminUser(),
                        FileUploadPropertiesRepository.get().simpleNews()},
                {UserRepository.get().getAdminUser(),
                        FileUploadPropertiesRepository.get().minSymbolsNews()}
        };
    }

    /**
     * Test of news uploading.
     *
     * @param user
     * @param fileUploadProperties
     */
    @Test(dataProvider = "uploadNews", priority = 1)
    public void checkUploadEconews(User user, FileUploadProperties fileUploadProperties) {
        logger.info("Start checkUploadEconews(" + user + ")");
        EconewsUserService econewsUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoEconewsUserService();
        logger.info("logginedUserEntity = "
                + econewsUserService.getLogginedUserEntity());

        logger.info("FileUploadProperties: " + fileUploadProperties);

        News news = econewsUserService.uploadNews(fileUploadProperties);

        logger.info("Created news = " + news.toString());

        newsId.add(news.getId());

        Assert.assertTrue(news.isValid());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(news.getTags(), fileUploadProperties.getNews().getTags(),
                "Tags are not equal");
        softAssert.assertEquals(news.getText(), fileUploadProperties.getNews().getText(),
                "Text fields are not equal");
        softAssert.assertEquals(news.getTitle(), fileUploadProperties.getNews().getTitle(),
                "Title fields are not equal");
        softAssert.assertEquals(news.getSource(), fileUploadProperties.getNews().getSource(),
                "Source fields are not equal");
        softAssert.assertAll();
    }

    @DataProvider
    public Object[] deleteNews() {
        Object[][] dataArray = new Object[newsId.size()][];
        List<Object[]> dataList = new ArrayList<>();
        for (int currentId:newsId){
            Object[] data = new Object[]{UserRepository.get().getAdminUser(), currentId};
                dataList.add(data);
        }
        dataArray = dataList.toArray(dataArray);
        return dataArray;
      //  return new Object[][]{{UserRepository.get().getAdminUser()}};
    }

    /**
     * Test of news deleting.
     *
     * @param user
     * @param newsId
     */
    @Test(dataProvider = "deleteNews", priority = 3, expectedExceptions = GreenCity400Exception.class)
    public void deleteNews(User user, int newsId) {
        logger.info("Start deleteNews(" +  newsId + ")");
        EconewsUserService econewsUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoEconewsUserService();
        logger.info("logginedUserEntity = "
                + econewsUserService.getLogginedUserEntity());
        Assert.assertEquals(econewsUserService.deleteNews(String.valueOf(newsId)), 200);

        EconewsGuestService econewsGuestService = loadApplication().gotoEconewsGuestService();
        econewsGuestService.getNewsById(String.valueOf(newsId));
    }
}




