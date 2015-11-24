package com.symbio.test.JDTestTravel;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestCase_Intl {

	private String originCity = "北京";
	private String destinationCity = "夏威夷";

	private Date startDate;
	private Date endDate;

	private WebDriver driver;

	@Test(groups = "jdtravel-test")
	public void test() {

	}

	@BeforeClass
	public void initTest() {
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void initSite() {
		driver.get("http://www.jd.com");
	}

	@AfterClass
	public void destroyTest() {
		driver.quit();
	}
}
