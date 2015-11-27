package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/***
 * the function is to go to the cart page
 * @author yilanyezi Amy
 *
 */
public class GoToCartPage {

	@FindBy(css = "#settleup-2014>.cw-icon>a")
	private WebElement goToCartButton;

	private WebDriver driver;
	private Common common;

	public GoToCartPage(WebDriver driver, Common common) {
		this.driver = driver;
		this.common = common;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	/**
	 * go to the cart page
	 */
	public void goToCart() {
		goToCartButton.click();
		common.switchToNewWindow();
	}

}
