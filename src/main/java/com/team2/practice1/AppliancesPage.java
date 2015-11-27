package com.team2.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Page object for HouseholdApplicances Page
 * 
 * @author Della
 * 
 */

public class AppliancesPage {

	private WebDriver driver;

	@FindBy(css = ".text>a[title='平板电视']")
	private WebElement tv;

	@FindBy(css = ".text>a[title='空调']")
	private WebElement aircondition;

	@FindBy(css = ".text>a[title='冰箱']")
	private WebElement icebox;

	@FindBy(css = ".text>a[title='洗衣机']")
	private WebElement washer;

	@FindBy(css = ".text>a[title='烟机/灶具']")
	private WebElement kitchenWare;

	// Initialize the page object
	public AppliancesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

	// Click tv link to open tv items page
	public void openTVPage() {
		tv.click();
	}

	// Click icebox link to open icebox items page
	public void openIceBoxPage() {
		icebox.click();
	}

	// Click washer link to open washer items page
	public void openWasherPage() {
		washer.click();
	}

	// Click aircondition link to open aircondition items page
	public void openAirConditionPage() {
		aircondition.click();
	}

	// Click kitchensmoke link to open kitchensmoke items page
	public void openKitchenSmokePage() {
		kitchenWare.click();
	}

}
