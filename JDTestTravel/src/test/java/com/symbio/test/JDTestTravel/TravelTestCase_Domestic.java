package com.symbio.test.JDTestTravel;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symbio.test.JDTestTravel.PageObject.DomesticTravelPageObject;
import com.symbio.test.JDTestTravel.PageObject.InternationalTravelPageObject;
import com.symbio.test.JDTestTravel.PageObject.MainPageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TravelTestCase_Domestic {

	private String originCity = "北京";
	private String destinationCity = "上海";

	private String startDateString = "2015-12-25";
	private String endDateString = "2016-01-04";

	private Date startDate;
	private Date endDate;

	private WebDriver driver;

	private MainPageObject mainPO;
	private DomesticTravelPageObject travelPO;

	/**
	 * Test case for international travel
	 * @throws Exception 
	 */
	@Test(groups = "jdtravel-test")
	public void test() {
		mainPO.goToTravel();
		travelPO.goToThisPage();
		travelPO.goDomesticPage();
		travelPO.pickRoundTravel();
		travelPO.insertDestination(originCity, destinationCity);
		travelPO.insertDate(startDate, endDate);
		travelPO.clickSearchButton();
	}
	
	/**
	 * Initiate the necessary variables for the test
	 * 
	 * @throws ParseException
	 *             Exception when parsing string into date
	 */
	@BeforeClass(groups = "jdtravel-test")
	public void initTest() throws ParseException {
		driver = new FirefoxDriver();
		mainPO = new MainPageObject(driver);
		travelPO = new DomesticTravelPageObject(driver);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		startDate = sdf.parse(startDateString);
		endDate = sdf.parse(endDateString);
	}

	/**
	 * Initiate the base website
	 */
	@BeforeMethod(groups = "jdtravel-test")
	public void initSite() {
		driver.get("http://www.jd.com");
	}

	/**
	 * Close all opened internet browser windows
	 */
	@AfterClass(groups = "jdtravel-test")
	public void destroyTest() {
		driver.quit();
	}
}
