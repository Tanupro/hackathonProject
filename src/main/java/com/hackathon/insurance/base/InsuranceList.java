package com.hackathon.insurance.base;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class InsuranceList extends PageBaseClass {
	
	public InsuranceList(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	public void sortList() {
		selectElementByText("sortList_Xpath","Price: Low to High");
	}
	
	public void selectTopThree() {
		List<WebElement> lowestPrice = getElementsList("priceList_Xpath"); 
		for (Iterator<WebElement> iterator = lowestPrice.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());
			
		}
	}
}
