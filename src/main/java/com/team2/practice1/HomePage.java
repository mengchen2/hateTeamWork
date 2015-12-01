package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(css = "div[data-index='1']>h3>a")
	private WebElement appliances;
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,60),this);
	}
	
	public void goToApplicancesPage(){
		appliances.click();
	}
	
}
