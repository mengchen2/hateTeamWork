package com.symbio.test.JDTestTravel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symbio.test.JDTestTravel.PageObj.InternationalTravelPageObj;
import com.symbio.test.JDTestTravel.PageObj.MainPageObj;
import com.symbio.test.JDTestTravel.helper.ElementUtil;

public class TestCase_Intl {

	private String originCity = "北京";
	private String destinationCity = "夏威夷";

	private String startDateString = "2015-12-25";
	private String endDateString = "2016-01-04";

	private Date startDate;
	private Date endDate;

	private WebDriver driver;

	private MainPageObj mainPO;
	private InternationalTravelPageObj travelPO;

	@Test(groups = "jdtravel-test")
	public void test() {
		mainPO.goToTravel();
		travelPO.goToThisPage();
		travelPO.goInternationalPage();
		travelPO.pickRoundTravel();
		travelPO.insertDestination(originCity, destinationCity);
		travelPO.insertDate(startDate, endDate);
		travelPO.openAdvancedOption();
		travelPO.selectNumberOfAdult(3);
		travelPO.clickSearchButton();
	}

	@BeforeClass(groups = "jdtravel-test")
	public void initTest() throws ParseException {
		driver = new FirefoxDriver();
		mainPO = new MainPageObj(driver);
		travelPO = new InternationalTravelPageObj(driver);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		startDate = sdf.parse(startDateString);
		endDate = sdf.parse(endDateString);
	}

	@BeforeMethod(groups = "jdtravel-test")
	public void initSite() {
		driver.get("http://www.jd.com");
	}

	@AfterClass(groups = "jdtravel-test")
	public void destroyTest() {
		 driver.quit();
	}
}
