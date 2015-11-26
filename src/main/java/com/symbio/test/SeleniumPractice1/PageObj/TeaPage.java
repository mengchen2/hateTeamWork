package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TeaPage {
	WebDriver driver;

	public TeaPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(
				new AjaxElementLocatorFactory(this.driver, 20), this);
	}

	@FindBy(css = "div[data-i='1']>.p-name>a")
	private WebElement Tea_top1;

	@FindBy(css = "div[data-i='2']>.p-name>a")
	private WebElement Tea_top2;

	@FindBy(css = "#InitCartUrl>b")
	private WebElement addToCartBtton;

	@FindBy(css=".i-ext>a[href='http://list.jd.com/1320-1585-9434-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement milk;

	public void addTea() {
		Common common = Common.getInstance(driver);
		SuperMarketHomePage homepage = new SuperMarketHomePage(driver);

		int oldHandles = driver.getWindowHandles().size();
		homepage.selectWhichFoodClassToBuy(homepage.getBeverageBrewingTab1(), milk);
		common.waitNewWindow(oldHandles);

		/**
		 * add the first product
		 */
		common.switchToNewWindow();
		Tea_top1.click();
		common.switchToNewWindow();
		addToCartBtton.click();
		/**
		 * add the second product
		 */
		common.switchPreviousPage();
		Tea_top2.click();
		common.switchToNewWindow();
		addToCartBtton.click();
	}

}
