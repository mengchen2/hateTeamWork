package com.team2.prcatice1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.team2.practice1.AppliancesPage;
import com.team2.practice1.CartPage;
import com.team2.practice1.Helper;
import com.team2.practice1.HomePage;
import com.team2.practice1.ItemsPage;


public class TestDeleteItems{

	private WebDriver driver;
	private Helper helper;	
	private WebDriverWait wait;
	
	private HomePage homePage;
	private AppliancesPage appliancesPage;
	private ItemsPage addToCartPage;
	private CartPage cartPage;
	
	
	public TestDeleteItems(){
		driver=new FirefoxDriver();
		driver.get("http://www.jd.com/");
		homePage=new HomePage(driver);
		appliancesPage=new AppliancesPage(driver);
		addToCartPage=new ItemsPage(driver);
		cartPage=new CartPage(driver);
		helper=new Helper();
	}
	
	@Test
	public void test(){
		homePage.goToApplicancesPage();
		helper.switchWindowTo("家用电器-大家电_生活电器_个护健康_五金家装_厨房电器-京东",driver);
//		String current=driver.getWindowHandle();
//		list.add(current);
//		driver.switchTo().window(c.findNewHandle(driver,list));
		
		appliancesPage.openTvPage();
		addToCartPage.addItem1ToCart();
		addToCartPage.addItem2ToCart();
		driver.navigate().back();
		
		appliancesPage.openAirConditionPage();
		addToCartPage.addItem1ToCart();
		driver.navigate().back();
		
		appliancesPage.openIceBoxPage();
		addToCartPage.addItem1ToCart();
		driver.navigate().back();
		
		appliancesPage.openWasherPage();
		addToCartPage.addItem1ToCart();
		driver.navigate().back();
		
		appliancesPage.openKitchenSmokePage();
		addToCartPage.addItem1ToCart();
		driver.navigate().back();
		
		driver.navigate().refresh();
		addToCartPage.goToCart();
		helper.switchWindowTo("我的购物车 - 京东商城", driver);
//		String current1=driver.getWindowHandle();
//		list.add(current1);
//		driver.switchTo().window(c.findNewHandle(driver,list));
		driver.manage().window().maximize();
		
		//cartPage.clickAddAll();
		
		cartPage.clickDeleteTv1();
		
		cartPage.clickDeleteTv2();
	}
	

}
