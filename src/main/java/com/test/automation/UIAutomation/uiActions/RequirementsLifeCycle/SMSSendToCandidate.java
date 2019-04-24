package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.test.automation.UIAutomation.testBase.TestBase;

public class SMSSendToCandidate extends TestBase{

	public static Logger log= Logger.getLogger(SMSSendToCandidate.class);
	public static WebElement smsBody()
	{
		return waitElement("//textarea[@id='SMSBody']");
	} 
	public static WebElement textboxPhoneNo()
	{
		return waitElement("//input[@id='OtherPhoneNumber']");
	}
	public static WebElement sendMessage()
	{
		return waitElement("//input[@id='2' and @value='Send Message']");
	}
	
}
