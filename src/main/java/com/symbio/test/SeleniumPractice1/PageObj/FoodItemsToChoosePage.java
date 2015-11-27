package com.symbio.test.SeleniumPractice1.PageObj;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FoodItemsToChoosePage {
	
	private WebDriver dr;
	
	@FindBy(xpath=".//*[@id='plist']/ul/li[1]/div/div[1]/a")
	private WebElement theFirstItem;
	
	@FindBy(xpath=".//*[@id='plist']/ul/li[1]/div")
	private WebElement theFirstProduct;
	
	@FindBy(xpath=".//*[@id='plist']/ul/li[2]/div")
	private WebElement theSecondProduct;
	
	
	@FindBy(xpath=".//*[@id='plist']/ul/li[2]/div/div[1]/a")
	private WebElement theSecondItem;
	
	public WebElement getTheFirstProduct1() {
		return theFirstProduct;
	}
	
	public WebElement getTheSecondProduct1() {
		return theSecondProduct;
	}
	
	public WebElement getTheFirstItem1() {
		return theFirstItem;
	}

	public WebElement getTheSecondItem1() {
		return theSecondItem;
	}

	public FoodItemsToChoosePage(WebDriver dr){
		this.dr =dr;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.dr,50), this);
	}
	
	public void quit() {
			this.dr.quit();
	}
	
}
