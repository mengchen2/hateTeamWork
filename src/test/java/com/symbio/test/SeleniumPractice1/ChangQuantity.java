package com.symbio.test.SeleniumPractice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.symbio.test.SeleniumPractice1.PageObj.GoToCartPage;
import com.symbio.test.SeleniumPractice1.PageObj.AddItemsToCartPage;
import com.symbio.test.SeleniumPractice1.PageObj.SubCategoryPage;
import com.symbio.test.SeleniumPractice1.PageObj.Common;

public class ChangQuantity {

	private WebDriver driver;
	private WebDriverWait wait;
	
	private SubCategoryPage subCategoryPage;

	
	//defined lots of method in this page
	private Common common;
	
	//function pages
	private AddItemsToCartPage addItemToCart;
	private GoToCartPage goToPage;

	@BeforeClass
	public void initDriver() {

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 6);
		common = new Common(driver, wait);

		addItemToCart = new AddItemsToCartPage(driver, wait, common);


		subCategoryPage = new SubCategoryPage(addItemToCart, driver);


		goToPage = new GoToCartPage(driver, common);

	}

	@BeforeMethod
	public void initWebpage() {
		driver.get("http://channel.jd.com/chaoshi.html");
	}


	@Test
	public void test() throws InterruptedException {
		// add two food
		subCategoryPage.addWine();

		// add two coffee
		subCategoryPage.addMilk();

		//add two Grain
		subCategoryPage.addGrain();

		//add two Meat
		subCategoryPage.addMeat();

		//go to the cart page
		goToPage.goToCart();
		
		

		// change the quantity of the product in the cart
		common.modifyProductQuantity(5, 1);
	}
	
	 @AfterClass
	  public void destroyDriver(){
	  driver.quit();
	  }

}
