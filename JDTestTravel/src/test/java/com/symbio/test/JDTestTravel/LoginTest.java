package com.symbio.test.JDTestTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symbio.test.JDTestTravel.PageObject.LogInTestPageObject;
import com.symbio.test.JDTestTravel.PageObject.MainPageObject;

public class LoginTest {

	private WebDriver driver;
	private LogInTestPageObject logInTestPageObj;
	private MainPageObject mainPageObj;

	@Test(groups = "jdtravel-test")
	public void test() {
		mainPageObj.goToLoginPage();
		logInTestPageObj.userRegistration();
		System.out.println("Sucessfully LogIn");

	}

	@BeforeMethod(groups = "jdtravel-test")
	public void initSite() {
		driver.get("http://www.jd.com");
	}

	@BeforeClass(groups = "jdtravel-test")
	public void initDriver() {
		driver = new FirefoxDriver();
		logInTestPageObj = new LogInTestPageObject(driver);
		mainPageObj = new MainPageObject(driver);
	}
}
