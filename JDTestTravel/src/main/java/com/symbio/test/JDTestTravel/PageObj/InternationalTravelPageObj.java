package com.symbio.test.JDTestTravel.PageObj;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.symbio.test.JDTestTravel.helper.ElementUtil;

public class InternationalTravelPageObj extends TravelPageObj {

	private WebDriver driver;

	@FindBy(id = "gjdepCity")
	private WebElement startCityTextField;

	@FindBy(id = "gjarrCity")
	private WebElement destinationCityTextField;

	@FindBy(id = "roundFlight")
	private WebElement travelTypeRadioButton;

	@FindBy(id = "gjdepDate")
	private WebElement startDatePicker;

	@FindBy(id = "gjarrDate")
	private WebElement endDatePicker;

	@FindBy(id = "validQuery")
	private WebElement searchButton;

	@FindBy(id = "adtNum")
	private WebElement adultNumberSelectList;

	@FindBy(id = "morecondition")
	private WebElement advancedOptionPanel;

	public InternationalTravelPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
	}

	public void insertDestination(String source, String destination) {
		startCityTextField.sendKeys(source);
		destinationCityTextField.sendKeys(destination);
	}

	public void insertDate(Date startDate, Date endDate) {
		ElementUtil eUtil = new ElementUtil(driver);
		startDatePicker.click();
		eUtil.clickDate(startDate);

		endDatePicker.click();
		eUtil.clickDate(endDate);
	}

	public void selectNumberOfAdult(int quantity) {
		Select adultNumberDropdown = new Select(adultNumberSelectList);
		for (WebElement option : adultNumberDropdown.getOptions()) {
			if (option.getText().equals(String.valueOf(quantity))) {
				option.click();
				break;
			}
		}
	}

	public void openAdvancedOption() {
		advancedOptionPanel.click();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

}
