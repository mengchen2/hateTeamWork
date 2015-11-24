package com.team2.practice1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(css = ".item.fore1.hover>h3>a")
	private WebElement householdappliances;
	
	public void goToHouseholdApplicances(){
		this.householdappliances.click();
	}
	
}
