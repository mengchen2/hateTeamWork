package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FoodDetailPage {
	
	private WebDriver dr;
	
	@FindBy(id="InitCartUrl")
	private WebElement addToCart;
	
	@FindBy(css="#settleup-2014  a")
	private WebElement myCart;
	
	public FoodDetailPage(WebDriver dr){
		this.dr = dr;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.dr,50), this);
	}

	public WebElement getAddToCart1() {
		return addToCart;
	}

	public void setAddToCart(WebElement addToCart) {
		this.addToCart = addToCart;
	}
	
	public WebElement getMyCart1(){
		return myCart;
	}
	
	public void quit(){
			this.dr.quit();
	}
	
	
}
