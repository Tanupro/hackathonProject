package com.hackathon.insurance.base;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hackathon.insurance.utils.ExtentReportManager;

public class BasicAutomation {
	public WebDriver driver;
	public static Properties prop;
	public ExtentTest logger;
	public ExtentReports report = ExtentReportManager.getReportInstance();


	/***********************************************
					Invoke Browser
	 ***********************************************/
	public void invokeBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Mozilla")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\operadriver.exe");
				driver = new OperaDriver();
			} else {
				System.out.println("No browser Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\ObjectRepositiory\\projectConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	/******************************************************
	 					Open URL
	 ******************************************************/
	public void openURL(String websiteURLKey) {
		try {
			driver.get(prop.getProperty(websiteURLKey));
			System.out.println(websiteURLKey + " Identified Successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/******************************************************
	 					Close Browser
	 ******************************************************/
	public void tearDown() {
		driver.close();
	}

	/*******************************************************
	 					Add Wait
	 ******************************************************/
	public void addWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/******************************************************
	  					Quit Browser
	 ******************************************************/
	public void quitBrowser() {
		driver.quit();
	}

	/********************************************************
	   					Enter Text 
	 *******************************************************/
	public void enterText(String xpathKey, String dataKey) {
		try {
			getElement(xpathKey).sendKeys(dataKey);
			System.out.println(dataKey+ " Entered successfully in locator element : " + xpathKey);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterKey(String xpathKey) {
		try {

			getElement(xpathKey).sendKeys(Keys.ENTER);
			System.out.println("Entered successfully in locator element : " + xpathKey);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*******************************************************
	 				Element Click
	 ******************************************************/
	public void elementClick(String xpathKey) {
		try {
			getElement(xpathKey).click();
			System.out.println("Element clicked successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*******************************************************
	  					JavaScript Executor
	 ******************************************************/
	public void clickByJavascript(String locatorKey) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement jsElement = getElement(locatorKey);
		jse.executeScript("arguments[0].click()", jsElement);
	}

	/******************************************************
	 					Get Element
	 ******************************************************/
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				
			}

			else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				
			}

			else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				
			}

			else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				
			} else {
				System.out.println("Not Found");
				
			}
		} catch (Exception e) {

			// Fail the TestCase and Report the error
			System.out.println(e.getMessage());
			e.printStackTrace();

			Assert.fail("Test case failed" + e.getMessage());
		}
		return element;
	}

	/*******************************************************
	                Get Multiple Elements
	 ******************************************************/

	public List<WebElement> getElementsList(String locatorKey) {
		List<WebElement> element = new ArrayList<WebElement>();
		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElements(By.id(prop.getProperty(locatorKey)));
				
			}

			else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
				
			}

			else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElements(By.cssSelector(prop.getProperty(locatorKey)));
				
			}

			else if (locatorKey.endsWith("_Name")) {
				element = driver.findElements(By.name(prop.getProperty(locatorKey)));
				
			} else {
				System.out.println("Not FOUND");
			}
		} catch (Exception e) {

			// Fail the TestCase and Report the error
			System.out.println(e.getMessage());
			e.printStackTrace();

			Assert.fail("Test case failed" + e.getMessage());
		}
		return element;
	}
	
	

	/************************************************
	 			VERIFY ELEMENT
	 ***********************************************/
	public boolean isElementPresent(String locatorKey) {
		try {
			if (getElement(locatorKey).isDisplayed())
				System.out.println(locatorKey + " Element is displayed");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean isElementSelected(String locatorKey) {
		try {
			if (getElement(locatorKey).isSelected())
				System.out.println(locatorKey + " Element is displayed");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean isElementEnabled(String locatorKey) {
		try {
			if (getElement(locatorKey).isEnabled())
				System.out.println(locatorKey + " Element is displayed");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	/************************************************
					After Methods
 	***********************************************/
	
	@AfterMethod
	public void flushReports() {
		report.flush();
		tearDown();
	}
	


	
}
