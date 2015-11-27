package com.team2.practice1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Page object for JD Home Page
 * 
 * @author Della
 * 
 */

public class HomePage {

	private WebDriver driver;
	private String homePageHandle;

	@FindBy(css = "div[data-index='1']>h3>a")
	private WebElement appliancesLink;

	// Initialize the page object
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

	// Click HouseholdApplicances link to open appliance page
	public void goToApplicancesPage() {

		// Get home page handle and add to handles list
		homePageHandle = driver.getWindowHandle();
		Helper.existedHandles.add(homePageHandle);

		appliancesLink.click();

		// Return to applicances page
		Helper helper = new Helper();
		String applicancesPageHandle = helper.switchToNewWindow(driver);
		Helper.existedHandles.add(applicancesPageHandle);
		driver.switchTo().window(applicancesPageHandle);

	}

	// Get home page handle
	public String getHomePageHandle() {
		return homePageHandle;
	}

}
