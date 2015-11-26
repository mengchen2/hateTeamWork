package com.symbio.test.JDTestTravel.PageObject;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.symbio.test.JDTestTravel.helper.ElementUtility;

/**
 * Page for international travel of travel page (jipiao.jd.com)
 * 
 * @author Stephen Raharja
 *
 */
public class InternationalTravelPageObject {

	private WebDriver driver;

	private ElementUtility elementUtil;

	@FindBy(css = "#fore2")
	private WebElement internationalTravelTab;

	@FindBy(css = "#gjdepCity")
	private WebElement startCityTextField;

	@FindBy(css = "#gjarrCity")
	private WebElement destinationCityTextField;

	@FindBy(css = "#journeyTypert")
	private WebElement travelTypeRadioButton;

	@FindBy(css = "#gjdepDate")
	private WebElement startDatePicker;

	@FindBy(css = "#gjarrDate")
	private WebElement endDatePicker;

	@FindBy(css = ".fore2 #validQuery")
	private WebElement searchButton;

	@FindBy(css = "#adtNum")
	private WebElement adultNumberSelectList;

	@FindBy(css = "#morecondition")
	private WebElement advancedOptionPanel;

	/**
	 * Switch to this page
	 */
	public void goToThisPage() {
		elementUtil.switchToNewestWindow();
	}

	/**
	 * Switch to international travel
	 */
	public void goInternationalPage() {
		internationalTravelTab.click();
	}

	public InternationalTravelPageObject(WebDriver driver) {
		// Initialize driver
		this.driver = driver;

		// Set implicit wait of 20 seconds
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
		elementUtil = new ElementUtility(driver);
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
		elementUtil.clickDate(startDate);
		elementUtil.clickDate(endDate);
	}

	/**
	 * Click the radio button for round travel
	 */
	public void pickRoundTravel() {
		travelTypeRadioButton.click();
	}

	/**
	 * Select the number of traveling adults from dropdown list
	 * 
	 * @param quantity
	 *            Number of adults
	 */
	public void selectNumberOfAdult(int quantity) {
		Select adultNumberDropdown = new Select(adultNumberSelectList);
		
		//Looping each option
		for (WebElement option : adultNumberDropdown.getOptions()) {
			
			//Check the value if equal to the quantity
			if (option.getAttribute("value").equals(String.valueOf(quantity))) {
				option.click();
				break;
			}
		}
	}

	/**
	 * Expand travel query form to show more options
	 */
	public void openAdvancedOption() {
		advancedOptionPanel.click();
	}

	/**
	 * Initiate search
	 */
	public void clickSearchButton() {
		searchButton.click();
	}

}
