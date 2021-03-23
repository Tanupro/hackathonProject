package com.hackathon.insurance.tests;

import org.testng.annotations.Test;

import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.InsuranceList;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class TestClass extends BasicAutomation {
	@Test
	public void testCaseOne() {
		logger = report.createTest("Test Case One");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry();
		mainPage.addTraveller("21 yrs","22 yrs");
		mainPage.selectDate();
		InsuranceList insList = mainPage.enterPhoneDetails();
		insList.sortList();
		insList.selectTopThree();
		
		
	}
}
