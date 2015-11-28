package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemsToCartPage {
	private WebDriver driver;
	private Common common;
	private WebDriverWait wait;

	public AddItemsToCartPage(WebDriver driver, WebDriverWait wait,
			Common common) {
		this.driver = driver;
		this.wait = wait;
		this.common = common;
		PageFactory.initElements(
				new AjaxElementLocatorFactory(this.driver, 20), this);
	}

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
	public void addItemToCart(WebElement tab, WebElement link,
			WebElement item1, WebElement item2, WebElement button) {

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

		// switch to previous page and click the second item
		common.switchPreviousPage();
		item2.click();

		// switch to new window and click the button of add to cart
		common.switchToNewWindow();
		wait.until(ExpectedConditions.visibilityOf(button));
		button.click();

		// switch to the supermarket page
		common.switchHomePage();
	}

}
