package com.ttsl.crmapplogintestcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.ttsl.crmapppages.DriverFunctions;
import com.ttsl.crmapppages.Initializer;
import com.ttsl.crmapppages.LoginTestPage;
import com.ttsl.crmreportgenertor.ScreenShoot;
import com.ttsl.crmutils.ExcellDataSet;

@Listeners(com.ttsl.crmtestlistener.Listener.class)
public class LoginTestCase extends Initializer{
	
	
	
	
	@BeforeClass
//	@Parameters({"Browser"})
	
	public void setUp() throws Exception
	{
		
		
		Initializer.openBrowser("chrome");
		
		LoginTestPage.enterUserName("velmurugan");
		LoginTestPage.enterPassword("9789679298");
		LoginTestPage.clickLoginButton();
		
		}
		
			
	
//	@Test(priority=1)
//	
//	public void loginTest()
//	{
//		//test=report.createTest("LodgnTest");
//		
//	}

	
	@Test(priority=2,dataProvider="DATASET")
	
	public void enterContactDetails(String data,String Title,String FirstName,String LastName) throws Exception
	{
		
		test=report.createTest(data);
		driver.switchTo().frame("mainpanel");
		LoginTestPage.selectContact();
		//driver.switchTo().defaultContent();
		LoginTestPage.selectTitle(Title);
		LoginTestPage.enterFirstName(FirstName);
		LoginTestPage.enterLastName(LastName);
		LoginTestPage.clickSaveButton();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	
	public void tearDown(ITestResult result) throws Exception
	{
		
		ScreenShoot.extentReportTest(result);
		
		report.flush();
		
	}

	@DataProvider(name="DATASET")
	
	public static Object[][] setData() throws Exception
	{
//		Object[][] data = new Object[2][4];
//		
//		data[0][0]="enterContactDetails1";
//		data[0][1]="Mr.";
//		data[0][2]="Velmurugan";
//		data[0][3]="R";
//		
//		data[1][0]="enterContactDetails2";
//		data[1][1]="Dr.";
//		data[1][2]="Vaishnu";
//		data[1][3]="V";
		
		Object[][] data = ExcellDataSet.getMultipleData();
		
		return data;
	}
	
}
