package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * IncreaseQuantity class for running my testcase
 * @author Bruce
 * 
*/

public class IncreaseQuantity {

	private WebDriver driver;
	private ProductAdd productAdd; 
	private CartPage cartPage;
	
	@Test
	//test case method
	public void increaseQuantityTest() {
		productAdd.addAllProductsToCart();
		cartPage.clickAddAll(driver);		
	}
	
	@BeforeClass
	//initialize the variable
	public void initialize() {
		driver = new FirefoxDriver();
		driver.get("http://www.jd.com/");	
		
		productAdd = new ProductAdd(driver);
		cartPage = new CartPage(driver);
		
	}
	
}
