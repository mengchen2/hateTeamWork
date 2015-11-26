package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class SnacksPage {
	WebDriver driver;
	
	
	 public SnacksPage(WebDriver driver) {
	 
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
		}
	
	@FindBy(css="div[data-i='1']>.p-name>a")
	private WebElement snacks_top1;
	
	@FindBy(css="div[data-i='3']>.p-name>a")
	private WebElement snacks_top2;
	
	@FindBy(css="#InitCartUrl>b")
	private WebElement addToCartBtton;
	
	@FindBy(css=".i-ext>a[href='http://list.jd.com/1320-1583-1592-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement meat;
	
	public void addSnacks(){
		Common common = Common.getInstance(driver);
		SuperMarketHomePage homepage = new SuperMarketHomePage(driver);

		int oldHandles = driver.getWindowHandles().size();  
		homepage.selectWhichFoodClassToBuy(homepage.getSnackFoodsTab1(), meat);
		common.waitNewWindow(oldHandles);

/**
 * add the first product
 */
		common.switchToNewWindow();  
		snacks_top1.click();
		common.switchToNewWindow();
		addToCartBtton.click();
/**
 * add the second product
 */
		common.switchPreviousPage();
		snacks_top2.click();
		common.switchToNewWindow();
		addToCartBtton.click();
		
	}
}
