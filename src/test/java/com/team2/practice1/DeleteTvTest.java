package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test case:Delete Tv
 * 
 * @author Della
 * 
 */

public class DeleteTvTest {

	private WebDriver driver;
	private ProductAdd productAdd;
	private CartPage cartPage;

	@Test
	// Run the test for delete tv
	public void testDeleteTv() {
		productAdd.addAllProductsToCart();
		cartPage.clickDeleteTv();

	}

	@BeforeClass
	// Initialize the object
	public void init() {
		driver = new FirefoxDriver();
		driver.get("http://www.jd.com/");
		productAdd = new ProductAdd(driver);
		cartPage = new CartPage(driver);

	}

	@AfterTest
	// Quit the browser
	public void quit() {
		driver.quit();
	}

}
