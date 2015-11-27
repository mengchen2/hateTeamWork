package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Page object for goods Page
 * 
 * @author Della
 * 
 */

public class ItemsPage {

	private WebDriver driver;
	private Helper helper = new Helper();
	private String itemHandle = null;

	@FindBy(css = "div[data-i='1']>.p-operate>.p-o-btn.addcart")
	private WebElement addItem1ToCart;

	@FindBy(css = "div[data-i='2']>.p-operate>.p-o-btn.addcart")
	private WebElement addItem2ToCart;

	@FindBy(css = "#settleup-2014>.cw-icon>a")
	private WebElement goToCart;

	// Initialize the page object
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

	// Add first item to cart by click add to cart link
	public void addItem1ToCart() {
		addItem1ToCart.click();
		helper.switchToNewWindow(driver);
		driver.close();

	}

	// Add second item to cart by click add to cart link
	public void addItem2ToCart() {
		itemHandle = Helper.existedHandles.get(1);
		driver.switchTo().window(itemHandle);

		addItem2ToCart.click();
		helper.switchToNewWindow(driver);
		driver.close();
	}

	// Switch to appliances page
	public void switchToAppliancesPage() {
		String appliancesHandle = itemHandle;
		driver.switchTo().window(appliancesHandle);
		driver.navigate().back();
	}

	// Click cart link to open cart page
	public void goToCart() {
		driver.switchTo().window(itemHandle);
		goToCart.click();
		String cartHandle = helper.switchToNewWindow(driver);
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
