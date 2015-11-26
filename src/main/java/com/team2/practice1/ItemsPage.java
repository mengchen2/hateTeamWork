package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ItemsPage {

	private WebDriver driver;

	@FindBy(css = "div[data-i='1']>.p-operate>.p-o-btn.addcart")
	private WebElement addItem1ToCart;

	@FindBy(css = "div[data-i='2']>.p-operate>.p-o-btn.addcart")
	private WebElement addItem2ToCart;

	@FindBy(css = "#settleup-2014>.cw-icon>a")
	private WebElement goToCart;

	public ItemsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

	public void addItem1ToCart() {
		addItem1ToCart.click();
	}

	public void addItem2ToCart() {
		addItem2ToCart.click();
	}

	public void goToCart() {
		goToCart.click();
	}

}
