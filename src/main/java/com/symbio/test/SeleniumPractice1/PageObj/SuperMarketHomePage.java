package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SuperMarketHomePage {
	
	private WebDriver driver;
	
	
	private Actions actions;
	
	@FindBy(css=".i1")
	private WebElement freshFoodTab;
	
	@FindBy(css=".i2")
	private WebElement ChineseAndForeignWinesTab;
	
	@FindBy(css=".i3")
	private WebElement beverageBrewingTab;
	
	@FindBy(css=".i4")
	private WebElement snackFoodsTab;
	
	@FindBy(css=".i5")
	private WebElement oilsHealthTab;
	
	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[1]/div[1]/a[1]")
	private WebElement importedFruitsLink; 
	
	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[2]/div[1]/a[1]")
	private WebElement whiteWineLink; 
	
	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[3]/div[1]/a[1]")
	private WebElement drinkLink;
	
	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[4]/div[1]/a[1]")
	private WebElement localProductLink;
	
	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[5]/div[1]/a[1]")
	private WebElement soySauceLink;
	
	@FindBy(css="#key")
	private WebElement input;
	
	@FindBy(css="#ttbar-myjd  a")
	private WebElement myCart;
	
	@FindBy(css=".i2")
	private WebElement Category_liguor;
	
	public WebElement getCategory_liguor() {
		return Category_liguor;
	}

	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[2]/div[1]/a[3]")
	private WebElement SubCategory_grape;
	
	
	
	public WebElement getSubCategory_grape() {
		return SubCategory_grape;
	}



	public SuperMarketHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,50), this);
		actions = new Actions(driver);

	}
	
	
	/**
	 * select which food class to click
	 * 
	 * @paragram tab 
	 * 	which element to hover
	 * @param link  
	 *  which one is contained by the first param to click
	 * @throws InterruptedException 
	 */
	public void selectWhichFoodClassToBuy(WebElement tab,WebElement link){
		actions.moveToElement(tab).perform();
		link.click();
	}

	public Actions getActions() {
		return actions;
	}
	

	public void setActions(Actions actions) {
		this.actions = actions;
	}

	public WebDriver getDr() {
		return driver;
	}

	public WebElement getFreshFoodTab1() {
		return freshFoodTab;
	}

	public WebElement getChineseAndForeignWinesTab1() {
		return ChineseAndForeignWinesTab;
	}

	public WebElement getBeverageBrewingTab1() {
		return beverageBrewingTab;
	}

	public WebElement getSnackFoodsTab1() {
		return snackFoodsTab;
	}

	public WebElement getOilsHealthTab1() {
		return oilsHealthTab;
	}

	public WebElement getImportedFruitsLink1() {
		return importedFruitsLink;
	}

	public WebElement getWhiteWineLink1() {
		return whiteWineLink;
	}

	public WebElement getDrinkLink1() {
		return drinkLink;
	}

	public WebElement getLocalProductLink1() {
		return localProductLink;
	}

	public WebElement getSoySauceLink1() {
		return soySauceLink;
	}
	
	public WebElement getInput1(){
		return this.input;
	}
	
	public WebElement getMyCart1(){
		return this.myCart;
	}
}
