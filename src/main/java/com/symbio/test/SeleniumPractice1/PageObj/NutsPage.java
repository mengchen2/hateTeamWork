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
	@FindBy(css = ".i-ext>a[href='http://list.jd.com/1320-1583-1591-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement nutsLink;

	//the locator of first Item's image
	@FindBy(css = ".gl-item>div[data-i='1']>.p-img")
	private WebElement huamei;

	//the locator of second Item's image
	@FindBy(css = ".gl-item>div[data-i='2']>.p-img")
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
