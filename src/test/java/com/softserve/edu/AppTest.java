package com.softserve.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

class StrPriceDescComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		if (o1 == null && o2 == null) {
			return 0;
		} else if (o1 == null) {
			return 1;
		} else if (o2 == null) {
			return -1;
		}
		BigDecimal bd1 = new BigDecimal(o1.replace(",", ""));
		BigDecimal bd2 = new BigDecimal(o2.replace(",", ""));
		//return -o1.compareTo(o2);
		return bd2.compareTo(bd1);
	}
}

public class AppTest {

	@Test
	public void testApp() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		driver.get("http://taqc-opencart.epizy.com/");
		//
		// Steps
		driver.findElement(By.cssSelector("#search > input")).click();
		driver.findElement(By.cssSelector("#search > input")).clear();
		driver.findElement(By.cssSelector("#search > input")).sendKeys("%");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Thread.sleep(2000); // For Presentation Only
		//
		String taqc = driver.getWindowHandle();
		//
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_T);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_T);
		//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open();");
		Thread.sleep(1000); // Do no use
		js.executeScript("window.open('https://www.google.com','_blank');");
		//
		Thread.sleep(4000); // Do no use
		//
		driver.switchTo().window(taqc);
		//
//		for (String temp : driver.getWindowHandles()) {
//			if (!taqc.equals(temp)) {
//				driver.switchTo().window(temp);
//				break;
//			}
//		}
		//
		//Assert.assertTrue(true);
        Thread.sleep(4000); // For Presentation Only
		driver.quit();
	}

	// @Test
	public void checkApp2() {
		System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
		System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
		Assert.assertTrue(true);
	}

	private List<String> getPrices(List<WebElement> products) {
		List<String> result = new ArrayList<>();
		String pattern = "^\\s*.?((\\d{1,3},)*\\d{1,3}\\.\\d{2})";
		Pattern p = Pattern.compile(pattern);
		//
		for (WebElement current : products) {
			WebElement priceElemet = current.findElement(By.cssSelector("p.price"));
			String price = priceElemet.getText().trim();
			Matcher m = p.matcher(price);
			if (m.find()) {
				result.add(price.substring(m.start(1), m.end(1)));
			}
		}
		return result;
	}

	private boolean isSortedByDesc(List<String> originLists) {
		List<String> checkedList = new ArrayList<>(originLists);
		Collections.sort(checkedList, new StrPriceDescComparator());
		//ollections.sort(checkedList);
		System.out.println("originLists " + originLists);
		System.out.println("checkedList " + checkedList);
		return originLists.equals(checkedList);
	}

	//@Test
	public void checkSort() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		driver.get("http://taqc-opencart.epizy.com/");
		//
		// Steps
		driver.findElement(By.cssSelector("#search > input")).click();
		driver.findElement(By.cssSelector("#search > input")).clear();
		driver.findElement(By.cssSelector("#search > input")).sendKeys("%");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		//
		Select sortSelect = new Select(driver.findElement(By.id("input-sort")));
		sortSelect.selectByVisibleText("Price (High > Low)");
		//
		List<WebElement> products = driver.findElements(By.cssSelector("div.product-layout"));
		//
		//System.out.println(isSortedByDesc(getPrices(products)));
        Assert.assertTrue(isSortedByDesc(getPrices(products)));
        //
        Thread.sleep(4000); // For Presentation Only
		driver.quit();
	}
}
