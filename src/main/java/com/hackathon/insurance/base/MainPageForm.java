package com.hackathon.insurance.base;



public class MainPageForm extends BasicAutomation{

	public void selectCountry() {
		elementClick("countrySelect_Xpath");
	}
	
	public void addTraveller(String locatorKey, String age) {
		selectElementByText(locatorKey,age);
	}
	
	public void dateSelection() {
		elementClick("startDatePick_Xpath");
		elementClick("endDatePick_Xpath");
		elementClick("getQuoteButton_Id");
	}
	
	public void enterPhoneDetails() {
		enterText("mobileNumber_Id","981234567");		
		elementClick("getQuoteButton_Id");
	}
	
}
