package com.team2.practice1;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
    private WebDriver driver;
	private WebDriverWait wait;
	
	public Helper() {
		driver = new FirefoxDriver();
		String url = "http://http://www.jd.com";
		driver.get(url);
	}
	
	public void waitElementToPresent(int seconds, WebElement element) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	public void waitPageToPresent(WebDriver driver, final int size) {
		
		ExpectedCondition expectedCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				if (size > 1) {
					return false;
				} else {
					return true;
				}
			}
		};		
		new WebDriverWait(driver, 10).until(expectedCondition);
	    	
	}
	 
	
	public void switchWindow(WebDriver driver) {
		String firstHandle = driver.getWindowHandle();
		String secondHandle = null;
		Set<String> handles = driver.getWindowHandles();
		int size = handles.size();
		
		waitPageToPresent(driver, size);
		
		for (String handle : handles) {
			if (handle != firstHandle) {
				driver.switchTo().window(handle);
				secondHandle = handle;
			}
		}
	}

}
