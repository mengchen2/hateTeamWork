package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GlobalFoodPage {

	// food table 
	@FindBy(css = ".i1")
	private WebElement freshFoodTab;

	//small class link
	@FindBy(css = ".i-ext>a[href='http://channel.jd.com/12218-12220.html']")
	private WebElement globalFoodLink;

	//the locator of first Item's image
	@FindBy(css = ".fore.fore1>.p-img>a[title*='海鲜']")
	private WebElement lobsterImage;

	//the locator of second Item's image
	@FindBy(css = ".fore.fore1>.p-img>a[title*='牛排']")
	private WebElement beefImage;

	// add to cart button item
	@FindBy(css = "#InitCartUrl")
	private WebElement addToCartBtn;

	private AddItemsToCartPage addItemToCart;
	private WebDriver driver;

	/**
	 * food page
	 * 
	 * @param addItemToCart
	 * @param driver
	 */
	public GlobalFoodPage(AddItemsToCartPage addItemToCart, WebDriver driver) {
		this.driver = driver;
		this.addItemToCart = addItemToCart;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	/**
	 * add two food to the cart
	 */
	public void addFood() {
		addItemToCart.addItemToCart(freshFoodTab, globalFoodLink, lobsterImage, beefImage, addToCartBtn);
	}

}
