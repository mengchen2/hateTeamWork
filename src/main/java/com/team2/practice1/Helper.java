package com.team2.practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	private WebDriver driver;
	private WebDriverWait wait;
	   
	   public void waitPageToPresent(WebDriver driver, final int size, final List<String> existedHandles) {
	     
	    final int tempSize = existedHandles.size();
	    
	    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
	     public Boolean apply(WebDriver arg0) {
	      // TODO Auto-generated method stub
	      if (size > tempSize) {
	       return true;
	      } else {
	       return false;
	      }
	     }
	    });  
	        
	   }
	   
	   public String findNewHandle(WebDriver driver, List<String> existedHandles) {
	    
	    Set<String> handleSet = driver.getWindowHandles();
	    int size = handleSet.size();
	      
	    waitPageToPresent(driver, size, existedHandles);
	    
	    String[] arr = new String[size];
	    arr = handleSet.toArray(arr);
	    
	    
	    List<String> handles = new ArrayList<String>();
	    for (String s : arr) {
	     handles.add(s);
	    }
	    
	    for (String existedHandle : existedHandles) {
	     if (handles.contains(existedHandle)) {
	      handles.remove(existedHandle);
	     }
	    }
	    
	    return handles.get(0); 
	   }
	   
//	   public String switchWindowTo(String title,WebDriver driver) {	   
//		driver.switchTo().defaultContent();
//		Set<String> handles=driver.getWindowHandles();
//		for(String newhandle:handles){
//			driver.switchTo().window(newhandle);
//			if(driver.getTitle()==title){
//				return "true";
//			}
//			else
//			{
//				driver.switchTo().defaultContent();
//			}
//		}
//		return "window not found";
//  
//	}

}
