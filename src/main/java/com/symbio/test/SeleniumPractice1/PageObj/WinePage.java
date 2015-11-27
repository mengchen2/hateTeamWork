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
	@FindBy(css = ".item[style='display: block;'] .i-ext :nth-child(1)")
	private WebElement wineLink;

	//the locator of first Item's image
	@FindBy(css = "#plist ul li:nth-child(1) .p-img a")
	private WebElement martell;

	//the locator of second Item's image
	@FindBy(css = "#plist ul li:nth-child(2) .p-img a")
	private WebElement hennessy;

	// add to cart button item
	@FindBy(css = "#InitCartUrl")
	private WebElement addToCartBtn;

	private AddItemsToCartPage addItemToCart;
	private WebDriver driver;

	public WinePage(AddItemsToCartPage addItemToCart, WebDriver driver) {
		this.driver = driver;
		this.addItemToCart = addItemToCart;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}

	public void AddWine() {
		addItemToCart.addItemToCart(chineseAndForeignWinesTab, wineLink, martell, hennessy, addToCartBtn);
	}

}
