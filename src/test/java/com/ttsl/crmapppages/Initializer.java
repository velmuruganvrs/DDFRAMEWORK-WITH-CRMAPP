package com.ttsl.crmapppages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Initializer {
	/*
	 * 
	 * Initialize WEDDRIVER
	 */
	public static WebDriver driver;
	
	/*
	 * 
	 * Initialize PROPERTIES FILE
	 */
	public static FileInputStream fis;
	
	public static  Properties locprop;
	
	public static ExtentHtmlReporter HTMLPATH;
	
	public static ExtentReports report;
	
	public static ExtentTest test;
	public static void openBrowser(String BrowserName) throws Exception
	{
		
		
		HTMLPATH = new ExtentHtmlReporter("D:\\WrokOutSelenium Wrokphase\\CRMDDDFRAMEWORK\\ExtentReport\\Extents_Report.html");
		
		report = new ExtentReports();
		
		report.attachReporter(HTMLPATH);
		
		 fis = new FileInputStream(new File("D:\\WrokOutSelenium Wrokphase\\CRMDDDFRAMEWORK\\src\\test\\resources\\PropertiesFile\\locators.properties"));
		 
		  locprop= new Properties();
		 locprop.load(fis);
		 
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\rivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\rivers\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
		}else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "D:\\rivers\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		
	}
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		DriverFunctions.loadUrl("URL");
		 
	
	}
	
	public static WebElement getElement(String XapthName)
	{
		return driver.findElement(By.xpath(locprop.getProperty(XapthName)));
		
		
	}

}
