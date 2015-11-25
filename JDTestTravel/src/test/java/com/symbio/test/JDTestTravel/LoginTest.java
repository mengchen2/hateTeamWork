package com.symbio.test.JDTestTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symbio.test.JDTestTravel.PageObj.LogInTestPageObj;
import com.symbio.test.JDTestTravel.PageObj.MainPageObj;

public class LoginTest {

	private WebDriver driver;
	private LogInTestPageObj logInTestPageObj;
	private MainPageObj mainPageObj;

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
		logInTestPageObj = new LogInTestPageObj(driver);
		mainPageObj = new MainPageObj(driver);
	}
}
