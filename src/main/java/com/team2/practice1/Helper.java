package com.team2.practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Helper class for making things easier
 * @author Bruce
 * 
*/

public class Helper {
	
	public static List<String> existedHandles = new ArrayList<String>();
			
	//ensure the page present
	public void waitPageToPresent(WebDriver driver, final int size, final List<String> existedHandles) {
			
		final int existedSize = existedHandles.size();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				if (size > existedSize) {
					return true;
				} else {
					return false;
				}
			}
		});			
		
	}
	
	// switch to the new window 
	public String switchToNewWindow(WebDriver driver) {
		
		String curHandle = driver.getWindowHandle();
		Set<String> handleSet = driver.getWindowHandles();
		int size = handleSet.size();
				
		waitPageToPresent(driver, size, existedHandles);
		
		for (String handle : handleSet) {
			if (!handle.equals(curHandle) && !existedHandles.contains(handle)) {
				driver.switchTo().window(handle);
				return handle;
			}
		}
		
		return null;
		
	}
	
	public String switchToNewWindow(WebDriver driver, String tmpString) {
		return switchToNewWindow(driver);
	}
	
	

}
	













