package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MainPageObj {

	private WebDriver driver;

	@FindBy(id = "ui3_city_change")
	private WebElement citySelectorButton;

	@FindBy(name = "北京")
	private WebElement cityBeijingLabel;

	@FindBy(name = "上海")
	private WebElement cityShanghaiLabel;

	@FindBy(id = "subway_menu")
	private WebElement subwayButton;

	@FindBy(id = "route_menu")
	private WebElement navigationButton;

	@FindBy(css = ".bus-tab")
	private WebElement navigationPublicButton;

	@FindBy(id = "bus_start_input")
	private WebElement busStartTextField;

	@FindBy(id = "bus_end_input")
	private WebElement busEndTextField;

	@FindBy(id = "busSearchBtn")
	private WebElement busSearchButton;

	@FindBy(id = "type2")
	private WebElement leastBusStopChangeButton;

	@FindBy(id = "select_type")
	private WebElement trafficSelector;

	@FindBy(css = ".nosubway")
	private WebElement noSubwayLabel;

	@FindBy(css = ".bus_time")
	private WebElement busTimeLabel;

	@FindBy(id = "sub_start_input")
	private WebElement subwayStartTextField;

	@FindBy(id = "sub_end_input")
	private WebElement subwayEndTextField;

	@FindBy(id = "subSearchBtn")
	private WebElement subwaySearchButton;

	@FindBy(id = "btn_uf")
	private WebElement subwayResultExpandButton;

	public MainPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
	}

	/**
	 * Move to Beijing city
	 */
	public void goToBeijing() {
		citySelectorButton.click();
		cityBeijingLabel.click();
	}

	/**
	 * Move to Shanghai city
	 */
	public void goToShanghai() {
		citySelectorButton.click();
		cityShanghaiLabel.click();
	}

	/**
	 * Find the subway path between 2 points
	 * 
	 * @param start
	 *            Name of starting subway station
	 * @param end
	 *            Name of target subway station
	 */
	public void findSubwayPath(String start, String end) {
		subwayButton.click();
		subwayStartTextField.sendKeys(start);
		subwayEndTextField.sendKeys(end);
		subwaySearchButton.click();
		subwayResultExpandButton.click();
	}

	/**
	 * Search the public transport path between 2 points
	 * 
	 * @param start
	 *            Name of starting position
	 * @param end
	 *            Name of target position
	 * @return Total approximated time
	 */
	public String findBusPathTime(String start, String end) {
		navigationButton.click();
		busStartTextField.sendKeys(start);
		busEndTextField.sendKeys(end);
		busSearchButton.click();
		trafficSelector.click();
		noSubwayLabel.click();
		leastBusStopChangeButton.click();
		String result =  busTimeLabel.getText();
		return result;
	}
}
