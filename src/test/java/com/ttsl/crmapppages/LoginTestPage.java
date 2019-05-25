package com.ttsl.crmapppages;

import org.openqa.selenium.WebElement;

public class LoginTestPage extends Initializer{
	
	
	public static void enterUserName(String userName)
	{
		
		getElement("USERNAME_XPATH").clear();
		getElement("USERNAME_XPATH").sendKeys(userName);
	}

	
	public static void enterPassword(String Password)
	{
		
		getElement("PASSWORD_XPATH").clear();
		getElement("PASSWORD_XPATH").sendKeys(Password);
	}
	
	public static void clickLoginButton()
	{
		getElement("LOGIN_BUTTON_XPATH").click();
	}
	
	public static void selectContact()
	{
		
		WebElement contact=getElement("CONTACT_XPATH");
		
		WebElement newcontact=getElement("NEWCONTACT_XPATH");
		DriverFunctions.actionFunction(contact,newcontact);
	}
	
	public static void enterFirstName(String fname)
	{
		//getElement("FIRSTNAME_XPATH").clear();
		getElement("FIRSTNAME_XPATH").sendKeys(fname);
	}
	
	
	public static void enterLastName(String Lname)
	{
		//getElement("LASTNAME_XAPTH").clear();
		getElement("LASTNAME_XAPTH").sendKeys(Lname);
		
	}
	
	public static void clickSaveButton()
	{
		getElement("SAVE_BUTTON_XPATH").click();
	}
	
	public static void selectTitle(String Title)
	{
		WebElement element=getElement("SELECT_TITLE_XPATH");
		
		DriverFunctions.selectFunction(element, Title);
	}
}
