package com.hackathon.insurance.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.InsuranceList;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class TestClass extends BasicAutomation {
	//@Test
	public void testCaseOne() {
		logger = report.createTest("Test Case One");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails();
		insList.sortList();
		insList.selectTopThree();

	}
	
	//@Test
	public void TC001() {
		logger = report.createTest("Test Case One");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.isElementPresent("getQuote_Btn_Xpath");
		mainPage.verifyPageTitle("PolicyBazaar Travel Insurance");
	}
	//@Test
	public void TC002() {
		logger = report.createTest("Test Case Two");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.selectCountry("Germany");
	}
	//@Test
	public void TC003() {
		logger = report.createTest("Test Case Three");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.selectCountry("France");
	}
	//@Test
	public void TC004() {
		logger = report.createTest("Test Case Four");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.selectCountry("Germany");
		//mainPage.selectCountry("France");
	}
	@Test
	public void TC005() {
		logger = report.createTest("Test Case Five");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		driver.findElement(By.xpath("//*[@id=\'GetQuoteButton\']")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//@Test
	public void TC006() {
		logger = report.createTest("Test Case Six");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.selectCountry("France");
		mainPage.addTraveller("21 yrs","22 yrs");
	}
	//@Test
	public void TC007() {
		logger = report.createTest("Test Case Seven");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.selectCountry("France");
		mainPage.addTraveller("21 yrs","22 yrs");
		
		
	}	
}
