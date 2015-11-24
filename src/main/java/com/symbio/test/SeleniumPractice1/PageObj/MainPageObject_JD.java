package com.symbio.test.SeleniumPractice1.PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MainPageObject_JD {
	private WebDriver driver;

	// food
	@FindBy(xpath = "//*[@id='smCategorys']/div/div[2]/div[1]/div[1]/a[7]")
	private WebElement worldFood;

	@FindBy(xpath = "//*[@id='ProductSpecial']/ul/li[1]/div[1]/a/img")
	private WebElement lobsterImage;

	@FindBy(xpath = "//*[@id='ProductSpecial']/ul/li[5]/div[1]/a/img")
	private WebElement beefImage;

	// wine
	@FindBy(xpath = "//*[@id='smCategorys']/div/div[1]/div[2]/div/a[2]")
	private WebElement wine;

	@FindBy(xpath = "//*[@id='plist']/ul/li[2]/div/div[1]/a/img")
	private WebElement martell;

	@FindBy(xpath = "//*[@id='plist']/ul/li[1]/div/div[1]/a/img")
	private WebElement hennessy;

	// coffee and tea
	@FindBy(xpath = "//*[@id='smCategorys']/div/div[2]/div[3]/div[1]/a[6]")
	private WebElement coffeeTea;

	@FindBy(xpath = "//*[@id='plist']/ul/li[1]/div/div[1]/a/img")
	private WebElement nestle;

	@FindBy(xpath = "//*[@id='plist']/ul/li[18]/div/div[1]/a/img")
	private WebElement witeCoffee;

	// cake
	@FindBy(xpath = "//*[@id='smCategorys']/div/div[1]/div[4]/div/a[1]")
	private WebElement cake;

	@FindBy(xpath = "html/body/div[5]/div/div[5]/div/div/div/div/div/ul/li[2]/div/div[1]/a/img")
	private WebElement huamei;

	@FindBy(xpath = "html/body/div[5]/div/div[5]/div/div/div/div/div/ul/li[5]/div/div[1]/a/img")
	private WebElement Qcui;

	// oil
	@FindBy(xpath = "//*[@id='smCategorys']/div/div[1]/div[5]/div/a[1]")
	private WebElement foodOil;

	@FindBy(xpath = "//*[@id='plist']/ul/li[1]/div/div[1]/a/img")
	private WebElement luHua;

	@FindBy(xpath = "//*[@id='plist']/ul/li[3]/div/div[1]/a/img")
	private WebElement jinLongYu;

	// add to cart button item
	@FindBy(css = "#InitCartUrl")
	private WebElement addToCartBtn;
	
	public MainPageObject_JD(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
	}
	
	

}
