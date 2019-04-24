package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class CandidateDetailPage extends TestBase {

	public static Logger log = Logger.getLogger(CandidateDetailPage.class.getName());
	
	public WebElement SelenctTabInfo(String CandidateDetailsTab)
	{
		return waitElement("//li[contains(text(),'"+CandidateDetailsTab+"')]");
					
	}
	public WebElement addReference()
	{
		return waitElement("//a[@id='lnkRefAdd']");
					
	}
	public WebElement refContactName()
	{
		return waitElement("//input[@id='ContactPerson']");
					
	}
	public WebElement refContactNo()
	{
		return waitElement("//input[@id='CandidateRefPhoneNum']");
					
	}
	public WebElement refEmail()
	{
		return waitElement("//input[@id='RefEmail']");
					
	}
	public WebElement refSave()
	{
		return waitElement("//input[@id='btnRefSave']");
					
	}
	public WebElement refClose()
	{
		return waitElement("//input[@id='btnRefClose']");
					
	}
	
	public WebElement bottomSavebtn()
	{
		return waitElement("//input[@id='btnSaveInfo']");
	}
	

}
