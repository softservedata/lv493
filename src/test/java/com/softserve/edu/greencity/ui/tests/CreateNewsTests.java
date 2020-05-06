package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.data.NewsData;
import com.softserve.edu.greencity.ui.data.NewsDataRepository;
import com.softserve.edu.greencity.ui.pages.econews.CreateNewsPage;
import com.softserve.edu.greencity.ui.pages.econews.PreViewPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class CreateNewsTests extends GreencityTestRunner {

    //@DataProvider
    public Object[] newsDataProvider() {
        return new Object[]{
                NewsDataRepository.getAllFieldsNews()
                // NewsDataRepository.getInvalidData()
        };
    }

    //@Test
    public void CancelNewsCreatingTest() {
        NewsData newsData = NewsDataRepository.getDefault();
        TipsTricksPage tipstrickspage = loadApplication();
        tipstrickspage
                .navigateMenuEconews()
                .gotoCreateNewsPage()
                .fillAllNewsFields(newsData)
                .cancelNewsCreating();
        Assert.assertEquals(driver.getTitle(), "Eco news");
        presentationSleep(2);
    }

    //@Test(dataProvider = "newsDataProvider")
    public void CancelContinueNewsCreatingTest(NewsData newsData) {
        CreateNewsPage createNewsPage = loadApplication()
                .navigateMenuEconews()
                .gotoCreateNewsPage()
                .fillAllNewsFields(newsData)
                .continueNewsCreating();

        Assert.assertEquals("Text in Title field doesn't match with input data",
                createNewsPage.getContentFieldText(), newsData.getContent());
        Assert.assertEquals("Text in Title field doesn't match with input data",
                createNewsPage.getTitleFieldText(), newsData.getTitle());
        presentationSleep(10);

        createNewsPage.publishNews();
    }

    //@Test(dataProvider = "newsDataProvider")
    public void createNewsTest(NewsData newsData) {
        PreViewPage preViewPage = loadApplication()
                .navigateMenuEconews()
                .gotoCreateNewsPage()
                .fillAllNewsFields(newsData)
                .goToPreViewPage();
        Assert.assertEquals("Text in Title field doesn't match with input data",
                preViewPage.getContentFieldText(), newsData.getContent());
        Assert.assertEquals("Text in Title field doesn't match with input data",
                preViewPage.getTitleFieldText(), newsData.getTitle());

        CreateNewsPage createNewsPage = preViewPage.backToCreateNewsPage();

        Assert.assertEquals("Text in Title field doesn't match with input data",
                createNewsPage.getContentFieldText(), newsData.getContent());
        Assert.assertEquals("Text in Title field doesn't match with input data",
                createNewsPage.getTitleFieldText(), newsData.getTitle());

        createNewsPage.publishNews();

        presentationSleep(2);
    }
}