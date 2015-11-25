package com.symbio.test.JDTestTravel.PageObj;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.symbio.test.JDTestTravel.helper.ElementUtil;

/**
 * Page for international travel of travel page (jipiao.jd.com)
 * 
 * @author Stephen Raharja
 *
 */
public class InternationalTravelPageObj {

	private WebDriver driver;

	private ElementUtil eUtil;

	@FindBy(id = "fore2")
	private WebElement internationalTravelTab;

	@FindBy(id = "gjdepCity")
	private WebElement startCityTextField;

	@FindBy(id = "gjarrCity")
	private WebElement destinationCityTextField;

	@FindBy(id = "journeyTypert")
	private WebElement travelTypeRadioButton;

	@FindBy(id = "gjdepDate")
	private WebElement startDatePicker;

	@FindBy(id = "gjarrDate")
	private WebElement endDatePicker;

	@FindBy(css = ".fore2 #validQuery")
	private WebElement searchButton;

	@FindBy(id = "adtNum")
	private WebElement adultNumberSelectList;

	@FindBy(id = "morecondition")
	private WebElement advancedOptionPanel;

	/**
	 * Switch to this page
	 */
	public void goToThisPage() {
		eUtil.switchToNewestWindow();
	}

	/**
	 * Switch to international travel
	 */
	public void goInternationalPage() {
		internationalTravelTab.click();
	}

	public InternationalTravelPageObj(WebDriver driver) {
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

	/**
	 * Select the number of traveling adults from dropdown list
	 * 
	 * @param quantity
	 *            Number of adults
	 */
	public void selectNumberOfAdult(int quantity) {
		Select adultNumberDropdown = new Select(adultNumberSelectList);
		for (WebElement option : adultNumberDropdown.getOptions()) {
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
