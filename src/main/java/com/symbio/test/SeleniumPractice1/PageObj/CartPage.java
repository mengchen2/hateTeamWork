package com.symbio.test.SeleniumPractice1.PageObj;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartPage {
WebDriver driver ;
			 
public CartPage(WebDriver driver) {
					this.driver =driver;
					PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
					}
			 			
			@FindBy(css=".increment")
			private List<WebElement> cartProductList;
			
			public List<WebElement> getCartProductList1() {
				return cartProductList;
			}
			
}

