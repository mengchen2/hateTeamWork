package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class AppliancesPage {
	
	private WebDriver driver;
	
	@FindBy(css=".text>a[title='平板电视']")
	private WebElement tv;
		
	@FindBy(css=".text>a[title='空调']")
	private WebElement aircondition;
	
	@FindBy(css=".text>a[title='冰箱']")
	private WebElement icebox;
	
	@FindBy(css=".text>a[title='洗衣机']")
	private WebElement washer;

	@FindBy(css=".text>a[title='烟机/灶具']")
	private WebElement kitchensmoke;
	
	
	public AppliancesPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,60),this);
	}
	
	public void openTvPage(){	
		tv.click();
	}
	
	public void openIceBoxPage(){
		icebox.click();
	}
	
	public void openWasherPage(){
		washer.click();
	}
	
	public void openAirConditionPage(){
		aircondition.click();
	}

	public void openKitchenSmokePage(){
		kitchensmoke.click();
	}
	
}
