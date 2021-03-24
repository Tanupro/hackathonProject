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
		List<WebElement> insuranceProvider = getElementsList("companyList_Xpath"); 
		Iterator<WebElement> priceIterator = lowestPrice.iterator();
		Iterator<WebElement> providerIterator = insuranceProvider.iterator();
		while (priceIterator.hasNext() && providerIterator.hasNext()) {
			WebElement priceElement = (WebElement) priceIterator.next();
			WebElement providerElement = (WebElement) providerIterator.next();
			System.out.print(providerElement.getAttribute("class").replace("Logo", ""));
			System.out.print(" - "+priceElement.getText().replace("₹ ", ""));
			System.out.println();
		}
		
		
	}
}
