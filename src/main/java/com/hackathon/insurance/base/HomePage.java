package com.hackathon.insurance.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class HomePage extends PageBaseClass {
	
	public HomePage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
	}
	
	
	public MainPageForm clickIns() {
		handleAd("adClose_Btn_Xpath");
		clickByJavascript("travelInsurance_div_Xpath");
		logger.log(Status.INFO, "Clicking to travel insurance page");
		MainPageForm mainPage = new MainPageForm(driver, logger);
		logger.log(Status.INFO, "Navigated to Main form page");
		PageFactory.initElements(driver, mainPage);
		return mainPage;
	}
	
}
