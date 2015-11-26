package com.symbio.test.JDTestTravel.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LogInTestPageObject {

	private WebDriver driver;
		
	@FindBy(css = ".link-login")
	private WebElement UserLogInPage;
	
	@FindBy(css = "#loginname")
	private WebElement txtuserName;
	
	@FindBy(css = "#nloginpwd")
	private WebElement txtPassword;
	
	
	@FindBy(css = "#loginsubmit")
	private WebElement clickSubmit;
	
	
	public LogInTestPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
	}

	
	public void userRegistration() {
		
		txtuserName.sendKeys("15801141345");
		txtPassword.sendKeys("STEPHEN1807!((#");
		clickSubmit.click();	
	}

}
