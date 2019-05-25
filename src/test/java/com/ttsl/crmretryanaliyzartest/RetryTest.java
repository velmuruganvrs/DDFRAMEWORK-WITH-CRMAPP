package com.ttsl.crmretryanaliyzartest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{

	
	int count=0;
	
	int limit=1;
	public boolean retry(ITestResult result) {

if(count<limit)
{
	count++;
	return true;
}
		return false;
	}

}
