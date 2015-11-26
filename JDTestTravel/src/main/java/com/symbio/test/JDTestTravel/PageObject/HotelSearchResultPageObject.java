package com.symbio.test.JDTestTravel.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page object for handling the hotel search result
 * 
 * @author Stephen Raharja
 *
 */
public class HotelSearchResultPageObject {

	private WebDriver driver;

	@FindBy(css = ".prices a[data-price='600+']")
	private WebElement sixHundredMorePriceLabel;

	@FindBy(css = ".stars .list input[value='5']")
	private WebElement fiveStarHotelCheckbox;

	@FindBy(css = ".facility .list input[data-val='免费wifi']")
	private WebElement freeWifiCheckbox;

	@FindBy(css = "#roomList .btn")
	private WebElement firstHotelBookingButton;

	@FindBy(css = "#filter .tuijian li:nth-child(2)")
	private WebElement priceSortLabel;

	public HotelSearchResultPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
	}

	/**
	 * Check the checkbox of hotel priced above 600
	 */
	public void filterHotelPriceAboveSixHundred() {
		sixHundredMorePriceLabel.click();
		waitForSearchReload();
	}

	/**
	 * Check the checkbox for 5 stars hotel
	 */
	public void filterHotelFiveStar() {
		fiveStarHotelCheckbox.click();
		waitForSearchReload();

	}

	/**
	 * Check the checkbox for hotel with free wifi
	 */
	public void filterHotelFreeWifi() {
		freeWifiCheckbox.click();
		waitForSearchReload();
	}

	/**
	 * Click the book hotel button of the first hotel in the list
	 */
	public void bookFirstHotel() {
		firstHotelBookingButton.click();
		waitForSearchReload();
	}

	/**
	 * Book the first hotel with the highest ranking
	 */
	public void bookHighestRatedHotel() {

		// Get all hotel containers
		List<WebElement> hotelList = driver.findElements(By.cssSelector("#roomList .hotellist"));

		// Initiate button element with the first book button
		WebElement highestRatedHotelButton = driver.findElement(By.cssSelector("#roomList .btn"));

		float currentRatingFloat = 0;
		float highestRatingFloat = 0;

		// Looping through all containers
		for (WebElement currentHotelContainer : hotelList) {

			String currentRatingString;

			// If rating is not found, set rating to 0
			if (currentHotelContainer.findElements(By.cssSelector(".pleased .per .a")).isEmpty()) {
				currentRatingString = "0";
			} else {
				currentRatingString = currentHotelContainer.findElement(By.cssSelector(".pleased .per .a")).getText();
			}

			currentRatingFloat = Float.parseFloat(currentRatingString);

			// Compare current rating with the highest rating stored
			if (highestRatingFloat < currentRatingFloat) {
				// Change the button to the highest one
				highestRatedHotelButton = currentHotelContainer.findElement(By.cssSelector(".price .btn"));
			}
		}

		highestRatedHotelButton.click();
	}

	/**
	 * Click the sort by price button, so hotel are sorted by price in ascending
	 * order
	 */
	public void sortHotelByPriceAscending() {
		priceSortLabel.click();
	}

	/**
	 * Wait until the search result is reloaded after choosing new filter
	 */
	private void waitForSearchReload() {
		(new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".hotellist")));
	}
}
