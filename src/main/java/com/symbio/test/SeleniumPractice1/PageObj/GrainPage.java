package com.symbio.test.SeleniumPractice1.PageObj;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GrainPage {
WebDriver driver;

	 public GrainPage(WebDriver driver) {
	 
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
		}
	
	@FindBy(xpath=".//*[@id='plist']/ul/li[1]/div/div[1]/a/img")
	private WebElement grain_top1; 
	
	@FindBy(xpath=".//*[@id='plist']/ul/li[2]/div/div[1]/a/img")
	private WebElement grain_top2;
	
	@FindBy(css="#InitCartUrl>b")
	private WebElement addToCartBtton;
	
	@FindBy(css=".i-ext>a[href='http://list.jd.com/1320-1584-2675-0-49035-0-0-0-0-0-1-1-1-1-1-72-4137-0.html']")
	private WebElement subgrain;
	
	@FindBy(css="#settleup-2014>.cw-icon>a")
	private WebElement goToCartButton;
	
	public void addGrain(){
		Common common = Common.getInstance(driver);
		SuperMarketHomePage homepage = new SuperMarketHomePage(driver);
		
		int oldHandles = driver.getWindowHandles().size();  
		homepage.selectWhichFoodClassToBuy(homepage.getOilsHealthTab1(),subgrain);
		common.waitNewWindow(oldHandles);
		

/**
 * add the first product
 */
		common.switchToNewWindow();  
		grain_top1.click();
		common.switchToNewWindow();
		addToCartBtton.click();
/**
 * add the second product
 */
		common.switchPreviousPage();
		grain_top2.click();
		common.switchToNewWindow();
		addToCartBtton.click();
		oldHandles = driver.getWindowHandles().size();  
		goToCartButton.click();
		common.waitNewWindow(oldHandles);
		common.switchToNewWindow();
	}
	
}
