package com.ttsl.crmreportgenertor;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.MediaPrintableArea;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ttsl.crmapppages.Initializer;

public class ScreenShoot extends Initializer {
	
	 
	
	
	public static void extentReportTest(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			
			Object[] data=result.getParameters();
							String path=getScreenShoot(data[0].toString());
			
				//path=getScreenShoot(data[0].toString());
			
				
			
			test.addScreenCaptureFromPath(path);
			
	//test.fail(result.getThrowable().getMessage(),MediaPrin)
			
			test.log(Status.PASS, data[0].toString());
			//test.log(Status.PASS, result.getThrowable().getMessage());
			
			test.log(Status.PASS, "This Test Case Is Passed");
		}else if (result.getStatus()==ITestResult.FAILURE)
			
		{
			
			
			//String path=getScreenShoot(result.getName());
			
			Object[] data=result.getParameters();
			String path=getScreenShoot(data[0].toString());
			test.addScreenCaptureFromPath(path);
			
			
			
			test.log(Status.FAIL, data[0].toString());
			
			test.log(Status.FAIL, result.getThrowable());
			test.log(Status.FAIL, "This Test Case Is Failed");
		}
	}
	
	
	public static String getScreenShoot(String MethodName) throws Exception
	{
		//SimpleDateFormat dateformate = new SimpleDateFormat("YYYY:MM:DD:HH:MM:SS:mmm");
		
		//String date=dateformate.format(new Date());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File DstFile=new File("D:\\WrokOutSelenium Wrokphase\\CRMDDDFRAMEWORK\\Screen_Shoots\\"+MethodName+".jpg");
		
		FileUtils.copyFile(src, DstFile);
		
		return DstFile.toString();
	}
	
	
	

}
