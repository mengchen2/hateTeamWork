package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SubCategoryPage {

	// coffee and tea
	@FindBy(css = ".i3")
	private WebElement beverageBrewingTab3;

	// Wine
	@FindBy(css = ".i2")
	private WebElement beverageBrewingTab2;

	// Wine
	@FindBy(css = ".i4")
	private WebElement beverageBrewingTab4;

	// Wine
	@FindBy(css = ".i5")
	private WebElement beverageBrewingTab5;

	@FindBy(css = ".i-ext>a[href='http://list.jd.com/1320-1584-2675-0-49035-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement subgrain;

	// Wine
	@FindBy(css = ".i1")
	private WebElement beverageBrewingTab1;

	// small class link
	@FindBy(css = ".i-ext>a[href='http://list.jd.com/1320-1585-9434-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement coffeeTeaLink;

	// the locator of first Item's image
	@FindBy(css = "div[data-i='1']>.p-name>a")
	private WebElement nestle;

	// the locator of second Item's image
	@FindBy(css = "div[data-i='2']>.p-name>a")
	private WebElement witeCoffee;

	// add to cart button item
	@FindBy(css = "#InitCartUrl")
	private WebElement addToCartBtn;

	// sub category link meat;
	@FindBy(css = ".i-ext>a[href='http://list.jd.com/1320-1583-1592-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement meat;

	// sub category link grape wine;
	@FindBy(css = ".i-ext>a[href='http://list.jd.com/12259-12260-9438-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement gragewine;
	
	// sub category link grape wine;
		@FindBy(css = ".i-ext>a[href='http://channel.jd.com/12218-12222.html']")
		private WebElement seaFood;
	
	
	
	private AddItemsToCartPage addItemToCart;
	private WebDriver driver;

	public SubCategoryPage(AddItemsToCartPage addItemToCart, WebDriver driver) {
		this.driver = driver;
		this.addItemToCart = addItemToCart;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),
				this);

	}

	/**
	 * add two Items to the cart
	 * 
	 */
	
	public void addFreshSeaProduct() {
		addItemToCart.addItemToCart(beverageBrewingTab1, seaFood, nestle,
				witeCoffee, addToCartBtn);}
		
	public void addWine() {
		addItemToCart.addItemToCart(beverageBrewingTab2, gragewine, nestle,
				witeCoffee, addToCartBtn);
	}
	public void addMilk() {
		addItemToCart.addItemToCart(beverageBrewingTab3, coffeeTeaLink, nestle,
				witeCoffee, addToCartBtn);
	}

	public void addMeat() {
		addItemToCart.addItemToCart(beverageBrewingTab4, meat, nestle,
				witeCoffee, addToCartBtn);
	}

	public void addGrain() {
		addItemToCart.addItemToCart(beverageBrewingTab5, subgrain, nestle,
				witeCoffee, addToCartBtn);
	}



}
