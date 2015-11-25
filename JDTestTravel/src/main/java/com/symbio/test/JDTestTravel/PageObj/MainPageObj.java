package com.symbio.test.JDTestTravel.PageObj;

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
public class MainPageObj {

	@FindBy(css = "a[href='http://jipiao.jd.com/']")
	private WebElement travelLink;

	private WebDriver driver;

	public MainPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 15), this);
	}

	public void goToTravel() {
		travelLink.click();
	}
}
