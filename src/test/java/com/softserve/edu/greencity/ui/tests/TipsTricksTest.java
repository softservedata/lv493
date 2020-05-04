package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class TipsTricksTest extends GreencityTestRunner {
 //@Test
  public void checkButtonTop() {
      TipsTricksPage tipstrickspage = loadApplication();
      tipstrickspage.clickStartHabitTop();
  }
  
 //@Test
  public void text() {
      TipsTricksPage tipstrickspage = loadApplication();
      System.out.println(tipstrickspage.textAmountPeople());
     System.out.println("Amount Bags were used: " + tipstrickspage); 
      
  }
  @Test
  public void checkgetNumber() {
      TipsTricksPage tipsTricksPage = loadApplication();
      System.out.println("Amount People: " +  tipsTricksPage.getNumberAmountPeople());
      System.out.println("Amount Bags were used: " + tipsTricksPage.getNumberAmountBags()); 
      System.out.println("Amount Cups were used: " + tipsTricksPage.getNumberAmountCups()); 
  }
}
