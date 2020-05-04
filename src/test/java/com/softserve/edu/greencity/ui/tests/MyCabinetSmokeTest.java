package com.softserve.edu.greencity.ui.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.HabitCard;
import com.softserve.edu.greencity.ui.data.HabitCardRepository;
import com.softserve.edu.greencity.ui.data.HabitItem;
import com.softserve.edu.greencity.ui.data.HabitItemRepository;
import com.softserve.edu.greencity.ui.pages.cabinet.MyCabinetPage;

public class MyCabinetSmokeTest extends GreencityTestRunner {

	@DataProvider
	public Object[][] habitDataProvider() {
		return new Object[][] {
			{ HabitItemRepository.getDiscardCupsHabit(), HabitCardRepository.getSaveBagsCard()}
			};
	}

	@Test(dataProvider = "habitDataProvider")
	public void checkElements(HabitItem habit, HabitCard card) {

        driver.get("https://ita-social-projects.github.io/GreenCityClient/#/auth");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("soyorer682@hubopss.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("1!Aaaaaa");
        driver.findElement(By.id("password")).submit();

       (new MyCabinetPage(driver))
           .addTodaysHabitInfo(habit)
           .navigateMenuMyCabinet()
           .gotoCreateHabitDropdown()
           .deleteAndCancelHabitCard(card)
           .deleteAndConfirmHabitCard(card)
           .addHabitCard(card)
           .cancelAddinngHabitCard(card)
           .closeCreateHabitDropdown()
           .showMoreGoals()
           .showLessGoals()
           .gotoManageGoalsDropdown()
           .closeManageGoalsDropdown();



        presentationSleep();
	}
}
