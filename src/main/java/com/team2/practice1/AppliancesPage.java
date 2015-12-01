package com.team2.practice1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppliancesPage {
	
	@FindBy(css=".cw-icon>a")
	private WebElement gotocart;
	
	@FindBy(css=".blank")
	private WebElement bigha;
	
	@FindBy(css=".fore1>a[title='平板电视']")
	private WebElement tv;
	
	@FindBy(css=".fore1>a[title='三门冰箱']")
	private WebElement icebox;
	
	@FindBy(css=".fore1>a[title='滚筒洗衣机']")
	private WebElement washer;
	
	@FindBy(css=".fore1>a[title='壁挂空调']")
	private WebElement aircondition;

	@FindBy(css=".fore1>a[title='欧式烟灶']")
	private WebElement kitchensmoke;
	

}
