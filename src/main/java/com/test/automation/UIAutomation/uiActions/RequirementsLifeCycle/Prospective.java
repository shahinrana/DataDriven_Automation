package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class Prospective extends TestBase
{
	public static Logger log=Logger.getLogger(Prospective.class.getName());
	
	public static WebElement payRateType()
	{
		return waitElement("//select[@id='drpPayRate']");
	} 
	public static WebElement payRateAmount()
	{
		return waitElement("//input[@id='Amount']");
	}
	public static WebElement contractType()
	{
		return waitElement("//select[@id='drpContract']");
	}
	public static WebElement avialability()
	{
		return waitElement("//input[@id='Availability']");
	}
	public static WebElement distance()
	{
		return waitElement("//input[@id='ProspectiveDistanceInMiles']");
	}
	public static WebElement comments()
	{
		return waitElement("//textarea[@id='Comments']");
	}
	public static WebElement vendor()
	{
		return waitElement("//select[@id='drpVendor']");
	}
	public static WebElement uploadBackgroundCheck()
	{
		return waitElement("//input[@id='File']");
	}

	public static WebElement termAndCondition()
	{
		return waitElement("//input[@id='TermAndCondition']");
	}
	public static void save()
	{
		waitElement("//input[@type='submit' and @value='Save']").click();
	}
	public static void back()
	{
		waitElement("//form[@id='frmProspective']/div/div/a[contains(text(),'Back')]").click();
	}
	public static void generateEmail()
	{
		waitElement("//input[@id='btnGenerateMail']").click();
	}
}
