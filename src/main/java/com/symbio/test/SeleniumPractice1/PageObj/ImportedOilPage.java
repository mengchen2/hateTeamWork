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
	@FindBy(css = ".item[style='display: block;'] .i-ext :nth-child(2)")
	private WebElement importedOilLink;

	//the locator of first Item's image
	@FindBy(css = "#plist ul li:nth-child(2) .p-img a")
	private WebElement fuLinMen;

	//the locator of second Item's image
	@FindBy(css = "#plist ul li:nth-child(1) .p-img a")
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
	 * @throws InterruptedException 
	 */
	public void AddOil() throws InterruptedException {
		addItemToCart.addItemToCart(oilsHealthTab, importedOilLink, fuLinMen, bellina, addToCartBtn);

	}
}
