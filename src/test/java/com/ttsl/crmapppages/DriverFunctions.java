package com.ttsl.crmapppages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DriverFunctions extends Initializer {

	
	public static void loadUrl(String URLName)
	{
		driver.get(locprop.getProperty(URLName));
	}
	
	public static void actionFunction(WebElement element,WebElement target)
	{
		
		Actions bulider = new Actions(driver); 
		
		
		bulider.moveToElement(element).moveToElement(target).click().build().perform();
	}
	
	public static void selectFunction(WebElement element,String Title)
	{
		Select s = new Select(element);
		
		s.selectByVisibleText(Title);
	}
}
