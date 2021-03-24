package com.hackathon.insurance.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class MainPageForm extends PageBaseClass{
	

	public MainPageForm(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	
	
	public void selectCountry(String country) {
		selectCountrySearch(country);
		logger.log(Status.PASS, "Country selected succesfully");
	}
	
	public void addTraveller(String firstAge, String secondAge) {
		try{
			elementClick("travellerLabel_Xpath");
			selectElementByText("firstTravellerAge_Xpath", firstAge);
			logger.log(Status.INFO, "First traveller added");
			elementClick("addTraveller_Btn_Xpath");
			selectElementByText("secondTravellerAge_Xpath", secondAge);
			elementClick("nextButton_Xpath");
			logger.log(Status.INFO, "Second traveller added");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void selectDate(String startDate, String endDate) {
		///The date format MUST BE IN "dd/mm/yyyy" FORMAT///
		try{
			selectDates(startDate,endDate);
			elementClick("getQuote_Btn_Xpath");
			reportPass("Dates selected Succesfully");
		}
		catch(Exception e ) {
			reportFail(e.getMessage());
		}
		
	}
	
	
	public InsuranceList enterPhoneDetails() {
		
		enterText("mobileNumber_Id","9832100000");
		elementClick("getQuote_Btn_Xpath");
		InsuranceList insList = new InsuranceList(driver, logger);
		PageFactory.initElements(driver, insList);
		return insList;
	}
	
}
