package com.symbio.test.SeleniumPractice1.PageObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * page for change the special offer message
 * 
 * @author Amy
 *
 */
public class ChangeSpecialOffersPage {
	@FindBy(css = ".item-form")
	private List<WebElement> selectedItemsList;

	@FindBy(css = ".sales-promotion")
	private WebElement specialOfferButton;

	@FindBy(css = ".promotion-cont>ul>li>input[title*='不使用活动优惠']")
	private WebElement noSpecialOfferRadio;

	@FindBy(css = ".btn-1.select-promotion")
	private WebElement suretButton;

	private WebDriver driver;
	private WebDriverWait wait;

	public ChangeSpecialOffersPage(WebDriver driver) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	/***
	 * change the special offer of items
	 * 
	 * @throws InterruptedException
	 */
	public void changeSpecialOffers() throws InterruptedException {
		int i = 0;
		System.out.println(selectedItemsList.size());

		for (int j = 0; j < selectedItemsList.size(); j++) {
			WebElement currentItemsContainer = selectedItemsList.get(j);
			if (currentItemsContainer.getText().contains("促销优惠")) {

				i++;
				System.out.println("有优惠信息！" + i);
				currentItemsContainer.click();
				currentItemsContainer.findElement(By.cssSelector(".sales-promotion")).click();
				// specialOffer.click();
				System.out.println("点击该按钮" + i);
				// wait.until(ExpectedConditions.visibilityOf(noSpecialOffer));
				// noSpecialOffer.click();
				currentItemsContainer.findElement(By.cssSelector(".promotion-cont>ul>li>input[title*='不使用活动优惠']")).click();
				System.out.println("不使用活动优惠" + i);
				// wait.until(ExpectedConditions.visibilityOf(suretBtn));
				// suretBtn.click();
				currentItemsContainer.findElement(By.cssSelector(".select-promotion")).click();
				System.out.println("确定" + i);
			}
			else{
				i++;
				System.out.println("无优惠活动！" + i);
			}
		}

		System.out.println(i);

	}

}
