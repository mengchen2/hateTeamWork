package com.team2.practice1;

import org.openqa.selenium.WebDriver;

/*
 * ProductAdd class for adding all products to cart, it's a common class, 
 * every team member need it before running test cases
 * 
 * @author bruce
*/

public class ProductAdd {

	private HomePage homePage;
	private AppliancesPage appliancesPage;
	private ItemsPage itemsPage;
	
	//construct method to initialize the variable
	public ProductAdd(WebDriver driver) {
		homePage = new HomePage(driver);
		appliancesPage = new AppliancesPage(driver);
		itemsPage = new ItemsPage(driver);
	}
	
	//add product item to cart
	public void addProductToCart() {
		itemsPage.addItem1ToCart();
		itemsPage.addItem2ToCart();
		itemsPage.switchToAppliancesPage();
	}	
	
	//add all products to cart
	public void addAllProductsToCart() {
		homePage.goToApplicancesPage();
		
		appliancesPage.openTVPage();
		addProductToCart();
		
		appliancesPage.openIceBoxPage(); 
		addProductToCart();
		
		appliancesPage.openWasherPage();
		addProductToCart();
		
		appliancesPage.openAirConditionPage();
		addProductToCart();
		
		appliancesPage.openKitchenSmokePage();
		addProductToCart();
		
		itemsPage.goToCart();
	}
		
}
