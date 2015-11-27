package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class WinePage {
	// wine
	@FindBy(css = ".i2")
	private WebElement chineseAndForeignWinesTab;

	//small class link
	@FindBy(css = ".i-ext>a[href='http://list.jd.com/12259-12260-9437-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement wineLink;

	//the locator of first Item's image
	@FindBy(css = ".gl-item>div[data-i='2']>.p-img")
	private WebElement martellImage;

	//the locator of second Item's image
	@FindBy(css = ".gl-item>div[data-i='1']>.p-img")
	private WebElement hennessyImage;

	// add to cart button item
	@FindBy(css = "#InitCartUrl")
	private WebElement addToCartButton;

	private AddItemsToCartPage addItemToCart;
	private WebDriver driver;

	public WinePage(AddItemsToCartPage addItemToCart, WebDriver driver) {
		this.driver = driver;
		this.addItemToCart = addItemToCart;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}

	/**
	 * the method of adding two wine to the cart
	 */
	public void AddWine() {
		addItemToCart.addItemToCart(chineseAndForeignWinesTab, wineLink, martellImage, hennessyImage, addToCartButton);
	}

}
