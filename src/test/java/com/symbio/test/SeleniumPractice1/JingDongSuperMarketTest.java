package com.symbio.test.SeleniumPractice1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symbio.test.SeleniumPractice1.PageObj.AddItemsToCartPage;
import com.symbio.test.SeleniumPractice1.PageObj.ChangeSpecialOffersPage;
import com.symbio.test.SeleniumPractice1.PageObj.CoffeeTeaPage;
import com.symbio.test.SeleniumPractice1.PageObj.Common;
import com.symbio.test.SeleniumPractice1.PageObj.GlobalFoodPage;
import com.symbio.test.SeleniumPractice1.PageObj.GoToCartPage;
import com.symbio.test.SeleniumPractice1.PageObj.ImportedOilPage;
import com.symbio.test.SeleniumPractice1.PageObj.NutsPage;
import com.symbio.test.SeleniumPractice1.PageObj.WinePage;


public class JingDongSuperMarketTest {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//define page variable element
	private GlobalFoodPage globalFoodPage;
	private WinePage winePage;
	private CoffeeTeaPage coffeeTeaPage;
	private NutsPage nutsPage;
	private ImportedOilPage importedOilPage;
	
	//defined lots of method in this page
	private Common common;
	
	//function pages
	private AddItemsToCartPage addItemToCart;
	private GoToCartPage goToPage;
	private ChangeSpecialOffersPage changeSpecialOffersPage;
	
	@BeforeClass

	public void init() throws InterruptedException {
		

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 6);
		common = new Common(driver, wait);

		addItemToCart = new AddItemsToCartPage(driver, wait, common);
		globalFoodPage = new GlobalFoodPage(addItemToCart, driver);
		winePage = new WinePage(addItemToCart, driver);

		coffeeTeaPage = new CoffeeTeaPage(addItemToCart, driver);
		nutsPage = new NutsPage(addItemToCart, driver);
		importedOilPage = new ImportedOilPage(addItemToCart, driver);

		goToPage = new GoToCartPage(driver, common);
		changeSpecialOffersPage = new ChangeSpecialOffersPage(driver);
	}

	@BeforeMethod
	public void initWebpage() {
		driver.get("http://channel.jd.com/chaoshi.html");
	}




	@Test
	public void test() throws InterruptedException {
		// add two food
		globalFoodPage.addFood();

		// add two wine
		winePage.AddWine();

		// add two coffee
		coffeeTeaPage.AddCoffee();

		// add two nuts
		nutsPage.AddNuts();

		// add teo oil
		importedOilPage.AddOil();

		
	}
	
	@Test(dependsOnMethods={"test"})
	public void deleteFruitsProduct(){
		// go to myCart page
		goToPage.goToCart();
		
		// get delete button from all fruits
		List<WebElement> fruitsDeleteElements = changeSpecialOffersPage.searchFromProductList(".cell.p-ops :nth-child(1)", new String[]{"果","个"});
		
		// click delete button
		for(WebElement w:fruitsDeleteElements){
			w.click();
			changeSpecialOffersPage.clickConfirmDeleteButton();
		}
		
		// verify if the fruits is deleted
		fruitsDeleteElements = changeSpecialOffersPage.searchFromProductList(".cell.p-ops :nth-child(1)", new String[]{"果","个"});
		int size = fruitsDeleteElements.size();
		Assert.assertEquals(size, 0);
	}
	

}
