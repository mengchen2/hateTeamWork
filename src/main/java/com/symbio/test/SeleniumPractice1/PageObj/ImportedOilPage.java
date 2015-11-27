package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ImportedOilPage {

	// oil
	@FindBy(css = ".i5")
	private WebElement oilsHealthTab;

	//small class link
	@FindBy(css = ".i-ext>a[href='http://list.jd.com/1320-5019-5024-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement importedOilLink;

	//the locator of first Item's image
	@FindBy(css = ".gl-item>div[data-i='1']>.p-img")
	private WebElement fuLinMen;

	//the locator of second Item's image
	@FindBy(css = ".gl-item>div[data-i='2']>.p-img")
	private WebElement bellina;

	// add to cart button item
	@FindBy(css = "#InitCartUrl")
	private WebElement addToCartBtn;

	private AddItemsToCartPage addItemToCart;
	private WebDriver driver;

	public ImportedOilPage(AddItemsToCartPage addItemToCart, WebDriver driver) {

		this.driver = driver;
		this.addItemToCart = addItemToCart;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}

	/***
	 * add two Items to the cart
	 */
	public void AddOil() {
		addItemToCart.addItemToCart(oilsHealthTab, importedOilLink, fuLinMen, bellina, addToCartBtn);

	}
}
