package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.econews.EconewsPage;
import com.softserve.edu.greencity.ui.pages.home.HomePage;

public class EconewsPageTest extends GreencityTestRunner {
  
	@Test
  public void f() {
		HomePage homepage = loadApplication();
		homepage.navigateMenuEconews();
		EconewsPage ecoNewsPage= new EconewsPage(driver);
		System.out.println("is active first time" + ecoNewsPage.gridViewIsActive() );
		
		ecoNewsPage.clickListView();
		System.out.println("is active second time" + ecoNewsPage.gridViewIsActive() );
		
		ecoNewsPage.clickGridView();
		System.out.println("is active third time" + ecoNewsPage.gridViewIsActive() );
  }
}
