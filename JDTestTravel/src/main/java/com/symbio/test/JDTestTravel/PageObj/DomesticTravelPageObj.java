package com.symbio.test.JDTestTravel.PageObj;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.symbio.test.JDTestTravel.helper.ElementUtil;

public class DomesticTravelPageObj {

	private WebDriver driver;
	private ElementUtil eUtil;
	
	@FindBy(css = "#fore1")
	private WebElement domesticTravelTab;
	
	@FindBy(css = "#depCity")
	private WebElement startCityTextField;

	@FindBy(css = "#arrCity")
	private WebElement destinationCityTextField;
	
	@FindBy(css = "#roundFlight")
	private WebElement travelTypeRadioButton;
	
	@FindBy(css = "#depDate")
	private WebElement startDatePicker;

	@FindBy(css = "#arrDate")
	private WebElement endDatePicker;
	
	@FindBy(css = "#validQuery")
	private WebElement searchFlightButton;
	
	
	/**
	 * Switch to this page
	 */
	public void goToThisPage() {
		eUtil.switchToNewestWindow();
	}
	
	public void goDomesticPage() {
		domesticTravelTab.click();
	}
	
	public DomesticTravelPageObj(WebDriver driver) {
		// Initialize driver
		this.driver = driver;

		// Set implicit wait of 20 seconds
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
		eUtil = new ElementUtil(driver);
	}
	/**
	 * Insert place name to both origin and destination textfields
	 * 
	 * @param source
	 *            Origin place name
	 * @param destination
	 *            Destination place name
	 */
	
	public void insertDestination(String source, String destination) {
		startCityTextField.sendKeys(source);
		destinationCityTextField.sendKeys(destination);
	}
	
	/**
	 * Insert start and end date of travel
	 * 
	 * @param startDate
	 * @param endDate
	 */
	
	public void insertDate(Date startDate, Date endDate) {
		startDatePicker.click();
		startDatePicker.click();
		// Using util class to pick date in date picker element
		eUtil.clickDate(startDate);
		eUtil.clickDate(endDate);
	}
	
	/**
	 * Click the radio button for round travel
	 */
	public void pickRoundTravel() {
		travelTypeRadioButton.click();
	}
	
	public void clickSearchButton() {
		searchFlightButton.click();
	}
	
}
