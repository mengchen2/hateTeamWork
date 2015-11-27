package com.symbio.test.SeleniumPractice1.PageObj;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * realize the function of adding two same class items to the cart
 * 
 * @author yilanyezi
 * @param <waitItemToCart>
 *
 */
public class AddItemsToCartPage {
	private WebDriver driver;
	private Actions actions;
	private Common common;
	private WebDriverWait wait;
	
	
	@FindBy(css = "#shopping-amount")
	private WebElement amountInCart;

	public AddItemsToCartPage(WebDriver driver, WebDriverWait wait, Common common) {
		this.driver = driver;
		this.wait = wait;
		// this.actions = actions;
		// common=Common.getInstance(driver);
		this.common = common;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
	}
//
//	private void waitItemToCart(WebElement button){
//		final int itemsInCart = Integer.parseInt(amountInCart.getText()); //Here search for all items in the cart and store the size in the variable. 
//		wait.until(ExpectedConditions.visibilityOf(button));
//		
//		button.click();
//		
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(30, TimeUnit.SECONDS);
//		wait.pollingEvery(5, TimeUnit.SECONDS);
//		wait.ignoring(NoSuchElementException.class);
//		
//		wait.until(new Predicate<WebDriver>(){
//			public boolean apply(WebDriver driver) {
//				int currentItemsInCart = Integer.parseInt(driver.findElement(By.cssSelector("#shopping-amount")).getText()); //Here search for all itesm again and store the size.
//				
//				if(currentItemsInCart > itemsInCart) { // only true if 
//					return true;
//				}
//				driver.navigate().refresh();
//				return false;
//			}
//		});
//	}
//	
	/***
	 * the method is to add items to the cart.
	 * 
	 * @param tab
	 *            is the name of major categories
	 * @param link
	 *            is the name of small categories
	 * @param item1
	 *            is the first item you want to add to cart
	 * @param item2
	 *            is the second item you want to add to cart
	 * @param button
	 *            is the add to cart button
	 */
	public void addItemToCart(WebElement tab, WebElement link, WebElement item1, WebElement item2, WebElement button) {

		int oldHandles = driver.getWindowHandles().size();
		// common.selectWhichFoodClassToBuy(tab, link);
		wait.until(ExpectedConditions.visibilityOf(tab));
		common.clickAndwait(tab, link);
		link.click();

		// switch to new window and click the first item
		common.waitNewWindow(oldHandles);
		common.switchToNewWindow();
		oldHandles = driver.getWindowHandles().size();
		wait.until(ExpectedConditions.visibilityOf(item1));
		item1.click();

		// switch to new window and click the button of add to cart
		common.waitNewWindow(oldHandles);
		common.switchToNewWindow();
		wait.until(ExpectedConditions.visibilityOf(button));		
		button.click();
//		driver.close();

		// switch to previous page and click the second item
		common.switchPreviousPage();
		item2.click();

		// switch to new window and click the button of add to cart
		common.switchToNewWindow();
		wait.until(ExpectedConditions.visibilityOf(button));
		
//		waitItemToCart(button);
		button.click();
//		driver.close();
		
		// switch to previous page and click the second item
//		common.switchPreviousPage(3);
//		driver.close();

		// switch to the supermarket page
		common.switchHomePage();
	}

}
