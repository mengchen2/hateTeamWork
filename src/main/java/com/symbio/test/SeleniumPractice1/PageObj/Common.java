package com.symbio.test.SeleniumPractice1.PageObj;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	private static Common common;
	private WebDriver driver;
	private LinkedList<String> list;
	private WebDriverWait wait;
	private Actions actions;

	public Common(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		actions = new Actions(driver);
		list = new LinkedList<String>();
		this.wait = wait;
		list.add(driver.getWindowHandle());

	}

	public static Common getInstance(WebDriver driver, WebDriverWait wait) {
		if (common == null) {
			return new Common(driver, wait);
		} else {
			return common;
		}
	}

	/**
	 * wait the pops up window
	 * 
	 * @param oldHandles
	 */
	public void waitNewWindow(final int oldHandles) {
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				if (oldHandles != driver.getWindowHandles().size()) {
					return true;
				}
				return false;
			}
		});
	}

	/**
	 * switch to new window
	 */
	public void switchToNewWindow() {

		Set<String> handles = driver.getWindowHandles();
		if (list.size() == handles.size()) {
			return;
		} else {
			for (String win : handles) {
				if (!list.contains(win)) {
					list.add(win);
					driver.switchTo().window(win);
					driver.manage().window().maximize();
				}
			}
		}
	}

	/**
	 * switch to supermarket home page
	 */
	public void switchHomePage() {
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
		// TODO Auto-generated method stub
		// driver.findElement(By.(elementToClick)).click();
		elementToClick.click();
		wait.until(ExpectedConditions.visibilityOf(elementToWait));
	}

	 public void modifyProductQuantity(int modifyNum, int increament ) throws InterruptedException{
		 CartPage cartpage = new CartPage(driver);
		 List<WebElement> plusButtons = cartpage.getCartProductList1();
		 
			
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

}
