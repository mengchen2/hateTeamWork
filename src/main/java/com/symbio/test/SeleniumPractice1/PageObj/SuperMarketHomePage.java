package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SuperMarketHomePage {
	
	private WebDriver dr;
	
	
	private Actions actions;
	
	@FindBy(css=".i1")
	private WebElement freshFoodTab;
	
	@FindBy(css=".i2")
	private WebElement chineseAndForeignWinesTab;
	
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
	
	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[4]/div[1]/a[2]")
	private WebElement nutsLink;
	
	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[5]/div[1]/a[1]")
	private WebElement soySauceLink;
	
	@FindBy(xpath=".//*[@id='smCategorys']/div/div[2]/div[5]/div[1]/a[2]")
	private WebElement riceAndFlourLink;
	
	@FindBy(css="#key")
	private WebElement input;
	
	@FindBy(css="#ttbar-myjd  a")
	private WebElement myCart;
	
	
	
	public SuperMarketHomePage(WebDriver dr){
		this.dr = dr;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.dr,50), this);
		actions = new Actions(dr);

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
		return dr;
	}

	public WebElement getFreshFoodTab1() {
		return freshFoodTab;
	}

	public WebElement getChineseAndForeignWinesTab1() {
		return chineseAndForeignWinesTab;
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
	
	public WebElement getNutsLink1(){
		return this.nutsLink;
	}
	
	public WebElement getRiceAndFlourLink1(){
		return this.riceAndFlourLink;
	}
	
	public void quit(){
		
			this.dr.quit();
	
			
	}
}
