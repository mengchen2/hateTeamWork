package com.symbio.test.SeleniumPractice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.symbio.test.SeleniumPractice1.PageObj.MainPageObject_JD;

public class AddCare {
	
	private WebDriver driver;

	private MainPageObject_JD mainPageObj_jd;
	@BeforeClass
	public void initDriver() {
		driver = new FirefoxDriver();
		mainPageObj_jd = new MainPageObject_JD(driver);
	}


}
