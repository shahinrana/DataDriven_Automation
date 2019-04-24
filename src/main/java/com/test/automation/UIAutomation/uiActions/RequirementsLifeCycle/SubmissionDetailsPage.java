package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class SubmissionDetailsPage extends TestBase
{
	public static Logger log= Logger.getLogger(SubmissionDetailsPage.class);
	
	public static WebElement selectRCTLAM()
	{
		return waitElement("//select[@id='CommentBy']");
	}
	public static WebElement selectAccept()
	{
		return waitElement("//input[1][@id='ResumeStatus']");
	}
	public static WebElement selectReject()
	{
		return waitElement("//input[2][@id='ResumeStatus']");
	}
	public static WebElement selectHandOff()
	{
		return waitElement("//input[0][@id='ResumeStatus']");
	}
	public static WebElement selectQualityOfResume()
	{
		return waitElement("//select[@id='IntensityMasterID']");
	}
	public static WebElement selectOther()
	{
		return waitElement("//textarea[@id='IntensityComment']");
	}
	public static WebElement reviewDetais(String tl)
	{
		return waitElement("//ul[@id='ulCandidateRef']/li/div/div/div[contains(text(),'"+tl+"')]");
	}
	public static WebElement save()
	{
		return waitElement("//input[@id='btnReviewSave']");
	}
	
}
