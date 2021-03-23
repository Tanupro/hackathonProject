package com.hackathon.insurance.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class MainPageForm extends PageBaseClass{
	

	public MainPageForm(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	
	
	public void selectCountry() {
		enterText("countrySearch_Xpath","france");
		addWait(10);
		elementClick("countrySelect_Xpath");
		logger.log(Status.PASS, "Country selected succesfully");
	}
	
	public void addTraveller(String firstAge, String secondAge) {
		elementClick("travellerLabel_Xpath");
		selectElementByText("firstTravellerAge_Xpath", firstAge);
		logger.log(Status.INFO, "First traveller added");
		elementClick("addTraveller_Btn_Xpath");
		selectElementByText("secondTravellerAge_Xpath", secondAge);
		elementClick("nextButton_Xpath");
		logger.log(Status.INFO, "Second traveller added");
	}
	
	public void selectDate() {
		selectDates("22/05/2021","22/06/2021");
		elementClick("getQuote_Btn_Xpath");
	}
	
	
	public InsuranceList enterPhoneDetails() {
		
		enterText("mobileNumber_Id","9832100000");
		elementClick("getQuote_Btn_Xpath");
		InsuranceList insList = new InsuranceList(driver, logger);
		PageFactory.initElements(driver, insList);
		return insList;
	}
	
}
