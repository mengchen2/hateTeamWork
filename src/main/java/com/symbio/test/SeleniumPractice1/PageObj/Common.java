package com.symbio.test.SeleniumPractice1.PageObj;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Common {
	
 private static Common common;
 private WebDriver driver;
 private LinkedList<String> list;
 private int handles;
 private WebDriverWait wait;

 private Common(WebDriver driver){
  this.driver = driver;
  list = new LinkedList<String>();
  handles = 1;
  list.add(driver.getWindowHandle());
//  System.out.println(driver.getWindowHandle());
  wait = new WebDriverWait(this.driver,100);
  
 }
 
 public void modifyProductQuantity(int modifyNum, int increament ) throws InterruptedException{
	 CartPage cartpage = new CartPage(driver);
	 List<WebElement> plusButtons = cartpage.getCartProductList1();
	 System.out.println(plusButtons);
	 
//	 int increament1 = increament;
		
		// iterates the first 5 plusButtons
		for(int i = 0;i< modifyNum;i++){
			
			// modify every product quantity
			for(int ii = 0;ii< increament;ii++){
				plusButtons.get(i).click();
				Thread.sleep(5000);
			}
			increament++;
		}
		
	 

 }
 
 
 public static Common getInstance(WebDriver driver){
  if(common==null){
   return new Common(driver);
  }else{
   return common;
  }
 }
 
 public void waitNewWindow(final int oldHandles){
  wait.until(new ExpectedCondition<Boolean>(){
   public Boolean apply(WebDriver driver) {
    if(oldHandles!=driver.getWindowHandles().size()){
     return true;
    }
    return false;
   }
  });
 }
 
 
 public void switchToNewWindow(){
  
  Set<String> set = driver.getWindowHandles();
  if(handles == set.size()){
   return;
  }else{
   for(String newhandle:set){
    if(!list.contains(newhandle)){
     list.add(newhandle);
     driver.switchTo().window(newhandle);
     driver.manage().window().maximize();
    }
   }
  }
 }
 
 public void switchHomePage(){
	 driver.switchTo().window(list.get(0));
	 driver.manage().window().maximize();
 }
 
 public void switchPreviousPage(){
	 driver.switchTo().window(list.get(list.size()-2));
 }
 
}