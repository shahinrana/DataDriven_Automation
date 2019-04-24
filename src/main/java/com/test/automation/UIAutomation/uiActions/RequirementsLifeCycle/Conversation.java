package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class Conversation extends TestBase
{
	public static Logger log=Logger.getLogger(Conversation.class.getName());
	
	public static WebElement phoneNumber()
	{
		return waitElement("//input[@id='OtherPhoneNumber']");
	} 
	public static WebElement conversion(String conversionType)
	{
		return waitElement("//div[contains(.,'"+conversionType+"')]/input[@type='radio']");
	}
	public static WebElement summary()
	{
		return waitElement("//textarea[@id='Summary']");
	}

	public static WebElement timeToJoin()
	{
		return waitElement("//input[@id='JoiningTimeTxt']");
	}
	public static void isConfirmationReceived(String value)
	{
		if(value.equalsIgnoreCase("yes"))
		{
			waitElement("//div[@class='col8']/input[1]").click();
		}
		else
		{
			waitElement("//div[@class='col8']/input[2]").click();
		}
		
	}
	
	public static void save()
	{
		waitElement("//input[@id='btnSave']").click();
	}
}
