package com.softserve.edu.greencity.ui.tests;

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
