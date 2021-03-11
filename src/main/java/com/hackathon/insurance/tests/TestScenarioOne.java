package com.hackathon.insurance.tests;


import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.hackathon.insurance.base.BasicAutomation;


public class TestScenarioOne extends BasicAutomation {
	
	@Test
	public void testCaseOne() {
		
		logger = report.createTest("Test case one");
		invokeBrowser("chrome");
		openURL("websiteURL");
		elementClick("travelInsurance_div_Xpath");
		addWait(10);
		
		
		///////Entering main page
		enterText("countrySearch_Xpath", "france");
		enterKey("countrySelect_Xpath");
		elementClick("travellerLabel_Xpath");
		selectElementByText("firstTravellerAge_Xpath","21 yrs");
		elementClick("addTraveller_Btn_Xpath");
		selectElementByText("secondTravellerAge_Xpath","22 yrs");
		elementClick("nextButton_Xpath");
		getByJavascript("startDatePick_Xpath");
		getByJavascript("endDatePick_Xpath");
		elementClick("getQuote_Btn_Xpath");
		enterText("mobileNumber_Id","9832456789");
		elementClick("getQuote_Btn_Xpath");
		
		////Insurance List Page
		selectElementByText("sortList_Xpath","Price: Low to High");
		addWait(20);
		ArrayList<WebElement> priceList = (ArrayList<WebElement>) getElementsList("priceList_Xpath");
		System.out.println(priceList.get(0));
		System.out.println(priceList.get(1));
		System.out.println(priceList.get(2));
		
		///Close
		tearDown();
	}
	
	@AfterTest
	public void endReport() {
		report.flush();
	}
}
