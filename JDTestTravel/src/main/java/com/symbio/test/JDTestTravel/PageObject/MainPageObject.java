package com.symbio.test.JDTestTravel.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * www.jd.com main page
 * 
 * @author Stephen Raharja
 *
 */
public class MainPageObject {

	@FindBy(css = "a[href='http://jipiao.jd.com/']")
	private WebElement travelLink;

	@FindBy(css = "#ttbar-login .link-login")
	private WebElement loginPageLink;

	private WebDriver driver;

	public MainPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 15), this);
	}

	/**
	 * Go to travel page
	 */
	public void goToTravel() {
		travelLink.click();

	}

	/**
	 * Go to login page
	 */
	public void goToLoginPage() {
		loginPageLink.click();

	}
}
