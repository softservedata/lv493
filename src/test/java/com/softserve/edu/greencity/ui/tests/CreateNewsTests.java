package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.data.NewsData;
import com.softserve.edu.greencity.ui.data.NewsDataRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class CreateNewsTests extends GreencityTestRunner {

    @DataProvider
    public Object[] newsDataProvider() {
        return new Object[]{
               // NewsDataRepository.getAllFieldsNews(),
                NewsDataRepository.getInvalidData()
                };
    }

    @Test
    public void CancelNewsCreatingTest() {
        NewsData newsData = NewsDataRepository.getDefault();
        TipsTricksPage tipstrickspage = loadApplication();
        tipstrickspage
                .navigateMenuEconews()
                .gotoCreateNewsPage()
                .fillAllNewsFields(newsData)
                .cancelNewsCreating();
        Assert.assertEquals(driver.getTitle(), "Eco news");
        presentationSleep(10);
    }

    @Test
    public void CancelContinueNewsCreatingTest() {
        NewsData newsData = NewsDataRepository.getDefault();
        TipsTricksPage tipstrickspage = loadApplication();
        tipstrickspage
                .navigateMenuEconews()
                .gotoCreateNewsPage()
                .fillAllNewsFields(newsData)
                .continueNewsCreating();
        Assert.assertEquals(driver.getTitle(), "Home");
        presentationSleep(10);
    }

    @Test(dataProvider = "newsDataProvider")
    public void createNewsTest(NewsData newsData) {
             TipsTricksPage tipstrickspage = loadApplication();
        tipstrickspage
                .navigateMenuEconews()
                .gotoCreateNewsPage()
                .fillAllNewsFields(newsData)
                .openPreViewPage()
                .backToCreateNewsPage();
                //.publishNews();
        presentationSleep(10);
    }
}
