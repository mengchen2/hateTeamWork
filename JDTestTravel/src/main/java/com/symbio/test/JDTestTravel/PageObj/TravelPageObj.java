package com.symbio.test.JDTestTravel.PageObj;

import java.util.Date;

public abstract class TravelPageObj {
	
	abstract public void insertDestination(String source, String destination);
	
	abstract public void insertDate(Date startDate, Date endDate);
	
	abstract public void clickSearchButton();
}
