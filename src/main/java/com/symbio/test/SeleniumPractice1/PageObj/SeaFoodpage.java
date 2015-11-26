package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SeaFoodpage {
	WebDriver driver;
	
	
	 public SeaFoodpage(WebDriver driver) {
	 
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
		}
	
	
	
	@FindBy(css=".p-name>a[href='http://item.jd.com/1748725495.html']")
	private WebElement Seafood_top1;
	
	@FindBy(css=".p-name>a[ href='http://item.jd.com/1748725495.html']")
	private WebElement Seafood_top2;
	
	@FindBy(css="#InitCartUrl")
	private WebElement addToCartBtton;
	
	@FindBy(css=".i-ext>a[href='http://channel.jd.com/12218-12222.html']")
	private WebElement seaFood;

	
	public void addSeaFood(){
		Common c = Common.getInstance(driver);
		SuperMarketHomePage homepage = new SuperMarketHomePage(driver);
		
		int oldHandles = driver.getWindowHandles().size();  
		homepage.selectWhichFoodClassToBuy(homepage.getFreshFoodTab1(),seaFood);
		c.waitNewWindow(oldHandles);

/**
 * add the first product
 */
		c.switchToNewWindow();  
		Seafood_top1.click();
		c.switchToNewWindow();
		addToCartBtton.click();
/**
 * add the second product
 */
		c.switchPreviousPage();
		Seafood_top2.click();
		c.switchToNewWindow();
		addToCartBtton.click();
		
	}

}
