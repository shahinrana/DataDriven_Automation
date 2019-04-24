package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.test.automation.UIAutomation.testBase.TestBase;

public class Submission extends TestBase{

	public static Logger log= Logger.getLogger(Submission.class);

	public static WebElement SubmittedBillRate()
	{
		return waitElement("//input[@id='BillRateFromClient']");
	}	
	
	public static WebElement uploadFile()
	{
		return waitElement("//input[@id='File']");
	}
	public static WebElement submissionStatus()
	{
		return waitElement("//select[@id='drpSubmittedStatus']");
	}
	public static WebElement termsCondtion()
	{
		return waitElement("//input[@id='AgreeWithoutDrugTestAndBG']");
	}
	public static WebElement save()
	{
		return waitElement("//input[@id='btnSubmission']");
	}
	public static WebElement back()
	{
		return waitElement("//a[contains(text(),'Back')]");
	}

}
