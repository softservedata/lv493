package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.data.NewsData;
import com.softserve.edu.greencity.ui.data.NewsDataRepository;
import com.softserve.edu.greencity.ui.pages.econews.CreateNewsPage;
import com.softserve.edu.greencity.ui.pages.econews.EconewsPage;
import com.softserve.edu.greencity.ui.pages.econews.PreViewPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class CreateNewsTests extends GreencityTestRunner {

    @DataProvider
    public Object[] newsDataProvider() {
        return new Object[]{
                NewsDataRepository.getAllFieldsNews()
                // NewsDataRepository.getInvalidData()
        };
    }

//    @Test
    public void CancelNewsCreatingTest() {
        NewsData newsData = NewsDataRepository.getDefault();
        EconewsPage econewsPage = loadApplication()
                .navigateMenuEconews();
        int expectedCount = econewsPage.getNumberOfItemComponent();

        econewsPage = econewsPage.gotoCreateNewsPage()
                .fillAllNewsFields(newsData)
                .cancelNewsCreating();

        Assert.assertEquals(econewsPage.getNumberOfItemComponent(), expectedCount);
        Assert.assertEquals(driver.getTitle(), "Eco news");
    }

//    @Test(dataProvider = "newsDataProvider")
    public void CancelContinueNewsCreatingTest(NewsData newsData) {
        CreateNewsPage createNewsPage = loadApplication()
                .navigateMenuEconews()
                .gotoCreateNewsPage()
                .fillAllNewsFields(newsData);
        createNewsPage = createNewsPage.continueNewsCreating();

        Assert.assertEquals(createNewsPage.getContentField().getAttribute("value"), newsData.getContent(),
                "Text in Content field doesn't match with input data");
        Assert.assertEquals(createNewsPage.getTitleField().getAttribute("value"), newsData.getTitle(),
                "Text in Title field doesn't match with input data");
       // createNewsPage.publishNews();
    }

//    @Test(dataProvider = "newsDataProvider")
    public void createNewsTest(NewsData newsData) {
        PreViewPage preViewPage = loadApplication()
                .navigateMenuEconews()
                .gotoCreateNewsPage()
                .fillAllNewsFields(newsData)
                .goToPreViewPage();
        Assert.assertEquals(preViewPage.getContentFieldText(), newsData.getContent(),
                "Text in Content field doesn't match with input data");
        Assert.assertEquals(preViewPage.getTitleFieldText(), newsData.getTitle(),
                "Text in Title field doesn't match with input data");
        CreateNewsPage createNewsPage = preViewPage.backToCreateNewsPage();
        Assert.assertEquals(createNewsPage.getContentField().getAttribute("value"), newsData.getContent(),
                "Text in Content field doesn't match with input data");
        Assert.assertEquals(createNewsPage.getTitleField().getAttribute("value"), newsData.getTitle(),
                "Text in Title field doesn't match with input data");
    }
}