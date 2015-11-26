package com.symbio.test.SeleniumPractice1.PageObj;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class WinePage {
	WebDriver webdriver;
	
	
	 public WinePage(WebDriver driver) {
	 
		this.webdriver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.webdriver, 20), this);
		}
	
	@FindBy(xpath=".//*[@id='plist']/ul/li[1]/div/div[1]/a/img")
	private WebElement liquor1; 
	
	@FindBy(xpath=".//*[@id='plist']/ul/li[2]/div/div[1]/a/img")
	private WebElement liquor2;
	
	@FindBy(css="#InitCartUrl")
	private WebElement addToCartBtton;
	
	public void addLiquor(){
		Common common = Common.getInstance(webdriver);
		SuperMarketHomePage homepage = new SuperMarketHomePage(webdriver);
		
		int oldHandles = webdriver.getWindowHandles().size();  
		homepage.selectWhichFoodClassToBuy(homepage.getCategory_liguor(),homepage.getSubCategory_grape());
		common.waitNewWindow(oldHandles);

/**
 * add the first product
 */
		common.switchToNewWindow();  
		liquor1.click();
		common.switchToNewWindow();
		addToCartBtton.click();
/**
 * add the second product
 */
		common.switchPreviousPage();
		liquor2.click();
		common.switchToNewWindow();
		addToCartBtton.click();
		
	}
	
}
