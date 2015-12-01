package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/*
 * CartPage class for cart page
 * @author bruce
 * */

public class CartPage {

	private WebDriver driver;
	private final String cmnLocator = ">.item-last.item-item.item-selected>.item-form>.cell.p-quantity>.quantity-form>";

	@FindBy(css = "#remove_8888_1510479_13_186659052")
	private WebElement deleteTV1;

	@FindBy(css = "#remove_8888_1589214_13_186659013")
	private WebElement deleteTV2;

	@FindBy(css = ".btn-9.select-remove")
	private WebElement deleteButton;

	@FindBy(css = "#product_promo_186659052" + cmnLocator + "a[id='increment_8888_1510479_1_13_0_186659052']")
	private WebElement tv1Plus;

	@FindBy(css = "#product_promo_186659013" + cmnLocator + "a[id='increment_8888_1589214_1_13_0_186659013']")
	private WebElement tv2Plus;

	@FindBy(css = "#product_promo_186659736" + cmnLocator + "a[id='increment_8888_1253197_1_13_0_186659736']")
	private WebElement airCondition1Plus;

	@FindBy(css = "#product_promo_186659736" + cmnLocator + "a[id='increment_8888_1253192_1_13_0_186659736']")
	private WebElement airCondition2Plus;

	
	// construct method to initialize the variable
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

	// increase the quantity of every product
	public void clickAddAll() {
		tv1Plus.click();
		tv2Plus.click();
		airCondition1Plus.click();
		airCondition2Plus.click();
	}

	// delete the first TV in the cart
	public void clickDeleteTv1() {
		deleteTV1.click();
		deleteButton.click();
	}

	// delete the second TV in the cart
	public void clickDeleteTv2() {
		deleteTV2.click();
		deleteButton.click();
	}

}
