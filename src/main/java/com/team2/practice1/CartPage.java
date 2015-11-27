package com.team2.practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Page object for Cart Page
 * 
 * @author Della
 * 
 */

public class CartPage {

	private WebDriver driver;

	@FindBy(css = "#remove_8888_1510479_13_186659052")
	private WebElement deleteTV1;

	@FindBy(css = "#remove_8888_1589214_13_186659013")
	private WebElement deleteTV2;

	@FindBy(css = ".btn-9.select-remove")
	private WebElement deleteButton;

	@FindBy(css = ".increment")
	private List<WebElement> addBtnContainer;

	// Initialize the page object
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

	// Add items quantity by click '+' button
	public void clickAddAll(WebDriver driver) {

		int size = addBtnContainer.size();

		for (int i = 0; i < size; ++i) {
			addBtnContainer.get(i).click();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Delete items(TV) by click delete link
	public void clickDeleteTv() {
		deleteTV1.click();
		deleteButton.click();
		deleteTV2.click();
		deleteButton.click();
	}

}
