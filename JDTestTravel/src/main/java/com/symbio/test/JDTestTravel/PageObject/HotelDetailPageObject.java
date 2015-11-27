package com.symbio.test.JDTestTravel.PageObject;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.symbio.test.JDTestTravel.helper.ElementUtility;

/**
 * Page object for handling the hotel detail
 * 
 * @author Stephen Raharja
 */
public class HotelDetailPageObject {

	private WebDriver driver;
	
	private ElementUtility elementUtility;
	
	@FindBy(css = "#startDate")
	private WebElement startDatePicker;
	
	@FindBy(css = "#endDate")
	private WebElement endDatePicker;
	
	@FindBy(css = "#roomListWrap .bor-details")
	private List<WebElement> roomTypesList;
	
	@FindBy(css = "#searchBtn")
	private WebElement changeDateButton;

	public HotelDetailPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
		elementUtility = new ElementUtility(driver);
	}
	
	/**
	 * Switch to this new window
	 */
	public void goToThisPage(){
		elementUtility.switchToNewestWindow();
	}
	
	/**
	 * Book the first available room
	 */
	public void bookFirstAvailableRoom(){
		roomTypesList.get(0).findElement(By.cssSelector(".book-order")).click();
		waitForChangedDateSearhReload();
	}
	
	/**
	 * start date and end date will be changed and click search button
	 * @param startDate
	 * @param endDate
	 * @throws InterruptedException
	 */
	public void changeHotelBookingDate(Date startDate, Date endDate) throws InterruptedException {
		startDatePicker.click();
		elementUtility.clickDate(startDate);
		Thread.sleep(10000);
		endDatePicker.click();
		elementUtility.clickDate(endDate);
		Thread.sleep(5000);
		changeDateButton.click();
		
	}
	
	/**
	 * wait until the search result is reloaded after choosing new filter
	 */
	private void waitForChangedDateSearhReload() {
		(new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".r-details.bor-details")));
	}

}
