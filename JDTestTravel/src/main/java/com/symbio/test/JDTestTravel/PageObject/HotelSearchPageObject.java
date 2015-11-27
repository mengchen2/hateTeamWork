package com.symbio.test.JDTestTravel.PageObject;

import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.symbio.test.JDTestTravel.helper.ElementUtility;

/**
 * Page object for the main hotel page (hotel.jd.com)
 * 
 * @author Stephen Raharja
 *
 */
public class HotelSearchPageObject {

	private WebDriver driver;

	private ElementUtility elementUtil;

	@FindBy(css = "#dest")
	private WebElement destinationCityTextField;

	@FindBy(css = "#startDate")
	private WebElement startDatePicker;

	@FindBy(css = "#endDate")
	private WebElement endDatePicker;

	@FindBy(css = "#search-btn")
	private WebElement searchButton;

	public HotelSearchPageObject(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtility(this.driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
	}

	/**
	 * Insert the name of the destination city
	 * 
	 * @param cityName
	 *            Name of the city
	 */
	public void insertDestinationCity(String cityName) {
		destinationCityTextField.clear();
		destinationCityTextField.sendKeys(cityName);
		destinationCityTextField.sendKeys(Keys.ENTER);

	}

	/**
	 * Insert the start and end date of the hotel booking
	 * 
	 * @param startDate
	 *            Date of the start of booking
	 * @param endDate
	 *            Date of the end of booking
	 */
	public void insertDate(Date startDate, Date endDate) {
		startDatePicker.click();
		elementUtil.clickDate(startDate);

		endDatePicker.click();
		elementUtil.clickDate(endDate);
	}

	/**
	 * Initiate hotel searching
	 */
	public void searchHotel() {
		searchButton.click();
	}

}
