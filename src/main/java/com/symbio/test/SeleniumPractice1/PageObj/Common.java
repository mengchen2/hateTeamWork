package com.symbio.test.SeleniumPractice1.PageObj;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	
	private static Common c;
	private WebDriver driver;
	private LinkedList<String> list;
	private int handles;
	private WebDriverWait wait;
	private Actions actions;
	private Common(WebDriver driver){
		this.driver = driver;
		list = new LinkedList<String>();
		handles = 1;
		list.add(driver.getWindowHandle());
		wait = new WebDriverWait(this.driver,100);
		actions = new Actions(driver);
		
	}
	public Common(WebDriver driver,WebDriverWait wait){
		this.driver = driver;
		list = new LinkedList<String>();
		handles = 1;
		list.add(driver.getWindowHandle());
		this.wait = wait;
		actions = new Actions(driver);
		
	}
	
	public static Common getInstance(WebDriver driver){
		if(c==null){
			return new Common(driver);
		}else{
			return c;
		}
	}
	
	public void waitNewWindow(final int oldHandles){
		wait.until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver dr) {
				if(oldHandles!=dr.getWindowHandles().size()){
					return true;
				}
				return false;
			}
		});
	}

	/**
	 * switch to new window
	 */	
	
	public void switchToNewWindow(){
		
		Set<String> set = driver.getWindowHandles();
		if(handles == set.size()){
			return;
		}else{
			for(String h:set){
				if(!list.contains(h)){
					list.add(h);
					handles++;
					driver.switchTo().window(h);
					driver.manage().window().maximize();
				}
			}
		}
	}

	/**
	 * switch to supermarket home page
	 */
	public void switchHomePage() {
		for(int i= list.size()-1;i>0;i--){
			driver.switchTo().window(list.get(i));
			driver.close();
			list.remove(list.get(i));
		}
		driver.switchTo().window(list.get(0));
		driver.manage().window().maximize();
	}

	/**
	 * switch to previous page
	 */
	public void switchPreviousPage() {
		driver.switchTo().window(list.get(list.size() - 2));
	}

	/**
	 * select which food to buy
	 * 
	 * @param tab
	 * @param link
	 */
	public void selectWhichFoodClassToBuy(WebElement tab, WebElement link) {
		actions.moveToElement(tab).perform();
		wait.until(ExpectedConditions.visibilityOf(link));
		link.click();
	}

	/**
	 * do the click and wait for another webelement
	 * 
	 * @param elementToClick
	 * @param elementToWait
	 */
	public void clickAndwait(WebElement elementToClick, WebElement elementToWait) {
		// driver.findElement(By.(elementToClick)).click();
		elementToClick.click();
		wait.until(ExpectedConditions.visibilityOf(elementToWait));
	}
}
