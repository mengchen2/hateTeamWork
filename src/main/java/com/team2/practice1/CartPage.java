package com.team2.practice1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
	
	@FindBy(css="#increment_8888_1589214_2_13_0_186659013")
	private WebElement addtv;
	
	@FindBy(css="#increment_8888_1503987_1_1_0")
	private WebElement addkitchensmoke;
	
	@FindBy(css="increment_8888_1253192_1_13_0_186659736")
	private WebElement addaircondition;
	
	@FindBy(css="#increment_8888_1353840_1_11_0_186649786")
	private WebElement addwasher;
	
	@FindBy(css="#increment_8888_751624_1_11_0_186649786")
	private WebElement addicebox;
	
	@FindBy(css="#remove_8888_1589214_13_186659013")
	private WebElement removetv;

}
