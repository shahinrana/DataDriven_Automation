package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class Email extends TestBase
{
	public static Logger log=Logger.getLogger(Email.class);

	public static WebElement send()
	{
		return waitElement("//input[@id='send']");
	}
}
