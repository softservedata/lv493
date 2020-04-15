package com.softserve.edu.opencart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.SearchItem;
import com.softserve.edu.opencart.data.SearchItemRepository;
import com.softserve.edu.opencart.data.SearchRefine;
import com.softserve.edu.opencart.data.SearchRefineRepository;
import com.softserve.edu.opencart.tools.ElementFilters;

public class SortTest extends SortTestRunner {

	@DataProvider
	public Object[][] validDataProvider() {
		return new Object[][] {
			{ SearchItemRepository.getAllItem(), SearchRefineRepository.getPriceDescUsd() },
			{ SearchItemRepository.getAllItem(), SearchRefineRepository.getExTaxPriceDescUsd() },
			//{ SearchItemRepository.getMacItem(), SearchRefineRepository.getPriceDescUsd() },
			//{ SearchItemRepository.getMacItem(), SearchRefineRepository.getExTaxPriceDescUsd() }
			};
	}

	@Test(dataProvider = "validDataProvider")
	public void checkSort(SearchItem searchItem, SearchRefine searchRefine) throws Exception {
		// Steps
		driver.findElement(By.cssSelector("#search > input")).click();
		driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
		driver.findElement(By.cssSelector("button[name='" + searchRefine.getCurrencies().getAttributeName() + "']")).click();
		//
		driver.findElement(By.cssSelector("#search > input")).click();
		driver.findElement(By.cssSelector("#search > input")).clear();
		driver.findElement(By.cssSelector("#search > input")).sendKeys(searchItem.getSearchText());
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		//
		Select sortSelect = new Select(driver.findElement(By.id("input-sort")));
		sortSelect.selectByVisibleText(searchRefine.getSortBy());
		//
		List<WebElement> products = driver.findElements(By.cssSelector("div.product-layout"));
		//
		// Check
		ElementFilters elementFilters = new ElementFilters();
		Assert.assertTrue(elementFilters.isSorted(elementFilters
				.getElemets(products, searchRefine.getBy(), searchRefine.getPattern()),
				searchRefine.getComparator()));
		Thread.sleep(1000); // For Presentation Only
		//
		// Return to Previous State
		driver.findElement(By.cssSelector("img[src*='/logo.png']")).click();
		Thread.sleep(1000); // For Presentation Only
		//driver.quit();
	}
}
