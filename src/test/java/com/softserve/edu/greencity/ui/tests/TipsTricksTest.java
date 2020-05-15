package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.UserRepository;

import com.softserve.edu.greencity.ui.pages.common.TopPart;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class TipsTricksTest extends GreencityTestRunner {

    @DataProvider(name = "email")
    public Object[][] dataProviderEmail() {
        return new Object[][] { { "almyyhvxddxxnoczzt@ttirv.com" }, { "hvxddxxnoczzt@ttirv.com" },
                { "almyyhvxddxxnoczzt@ttirvcom" } };
    }

    @DataProvider(name = "incorectEnter")
    public Object[][] dataProviderErrorEmail() {
        return new Object[][] { { "hvxddxxnoczzt@ttirv." }, { "" } };
    }

    @Test
    public void checkButtonTop() {
        logger.info("Start before method for " + getClass().getSimpleName());
        logger.info("Sign in with " + UserRepository.get().singInUser().toString());
        TipsTricksPage tipstrickspage = loadApplication();
        loadApplication().signin().successfullyLogin(UserRepository.get().singInUser());
        logger.info("name = " + tipstrickspage.getTopUserName());
        Assert.assertEquals(tipstrickspage.getTopUserName(), TopPart.PROFILE_NAME);
        logger.info("isDesp " + tipstrickspage.toGreenCity().navigateMyCabinet().isDisplayedNewHabit());
        tipstrickspage.toGreenCity().clickStartHabitTop();

        // Assert.assertTrue(tipstrickspage.navigateMenuMyCabinet().isDisplayedNewHabit());
        // tipstrickspage.signout();
        // tipstrickspage.toGreenCity();

//        Assert.assertTrue(tipstrickspage.navigateMyCabinet().isDisplayedNewHabit());
    }

   // @Test
    public void checkGetNumber() {
        TipsTricksPage tipsTricksPage = loadApplication();
        logger.info("Amount People: " + tipsTricksPage.getAmountPeopleText());
        Assert.assertEquals(tipsTricksPage.quantityPeople(), tipsTricksPage.numberPeople());
        presentationSleep(2);
        logger.info("Amount Bags were used: " + tipsTricksPage.quantityBags());
        Assert.assertEquals(tipsTricksPage.quantityBags(), tipsTricksPage.numberBags());
        presentationSleep(2);
        logger.info("Amount Cups were used: " + tipsTricksPage.quantityCups());
        Assert.assertEquals(tipsTricksPage.quantityCups(), tipsTricksPage.numberCups());
        presentationSleep(2);
    }

    @Test(dataProvider = "email")
    public void subscribe(String email) throws InterruptedException {
        TipsTricksPage subscr = loadApplication();
        subscr.subscrintion(email);
//        presentationSleep(1);
        logger.info("message " + subscr.getSubscriptionErrorText());
        Assert.assertEquals(subscr.getSubscriptionErrorText(), "Error, maybe you are already subscribed");

    }

    @Test(dataProvider = "incorectEnter")
    public void subscrubtionInvalid(String email) {
        TipsTricksPage subscr = loadApplication();
        subscr.subscrintion(email);
//        presentationSleep(1);
        logger.info("invalid " + subscr.getValidationErrorText());
        Assert.assertEquals(subscr.getValidationErrorText(), "Invalid email");
    }

   @Test
    public void gotoMap() {
        TipsTricksPage tips = loadApplication();
        tips.moveBagsToMap();
        Assert.assertEquals(tips.getBagsLink().isDisplayed(), true);
        Assert.assertEquals(tips.getCupsLink().isDisplayed(), true);
        tips.toGreenCity().clickCupsLink();
   

    }

   @Test
    public void news() {
        TipsTricksPage news = loadApplication();
        logger.info("All News link " + news.isDesplayedgetAllNewsLink());
        Assert.assertEquals(news.isDesplayedgetAllNewsLink(), true);
        news.moveAllNewsLink();
        news.toGreenCity().clickOther1EcoNewsLink();
        logger.info("Other1 News link " + news.isDesplayedOther1EcoNewsLink());
        Assert.assertEquals(news.isDesplayedOther1EcoNewsLink(), true);
        news.toGreenCity().clickOther2EcoNewsLink();
        logger.info("Other2 News link " + news.isDesplayedOther2EcoNewsLink());
        Assert.assertEquals(news.isDesplayedOther2EcoNewsLink(), true);
        news.toGreenCity().clickMainEcoNewsLink();
        logger.info("Main News link " + news.isDesplayedMainEcoNewsLink());
        

    }

   @Test
    public void items() {
        TipsTricksPage items = loadApplication();
        for (int i = 0; i <= 12; i++) {
            items.getTipsCardsContainer().clickRightPagination();
        }
        items.getTipsCardsContainer().checkActiveCards();

    }
}
