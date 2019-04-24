package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class Interview extends TestBase {
	public static Logger log= Logger.getLogger(Interview.class);
		
	public static WebElement dropdownInterviewAppeal()
	{
		return waitElement("//select[@id='drpInterviewAppeal']");
	}
	public static WebElement interviewDateTime()
	{
		return waitElement("//input[@id='InterviewDateTime']");
	}
	public static WebElement dropdownInterviewType()
	{
		return waitElement("//select[@id='InterviewType']");
	}
	public static WebElement dropdownHiringManager()
	{
		return waitElement("//select[@id='drpHiringManager']");
	}
	
	public static WebElement dressCode()
	{
		return waitElement("//input[@id='DressCode']");
	}
	public static WebElement notes()
	{
		return waitElement("//textarea[@id='Notes']");
	}
	public static WebElement clientFeedBack()
	{
		return waitElement("//textarea[@id='ClientFeedbackDescription']");
	}
	public static WebElement candidateFeedBack()
	{
		return waitElement("//textarea[@id='CandidateFeedbackDescription']");
	}
	public static WebElement dropdownInterviewResult()
	{
		return waitElement("//select[@id='drpResult']");
	}
	public static WebElement referenceCheckDocument()
	{
		return waitElement("//input[@id='File']");
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
