package com.symbio.test.JDTestTravel;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.symbio.test.JDTestTravel.PageObj.DomesticTravelPageObj;
import com.symbio.test.JDTestTravel.PageObj.InternationalTravelPageObj;
import com.symbio.test.JDTestTravel.PageObj.MainPageObj;

public class TestCase_Domestic {
	
	private String originCity = "北京";
	private String destinationCity = "上海";

	private String startDateString = "2015-12-25";
	private String endDateString = "2016-01-04";
	
	private Date startDate;
	private Date endDate;
	
	private WebDriver driver;
	 
	private MainPageObj mainPO;
	private DomesticTravelPageObj travelPO; 
	
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
	
	@BeforeClass(groups = "jdtravel-test")
	public void initTest() throws ParseException {
		driver = new FirefoxDriver();
		mainPO = new MainPageObj(driver);
		travelPO = new DomesticTravelPageObj(driver);

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
