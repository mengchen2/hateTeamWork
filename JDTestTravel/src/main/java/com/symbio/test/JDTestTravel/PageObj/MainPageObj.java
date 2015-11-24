package com.symbio.test.JDTestTravel.PageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageObj {

	@FindBy(css = "a[href='http://jipiao.jd.com/']")
	private WebElement travelLink;
	
	public void goToTravel(){
		travelLink.click();
	}
	
}
