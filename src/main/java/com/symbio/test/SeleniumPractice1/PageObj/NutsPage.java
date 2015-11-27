package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class NutsPage {

	// nuts
	@FindBy(css=".i4")
	 private WebElement snackFoodsTab;

	//small class link
	@FindBy(css = ".item[style='display: block;'] .i-ext :nth-child(2)")
	private WebElement nutsLink;

	//the locator of first Item's image
	@FindBy(css = "#plist ul li:nth-child(2) .p-img a")
	private WebElement huamei;

	//the locator of second Item's image
	@FindBy(css = "#plist ul li:nth-child(1) .p-img a")
	private WebElement Qcui;

	// add to cart button item
	@FindBy(css = "#InitCartUrl")
	private WebElement addToCartBtn;
	
	private AddItemsToCartPage addItemToCart;
	private WebDriver driver;

	public NutsPage(AddItemsToCartPage addItemToCart, WebDriver driver) {
		this.driver = driver;
		this.addItemToCart = addItemToCart;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	/**
	 * add two Items to the cart
	 */
	public void AddNuts() {
		addItemToCart.addItemToCart(snackFoodsTab, nutsLink, huamei, Qcui, addToCartBtn);
	}

}
