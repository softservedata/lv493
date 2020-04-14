package com.softserve.edu.opencart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

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

public abstract class SortTestRunner {
	protected WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
		Thread.sleep(1000); // For Presentation Only
		driver.quit();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("\t@BeforeMethod method");
		driver.get("http://taqc-opencart.epizy.com/");
//		driver.manage().window().maximize();
		Thread.sleep(1000); // For Presentation Only
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("\t@AfterMethod method");
		// logout, get(urlLogout), delete cookie, delete cache
	}
	
	protected List<String> getPrices(List<WebElement> products) {
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

	protected boolean isSortedByDesc(List<String> originLists) {
		List<String> checkedList = new ArrayList<>(originLists);
		Collections.sort(checkedList, new StrPriceDescComparator());
		//ollections.sort(checkedList);
		System.out.println("originLists " + originLists);
		System.out.println("checkedList " + checkedList);
		return originLists.equals(checkedList);
	}
}
