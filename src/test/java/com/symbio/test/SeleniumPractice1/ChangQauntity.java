package com.symbio.test.SeleniumPractice1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.symbio.test.SeleniumPractice1.PageObj.Common;
import com.symbio.test.SeleniumPractice1.PageObj.SeaFoodpage;
import com.symbio.test.SeleniumPractice1.PageObj.TeaPage;
import com.symbio.test.SeleniumPractice1.PageObj.GrainPage;
import com.symbio.test.SeleniumPractice1.PageObj.WinePage;
import com.symbio.test.SeleniumPractice1.PageObj.SnacksPage;

@Test
public class ChangQauntity {
	WebDriver webdriver;
	WinePage liquopage;
	SeaFoodpage seafoodpage;
	SnacksPage snackspage;
	TeaPage teapage;
	GrainPage grainpage;
	
	
	@BeforeClass
	public void init() {
		
		//System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		webdriver = new FirefoxDriver();
		liquopage = new WinePage(webdriver);
		snackspage = new SnacksPage(webdriver);
		seafoodpage = new SeaFoodpage(webdriver);
		teapage = new TeaPage(webdriver);
		grainpage = new GrainPage(webdriver);

	}

		
	 @Test
	 public void AddToCart() throws InterruptedException{
	 Common common = Common.getInstance(webdriver);
	 //Open JD supermarket
	 webdriver.get("http://channel.jd.com/chaoshi.html");
	
	 // add two wine
	 liquopage.addLiquor();
	 
	 //add two sea food
	 common.switchHomePage();
	 seafoodpage.addSeaFood();
	 
	 //add two Snack
	 common.switchHomePage();
	 snackspage.addSnacks();
	 
	 //add two kinds of tea
	 common.switchHomePage();
	 teapage.addTea();
	 
	 //add two grain
	 common.switchHomePage();
	 grainpage.addGrain();
	
	 // change the quantity of the product in the cart
	 Thread.sleep(5000);
	 common.modifyProductQuantity(5, 1);

	 }
		
		
	
	// @AfterClass
	// public void closeDriver(){
	// this.webdriver.quit();
	// }

}
