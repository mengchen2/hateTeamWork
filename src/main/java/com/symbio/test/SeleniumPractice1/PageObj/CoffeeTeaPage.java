package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CoffeeTeaPage {

	// coffee and tea
	@FindBy(css = ".i3")
	private WebElement beverageBrewingTab;

	//small class link
	@FindBy(css = ".i-ext>a[href='http://list.jd.com/1320-1585-3986-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement coffeeTeaLink;

	//the locator of first Item's image
	@FindBy(css = ".gl-item>div[data-i='1']>.p-img")
	private WebElement nestle;

	//the locator of second Item's image
	@FindBy(css = ".gl-item>div[data-i='2']>.p-img")
	private WebElement witeCoffee;

	// add to cart button item
	@FindBy(css = "#InitCartUrl")
	private WebElement addToCartBtn;

	private AddItemsToCartPage addItemToCart;
	private WebDriver driver;

	public CoffeeTeaPage(AddItemsToCartPage addItemToCart, WebDriver driver) {
		this.driver = driver;
		this.addItemToCart = addItemToCart;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}

	/**
	 * add two Items to the cart
	 */
	public void AddCoffee() {
		addItemToCart.addItemToCart(beverageBrewingTab, coffeeTeaLink, nestle, witeCoffee, addToCartBtn);
	}

}
