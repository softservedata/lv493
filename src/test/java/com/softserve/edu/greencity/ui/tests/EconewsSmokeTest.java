package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class EconewsSmokeTest extends GreencityTestRunner {
  
	@Test
  public void econewsSmokeTest() {
		
		TipsTricksPage  page = loadApplication();
		page.navigateMenuEconews()
			.switchToOneNewsPagebyNumber(19) 
			.switchToNextOneNewsPagebyNumber(1);
			
  }
}
