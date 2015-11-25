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
public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Pick the targeted date from date picker element in travel page
	 * 
	 * @param date
	 *            Targeted date
	 */
	public void clickDate(Date date) {

		// Initialize calendar
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		// Make sure that the date picker is loaded
		WebElement nextMonthButton = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".nextMonth")));

		while (true) {
			// Check target and actual date
			String currYear = wait
					.until(ExpectedConditions
							.presenceOfElementLocated(By.cssSelector(".o-datepicker table:nth-child(1) .currYs")))
					.getText();

			// If targeted year is larger, move to the next month
			if (calendar.get(Calendar.YEAR) > Integer.parseInt(currYear)) {
				nextMonthButton.click();
			} else {
				// Check target and actual month
				String currMonth = driver.findElement(By.cssSelector(".o-datepicker table:nth-child(1) .currMo"))
						.getText();

				// If targeted month is larger, move to the next month
				if (calendar.get(Calendar.MONTH) > Integer.parseInt(currMonth) - 1) {
					nextMonthButton.click();
				} else {
					// List all dates of the month
					List<WebElement> dates = driver
							.findElements(By.cssSelector(".o-datepicker table:nth-child(1) tbody td.date"));

					// Get all available dates, and pick the targeted one
					for (WebElement currDate : dates) {
						String currDateString = currDate.getText();
						if (calendar.get(Calendar.DATE) == Integer.parseInt(currDateString)) {
							currDate.click();
							return;
						}
					}
				}
			}
		}
	}

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
