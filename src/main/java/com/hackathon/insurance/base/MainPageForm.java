package com.hackathon.insurance.base;


public class MainPageForm{
	public static BasicAutomation baseUi =  new BasicAutomation(); 
	public void selectCountry(String countryName) {
		baseUi.enterText("countrySearch_Xpath", countryName);
		
	}
	
	public void addTraveller(String locatorKey, String age) {
		baseUi.selectElementByText(locatorKey,age);
	}
	
	public void dateSelection() {
		baseUi.elementClick("startDatePick_Xpath");
		baseUi.elementClick("endDatePick_Xpath");
		baseUi.elementClick("getQuoteButton_Id");
	}
	
	public void enterPhoneDetails() {
		baseUi.enterText("mobileNumber_Id","981234567");		
		baseUi.elementClick("getQuoteButton_Id");
	}
	
}
