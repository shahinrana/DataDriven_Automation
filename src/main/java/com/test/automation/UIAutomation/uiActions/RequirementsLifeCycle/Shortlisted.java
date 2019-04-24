package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class Shortlisted extends TestBase{

	public static Logger log=Logger.getLogger(Shortlisted.class);
	
	public static WebElement pending()
	{
		return waitElement("//input[1][@id='ShortlistedStatus']");
	}
	public static WebElement rejected()
	{
		return waitElement("//input[2][@id='ShortlistedStatus']");
	}
	public static WebElement interviewReceived()
	{
		return waitElement("//input[3][@id='ShortlistedStatus']");
	}
	public static WebElement declined()
	{
		return waitElement("//input[4][@id='ShortlistedStatus']");
	}
	public static WebElement comments()
	{
		return waitElement("//textarea[@id='ShortlistedStatusComment']");
	}
	public static WebElement save()
	{
		return waitElement("//input[@value='Save']");
	}
	public static WebElement back()
	{
		return waitElement("//a[contains(text(),'Back')]");
	}
	
}
