package com.softserve.edu.greencity.ui.tests;

import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

public class TipsTricksTest extends GreencityTestRunner {
  @Test
  public void checkButtonTop() {
      TipsTricksPage tipstrickspage = loadApplication();
      tipstrickspage.clickStartHabitTop();
  }
}
