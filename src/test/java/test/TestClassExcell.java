package test;

import java.io.IOException;

import com.ttsl.crmutils.ExcellDataSet;

public class TestClassExcell {
	
	public static void main(String[] args) throws Exception, Exception {
		
		if(ExcellDataSet.checkTestMethodName("LOGINPAGE"))
		{
			System.out.println("Method Name is HOME PAGE");
		} else 
			System.out.println("False");
		
	}

}
