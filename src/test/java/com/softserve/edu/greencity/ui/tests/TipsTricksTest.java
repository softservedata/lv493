package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class TipsTricksTest extends GreencityTestRunner {

    @Test
    public void checkButtonTop() {

        TipsTricksPage tipstrickspage = loadApplication();
        tipstrickspage.navigateMyCabinet();
        // code for login
        Assert.assertEquals(driver.getTitle(), "My Cabinet");
    }

    @Test
    public void text() {

        TipsTricksPage tipstrickspage = loadApplication();
        logger.info(tipstrickspage.getAmountPeopleText());
        logger.info("Amount Bags were used: " + tipstrickspage.quantityPeople());
        Assert.assertEquals("168", tipstrickspage.quantityPeople());

    }

   @Test
    public void checkGetNumber() {
        TipsTricksPage tipsTricksPage = loadApplication();
        logger.info("Amount People: " + tipsTricksPage.quantityPeople());
        logger.info("Amount Bags were used: " + tipsTricksPage.quantityBags());
        logger.info("Amount Cups were used: " + tipsTricksPage.quantityCups());
        Assert.assertEquals(tipsTricksPage.quantityPeople(), tipsTricksPage.quantityPeople());
        Assert.assertEquals(tipsTricksPage.quantityBags(), tipsTricksPage.quantityBags());
        Assert.assertEquals(tipsTricksPage.quantityCups(), tipsTricksPage.quantityCups());
    }

     @Parameters({ "email" })
     @Test
    public void subscribe(String email) throws InterruptedException {
        TipsTricksPage subscr = loadApplication();
        subscr.clickEmailTipsTricks();
        subscr.setEmailTipsTricks(email);
        // subscr.setEmailTipsTricks("almyyhvxddxxnoczzt@ttirv.com");
        Thread.sleep(1000);
        subscr.clickSubscribeOnTipsTricks();
    }

    @Test
    public void mainEcoNews() {
        TipsTricksPage news = loadApplication();
        news.moveMainEcoNewsLink();

    }

    @Test
    public void gotoMap() throws InterruptedException {
        TipsTricksPage tips = loadApplication();
        tips.moveBagsToMap();
        // Assert.assertEquals(tips., tips.moveBagsToMap());
        tips.clickLogoCreenCity();

        System.out.println("logo " + tips.getlogoGreenCityText());
        // Assert.assertEquals("", tips.getlogoGreenCityText());
    }

     @Test
    public void gotoMap1() throws InterruptedException {
        TipsTricksPage tips = loadApplication();

        tips.moveCupsToMap();
        // tips.clickLogoCreenCity();
        // Assert.assertEquals(tips.moveBagsToMap(), "Map");
    }

     @Test
    public void gotoMapAll() throws InterruptedException {
        TipsTricksPage tips = loadApplication();
        tips.moveBagsToMap();
        tips.clickLogoCreenCity();
        Thread.sleep(1000);
        // JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("arguments[0].scrollIntoView();", linkCups);
        tips.moveCupsToMap();

        // Assert.assertEquals(tips.moveBagsToMap(), "Map");
    }

    @Test
    public void news() {
        TipsTricksPage news = loadApplication();
        news.moveAllNewsLink();
        news.toGreenCity().clickAllNewsLink();
        // Assert.assertEquals(actual, GetElementText);
        news.toGreenCity().clickOther1EcoNewsLink();
        // Assert.assertEquals(actual, expected);
        news.toGreenCity().clickOther2EcoNewsLink();
        // Assert.assertEquals(actual, expected);
        news.toGreenCity().clickMainEcoNewsLink();
        // Assert.assertEquals(actual, expected);

    }

   @Test
    public void maps() {
        TipsTricksPage maps = loadApplication();
        maps.moveBagsToMap();
        // Assert.assertEquals(actual, expected);
        maps.toGreenCity().moveCupsToMap();
        // Assert.assertEquals(actual, expected);
    }

    // @Test
    // public void email() {
    // TipsTricksPage email = loadApplication();
    // email.getEmailTipsTricksText();
    // }
     @Test
    public void items() {
        TipsTricksPage items = loadApplication();
        // items.getTipsCardsContainer().clickRightPagination();
        items.getTipsCardsContainer().getItemComponentsCount();
    }
}
