package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/*
 * ItemPage class for specific appliances page
 * @author bruce
 * */

public class ItemsPage {

	private WebDriver driver;

	@FindBy(css = "div[data-i='1']>.p-operate>.p-o-btn.addcart")
	private WebElement addItem1ToCart;

	@FindBy(css = "div[data-i='2']>.p-operate>.p-o-btn.addcart")
	private WebElement addItem2ToCart;

	@FindBy(css = "#settleup-2014>.cw-icon>a")
	private WebElement goToCart;

	// construct method to initialize the variable
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

	//add the first item of appliances to cart  
	public void addItem1ToCart() {
		addItem1ToCart.click();
	}

	//add the second item of appliances to cart
	public void addItem2ToCart() {
		addItem2ToCart.click();
	}

	//go to cart page
	public void goToCart() {
		goToCart.click();
	}

}
