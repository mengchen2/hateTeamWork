package com.symbio.test.JDTestTravel.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void clickDate(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		WebElement previousMonthButton = driver.findElement(By.cssSelector(".prevMonth"));
		WebElement nextMonthButton = driver.findElement(By.cssSelector(".nextMonth"));

		while (true) {
			// Check target and actual date
			String currYear = driver.findElement(By.cssSelector(".datepicker:nth-child(1) currYs")).getText();
			if (calendar.get(Calendar.YEAR) > Integer.parseInt(currYear)) {
				nextMonthButton.click();
			} else {
				// Check target and actual month
				String currMonth = driver.findElement(By.cssSelector(".datepicker:nth-child(1) currMo")).getText();
				if (calendar.get(Calendar.MONTH) > Integer.parseInt(currMonth)) {
					nextMonthButton.click();
				} else {
					// List all dates of the month
					List<WebElement> dates = driver
							.findElements(By.cssSelector(".datepicker:nth-child(1) tbody td[class='date']"));
					for (WebElement currDate : dates) {
						if (calendar.get(Calendar.DATE) == Integer.parseInt(currDate.getText())) {
							currDate.click();
						}
					}
				}
			}
		}
	}
}
