package com.symbio.test.JDTestTravel.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class for navigating and using certain complex elements in travel
 * page
 * 
 * @author Stephen Raharja
 *
 */
public class ElementUtility {

	private WebDriver driver;

	public ElementUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Pick the targeted date from date picker element in travel page
	 * 
	 * @param date
	 *            Targeted date
	 */
	public void clickDate(Date date) {

		// Get the opened date picker
		WebElement currentDatePicker = getActiveElement(".o-datepicker");

		// Initialize calendar
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Make sure that the date picker is loaded
		WebElement nextMonthButton = currentDatePicker.findElement(By.cssSelector(".nextMonth"));

		while (true) {

			// Wait date picker is loaded
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector((".currYs"))));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector((".nextMonth"))));

			// Get current year string
			String currentYearString = currentDatePicker.findElement(By.cssSelector("table:nth-child(1) .currYs"))
					.getText();

			// Go to next loop if can't get the year string
			if (currentYearString.isEmpty()) {
				// If loops infinitely, add wait to methods calling
				// this method
				continue;
			}

			// If targeted year is larger, move to the next month
			if (calendar.get(Calendar.YEAR) > Integer.parseInt(currentYearString)) {
				nextMonthButton.click();
			} else {
				// Check target and actual month
				String currentMonthString = currentDatePicker.findElement(By.cssSelector("table:nth-child(1) .currMo"))
						.getText();

				// If targeted month is larger, move to the next month
				if (calendar.get(Calendar.MONTH) > Integer.parseInt(currentMonthString) - 1) {
					nextMonthButton.click();
				} else {
					// List all dates of the month
					List<WebElement> dateList = currentDatePicker
							.findElements(By.cssSelector("table:nth-child(1) tbody td.date"));

					// Get all available dates, and pick the targeted one
					for (WebElement currentDateElement : dateList) {
						String currentDateString = currentDateElement.getAttribute("day");
						if (calendar.get(Calendar.DATE) == Integer.parseInt(currentDateString)) {
							currentDateElement.click();
							return;
						}
					}
				}
			}
		}
	}

	/**
	 * If there are multiple elements which some are active and some hidden with
	 * the same locator, get the first visible one
	 * 
	 * @param locator
	 *            Common CSS selector locator
	 * @return First visible element
	 */
	private WebElement getActiveElement(String locator) {
		List<WebElement> elementList = driver.findElements(By.cssSelector(locator));

		for (WebElement element : elementList) {
			if (element.isDisplayed()) {
				return element;
			}
		}

		return elementList.get(0);
	}

	/**
	 * Switch to the newest opened window
	 */
	public void switchToNewestWindow() {
		Set<String> handles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();

		for (String handle : handles) {
			{
				if (!handle.equals(currentHandle)) {
					driver.switchTo().window(handle);
				}
			}
		}
	}

}
