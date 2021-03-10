package com.hackathon.insurance.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hackathon.insurance.utils.DateUtils;
import com.hackathon.insurance.utils.ExtentReportManager;

public class BasicAutomation {
	public WebDriver driver;
	public Properties prop;
	public ExtentTest logger;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	
	
	SoftAssert softAssert = new SoftAssert();
	
	/******************************************* Invoke Browser ***********************************************/
	public void invokeBrowser(String browserName) {
		try
		{
			if(browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
						"\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("Mozila")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
						"\\src\\test\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + 
						"\\src\\test\\resources\\drivers\\operadriver.exe");
				driver = new OperaDriver();
			}
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			
			if(prop==null) {
				prop = new Properties();
				try {
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\ObjectRepositiory\\projectConfig.properties");
					prop.load(file);
				} catch (Exception e) {
					reportFail(e.getMessage());
				}
			}
		
	}
	
	/********************************************* Open URL ******************************************************/
	public void openURL(String websiteURLKey) {
		try {
			driver.get(prop.getProperty(websiteURLKey));
			reportPass(websiteURLKey + " Identified Successfully");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/********************************************* Close Browser ******************************************************/
	public void tearDown() {
		driver.close();
	}
	
	/********************************************* Quit Browser ******************************************************/
	public void quitBrowser() {
		driver.quit();
	}
	
	/********************************************* Enter Text ******************************************************/
	public void enterText(String xpathKey, String dataKey) {
		try {
			getElement(xpathKey).sendKeys(dataKey);
			reportPass(dataKey+ " Entered successfully in locator element : " + xpathKey);
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	/********************************************* Element Click ******************************************************/
	public void elementClick(String xpathKey) {
		try {
			getElement(xpathKey).click();
			reportPass("Element clicked successfully");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/********************************************* Get Element ******************************************************/
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		try {
			 if(locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				logger.log(Status.INFO,"Locator identified "+ locatorKey );
			}
			
			else if(locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				logger.log(Status.INFO,"Locator identified "+ locatorKey );
			}
			
			else if(locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				logger.log(Status.INFO,"Locator identified "+ locatorKey );
			}
			 
			else if(locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				logger.log(Status.INFO,"Locator identified "+ locatorKey );
			}
			else {
				reportFail("Failing the test case invalid locator: " + locatorKey);
			}
		}
		catch (Exception e) {

			// Fail the TestCase and Report the error
			reportFail(e.getMessage());
			e.printStackTrace();
			
			Assert.fail("Test case failed"+e.getMessage());
		}
		return element;
	}
	
	//Get Multiple Elements
	
	public List<WebElement> getElementsList(String locatorKey) {
		List<WebElement> element = new ArrayList<WebElement>();
		try {
			if(locatorKey.endsWith("_Id")) {
				element = driver.findElements(By.id(prop.getProperty(locatorKey)));
				logger.log(Status.INFO,"Locator identified "+ locatorKey );
			}
			
			else if(locatorKey.endsWith("_Xpath")) {
				element = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
				logger.log(Status.INFO,"Locator identified "+ locatorKey );
			}
			
			else if(locatorKey.endsWith("_CSS")) {
				element = driver.findElements(By.cssSelector(prop.getProperty(locatorKey)));
				logger.log(Status.INFO,"Locator identified "+ locatorKey );
			}
			
			else if(locatorKey.endsWith("_Name")) {
				element = driver.findElements(By.name(prop.getProperty(locatorKey)));
				logger.log(Status.INFO,"Locator identified "+ locatorKey );
			}
			else {
				reportFail("Failing the test case invalid locator: " + locatorKey);
			}
		}
		catch (Exception e) {
			
			// Fail the TestCase and Report the error
			reportFail(e.getMessage());
			e.printStackTrace();
			
			Assert.fail("Test case failed"+e.getMessage());
		}
		return element;
	}
	/******************************************* SELECT ELEMENT ***********************************************/
	///SELECT by visible text
	public void selectElementByText(String locatorKey, String textValue) {
		Select select = null;
		select = new Select(getElement(locatorKey));
		select.selectByVisibleText(textValue);
	}
	
	///Select by Index
	public void selectElementByIndex(String locatorKey, int index) {
		Select select = null;
		select = new Select(getElement(locatorKey));
		select.selectByIndex(index);
	}
	
	/******************************************* VERIFY ELEMENT ***********************************************/
	public boolean isElementPresent(String locatorKey) {
		try {
			if(getElement(locatorKey).isDisplayed()) 
				reportPass(locatorKey+" Element is displayed");
				return true;
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		return false;
	}
	
	public boolean isElementSelected(String locatorKey) {
		try {
			if(getElement(locatorKey).isSelected()) 
				reportPass(locatorKey+" Element is displayed");
			return true;
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		return false;
	}
	
	public boolean isElementEnabled(String locatorKey) {
		try {
			if(getElement(locatorKey).isEnabled()) 
				reportPass(locatorKey+" Element is displayed");
			return true;
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
		return false;
	}
	
	/******************************************* Assertion Function ***********************************************/
	public void assertTrue(boolean flag) {
		softAssert.assertTrue(flag);
	}
	
	public void assertFalse(boolean flag) {
		softAssert.assertFalse(flag);
	}
	
	public void assertEquals(String actual, String expected) {
		softAssert.assertEquals(actual, expected);
	}
	
	/******************************************* TEST REPORT ***********************************************/
	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenshotOnFailure();
		Assert.fail(reportString);
	}
	
	@AfterMethod
	public void afterTest() {
		softAssert.assertAll();
	}
	
	/******************************************* Take Screenshot ***********************************************/
	public void takeScreenshotOnFailure() {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"\\screeshots\\"+DateUtils.dateFormatstamp()+".png");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\screeshots\\"+DateUtils.dateFormatstamp()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
