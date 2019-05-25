package com.ttsl.crmtestlistener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ttsl.crmapppages.Initializer;
import com.ttsl.crmreportgenertor.ScreenShoot;

public class Listener extends Initializer implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		//Object[] data=result.getParameters();
		
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,result.getName());
		test.log(Status.PASS, "This TestCase Is Passed");
		
		try {
			String path=ScreenShoot.getScreenShoot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,result.getName());
		test.log(Status.FAIL, "This TestCase Is Fail");
		
		try {
			String path=ScreenShoot.getScreenShoot(result.getName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		//report.flush();
	}

}
