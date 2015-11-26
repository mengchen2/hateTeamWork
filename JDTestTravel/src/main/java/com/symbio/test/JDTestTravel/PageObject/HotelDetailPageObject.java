package com.symbio.test.JDTestTravel.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.symbio.test.JDTestTravel.helper.ElementUtility;

/**
 * Page object for handling the hotel detail
 * 
 * @author Stephen Raharja
 */
public class HotelDetailPageObject {

	private WebDriver driver;
	
	private ElementUtility elementUtility;
	
	@FindBy(css = "#roomListWrap .bor-details")
	private List<WebElement> roomTypesList;

	public HotelDetailPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 30), this);
		elementUtility = new ElementUtility(driver);
	}
	
	/**
	 * Switch to this new window
	 */
	public void goToThisPage(){
		elementUtility.switchToNewestWindow();
	}
	
	/**
	 * Book the first available room
	 */
	public void bookFirstAvailableRoom(){
		roomTypesList.get(0).findElement(By.cssSelector(".book-order")).click();
	}

}
