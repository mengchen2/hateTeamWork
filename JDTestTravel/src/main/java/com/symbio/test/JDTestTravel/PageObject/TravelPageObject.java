package com.symbio.test.JDTestTravel.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.symbio.test.JDTestTravel.helper.ElementUtility;

/**
 * Page object for travel page
 * 
 * @author Stephen Raharja
 *
 */
public class TravelPageObject {

	private WebDriver driver;

	private ElementUtility elementUtil;

	@FindBy(css = "#j_trip_nav > li > a[href='http://hotel.jd.com/']")
	private WebElement bookHotelLink;

	public TravelPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 15), this);
		elementUtil = new ElementUtility(driver);
	}

	/**
	 * Switch to this page
	 */
	public void goToThisPage() {
		elementUtil.switchToNewestWindow();
	}

	/**
	 * Go to new page to book hotel
	 */
	public void goToBookHotel() {
		bookHotelLink.click();
	}
}
