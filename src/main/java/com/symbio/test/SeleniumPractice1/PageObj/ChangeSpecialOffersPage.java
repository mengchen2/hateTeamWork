package com.symbio.test.SeleniumPractice1.PageObj;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeSpecialOffersPage {
	@FindBy(css = ".item-form")
	private List<WebElement> selectedItemsList;

	@FindBy(css = ".sales-promotion")
	private WebElement specialOffer;

	@FindBy(css = ".promotion-cont>ul>li>input[title*='不使用活动优惠']")
	private WebElement noSpecialOffer;

	@FindBy(css = ".btn-1.select-promotion")
	private WebElement suretBtn;
	
	@FindBy(css=".item-form")
	private List<WebElement> productList;
	

	@FindBy(css=".ui-dialog-content .op-btns.ac :nth-child(1)")
	private WebElement confirmButton;

	private WebDriver driver;
	private WebDriverWait wait;
	
	

	public ChangeSpecialOffersPage(WebDriver driver) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	/***
	 * change the special offer of items
	 * @throws InterruptedException 
	 */
	public void changeSpecialOffers() throws InterruptedException {
		int i=0;
		System.out.println(selectedItemsList.size());
		
		for(int j=0;j<selectedItemsList.size();j++){
			WebElement currentItemsContainer = selectedItemsList.get(j);
			if (currentItemsContainer.getText().contains("促销优惠")){
				
				i++;
//				System.out.println("有优惠信息！" + i);	
				currentItemsContainer.click();
				currentItemsContainer.findElement(By.cssSelector(".sales-promotion")).click();
//				specialOffer.click();
				System.out.println("点击该按钮" + i);
//				wait.until(ExpectedConditions.visibilityOf(noSpecialOffer));
//				noSpecialOffer.click();
				currentItemsContainer.findElement(By.cssSelector(".promotion-cont>ul>li>input[title*='不使用活动优惠']")).click();
				System.out.println("不使用活动优惠" + i);
//				wait.until(ExpectedConditions.visibilityOf(suretBtn));
//				suretBtn.click();
				currentItemsContainer.findElement(By.cssSelector(".select-promotion")).click();
				System.out.println("确定" + i);
			}	
		}
		
		
//		for (WebElement currentItemsContainer : selectedItemsList) {
//			if (currentItemsContainer.getText().contains("促销优惠")){
//				
//				i++;
////				System.out.println("有优惠信息！" + i);	
//				currentItemsContainer.click();
//				currentItemsContainer.findElement(By.cssSelector(".sales-promotion")).click();
////				specialOffer.click();
//				System.out.println("点击该按钮" + i);
////				wait.until(ExpectedConditions.visibilityOf(noSpecialOffer));
////				noSpecialOffer.click();
//				currentItemsContainer.findElement(By.cssSelector(".promotion-cont>ul>li>input[title*='不使用活动优惠']")).click();
//				System.out.println("无优惠" + i);
////				wait.until(ExpectedConditions.visibilityOf(suretBtn));
////				suretBtn.click();
//				currentItemsContainer.findElement(By.cssSelector(".select-promotion")).click();
//			
//			}	
////			else{
////				System.out.println("无优惠活动");
////				continue;
////			}
//				
////			System.out.println(i);
//		}
		System.out.println(i);

	}
	
	public List<WebElement> searchFromProductList(String cssLocator){
		List<WebElement> filterElementList = new LinkedList<WebElement>(); 
		for(WebElement w:productList){
			filterElementList.add(w.findElement(By.cssSelector(cssLocator)));
		}
		return filterElementList;
	}
	
	
	public List<WebElement> searchFromProductList(String cssLocator ,String[] textConditions){
		List<WebElement> filterElementList = new LinkedList<WebElement>(); 
		boolean flag = true;
		for(WebElement w:productList){
			flag = true;
			for(String c:textConditions){
				if(!w.getText().contains(c)){
					flag = false;
				}
			}
			if(flag){
				filterElementList.add(w.findElement(By.cssSelector(cssLocator)));
			}
		}
		return filterElementList;
	}
	
	public void clickConfirmDeleteButton(){
		this.confirmButton.click();
	}

}
