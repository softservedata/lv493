package com.softserve.edu.greencity.rest.tests;

import com.softserve.edu.greencity.rest.data.ResponseCode;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.data.econews.*;
import com.softserve.edu.greencity.rest.services.EcoNewsGuestService;
import com.softserve.edu.greencity.rest.services.EcoNewsUserService;
import com.softserve.edu.greencity.rest.tools.GreenCity400Exception;
import com.softserve.edu.greencity.rest.tools.GreenCityCommonException;
import com.softserve.edu.greencity.rest.tools.VerifyUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Tests for Eco News Controller
 *
 * @author Mariana
 */
public class EcoNewsTests extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] news() {
        return new Object[][]{{PageParameterRepository.get().getPageParameters()}};
    }

    /**
     * Test of getting news by Page parameters.
     *
     * @param pageParameters
     */
    @Test(dataProvider = "news")
    public void getAllNews(PageParameters pageParameters) {
        logger.info("Start getAllNews");
        EcoNewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();
        List<News> news = econewsGuestService.getAllNews(pageParameters.getPage(), pageParameters.getSize());

        logger.info(news.size() + " news were founded");

        Assert.assertTrue(VerifyUtils.verifyClass(news));

        Assert.assertEquals(news.size(), Integer.parseInt(pageParameters.getSize()));
    }

    @DataProvider
    public Object[][] tags() {
        return new Object[][]{{PageParameterRepository.get().getTagsParameters()}};
    }

    /**
     * Test of getting news by Tags parameters.
     *
     * @param pageParameters
     */
    @Test(dataProvider = "tags")
    public void getNewsByTags(PageParameters pageParameters) {
        logger.info("Start getNewsByTags with " + pageParameters.toStringWithTags());
        EcoNewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();

        List<News> news = econewsGuestService.getNewsByTags(pageParameters.getPage(),
                pageParameters.getSize(), pageParameters.getTags());

        logger.info(news.size() + " news were founded by tags " + pageParameters.getTags());

        Assert.assertTrue(VerifyUtils.verifyClass(news));

        Assert.assertEquals(news.size(), Integer.parseInt(pageParameters.getSize()));

        Assert.assertTrue(pageParameters.verifyNewsByTags(news, pageParameters.getTags()));
    }

    @DataProvider
    public Object[] newsId() {
        return new Object[]{NewsIdRepository.get().getDefault()};
    }

    /**
     * Test of getting news by NewsId.
     */
    @Test(dataProvider = "newsId")
    public void getNewsById(int newsId) {
        logger.info("Start getNewsById(" + newsId + ")");

        EcoNewsGuestService econewsGuestService = loadApplication()
                .gotoEconewsGuestService();

        News news = econewsGuestService.getNewsById(String.valueOf(newsId));

        Assert.assertEquals(news.getId(), newsId);

        Assert.assertTrue(news.isValid());
    }

    @DataProvider
    public Object[][] uploadNews() {
        return new Object[][]{
                {UserRepository.get().getAdminUser(), // GC-626 Max symbols
                        NewsUploadPropertiesRepository.get().maxSymbolsNews()},
                {UserRepository.get().getAdminUser(), // GC-605 min symbols
                        NewsUploadPropertiesRepository.get().minSymbolsNews()},
                {UserRepository.get().getAdminUser(), // GC-625 intermediate number of symbols
                        NewsUploadPropertiesRepository.get().intermediateSymbolsNews()}
        };
    }

    /**
     * Test of news uploading.
     *
     * @param user
     * @param newsUploadProperties
     */
    @Test(dataProvider = "uploadNews", priority = 1)
    public void checkUploadEconews(User user, NewsUploadProperties newsUploadProperties) {
        logger.info("Start checkUploadEconews(" + user + ")");
        EcoNewsUserService econewsUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoEconewsUserService();
        logger.info("logginedUserEntity = "
                + econewsUserService.getLogginedUserEntity());
        logger.info(newsUploadProperties.getNews().toString());
        logger.info(newsUploadProperties.getFileUploadParameters().toString());

        News news = econewsUserService.uploadNews(newsUploadProperties);

        logger.info("Created news = " + news.toString());

        Assert.assertTrue(news.isValid());

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(news.getTags(), newsUploadProperties.getNews().getTags(),
                "Tags are not equal");
        softAssert.assertEquals(news.getText(), newsUploadProperties.getNews().getText(),
                "Text fields are not equal");
        softAssert.assertEquals(news.getTitle(), newsUploadProperties.getNews().getTitle(),
                "Title fields are not equal");
//        softAssert.assertEquals(news.getSource(), newsUploadProperties.getNews().getSource(),
//                "Source fields are not equal");

        softAssert.assertAll();
        //https://github.com/ita-social-projects/GreenCity/issues/832
    }

    @DataProvider
    public Object[] deleteNews() {
        return NewsIdRepository.get().generateData(NewsIdRepository.get().getNewsId(),
                UserRepository.get().getAdminUser());
    }

    /**
     * Test of news deleting.
     *
     * @param user
     * @param newsId
     */
    @Test(dataProvider = "deleteNews", priority = 3, expectedExceptions = GreenCity400Exception.class)
    public void deleteNews(User user, int newsId) {
        logger.info("Start deleteNews(" + newsId + ")");
        EcoNewsUserService econewsUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoEconewsUserService();
        logger.info("logginedUserEntity = "
                + econewsUserService.getLogginedUserEntity());
        Assert.assertEquals(econewsUserService.deleteNews(String.valueOf(newsId)), ResponseCode.RESPONSE200.getValue());

        EcoNewsGuestService econewsGuestService = loadApplication().gotoEconewsGuestService();

        econewsGuestService.getNewsById(String.valueOf(newsId));
    }

    //**_____________________________________________________________________________________________**\\

    @DataProvider
    public Object[][] uploadNewsNegativeData() {
        return new Object[][]{
                {UserRepository.get().getAdminUser(), // GC-594 more than 3 tags
                        NewsUploadPropertiesRepository.get().tooManyTagsOfNews()}, //defect https://github.com/ita-social-projects/GreenCity/issues/717
                {UserRepository.get().getAdminUser(), // GC-571 all empty values
                        NewsUploadPropertiesRepository.get().emptyNews()},
                {UserRepository.get().getAdminUser(), // GC-581 more than 170 characters in ‘title’ field
                        NewsUploadPropertiesRepository.get().titleSizeInvalidOfNews()},
                {UserRepository.get().getAdminUser(), // GC-572 empty ‘title’ value
                        NewsUploadPropertiesRepository.get().emptyTitleOfNews()},
                {UserRepository.get().getAdminUser(), //GC-600 empty ‘text’ value
                        NewsUploadPropertiesRepository.get().emptyTextOfNews()},
        };
    }

    /**
     * Test of news uploading.
     *
     * @param user
     * @param newsUploadProperties
     */
    @Test(dataProvider = "uploadNewsNegativeData", priority = 2, expectedExceptions = GreenCityCommonException.class)
    public void creteNewsNegative(User user, NewsUploadProperties newsUploadProperties) {
        logger.info("Start checkUploadEconews(" + user + ")");
        EcoNewsUserService econewsUserService = loadApplication()
                .successfulUserLogin(user)
                .gotoEconewsUserService();
        logger.info("logginedUserEntity = "
                + econewsUserService.getLogginedUserEntity());

        logger.info(newsUploadProperties.getNews().toString());
        logger.info(newsUploadProperties.getFileUploadParameters().toString());

        News news = econewsUserService.uploadNews(newsUploadProperties);

        logger.info("Created news = " + news.toString());

        Assert.assertFalse(news.isValid());

    }
}




