package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.econews.EconewsPage;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;


public class EconewsPageTest extends GreencityTestRunner {
  
	@Test
  public void f() {
		
		TipsTricksPage  homepage = loadApplication();
		homepage.navigateMenuEconews()
			.switchToOneNewsPagebyNumber(19);
		//EconewsPage ecoNewsPage= new EconewsPage(driver);
		//System.out.println("is active first time " + ecoNewsPage.IsActiveGridView() );
		
		//ecoNewsPage.clickListView();
		//System.out.println("is active second time " + ecoNewsPage.IsActiveGridView() );
		
		//ecoNewsPage.clickGridView();
		//System.out.println("is active third time " + ecoNewsPage.IsActiveGridView() );
  }
}
