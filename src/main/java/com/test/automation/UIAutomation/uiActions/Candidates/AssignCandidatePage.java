package com.test.automation.UIAutomation.uiActions.Candidates;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.uiActions.Dashboard.DashboardMainPage;

public class AssignCandidatePage extends TestBase
{
	public static Logger log = Logger.getLogger(AssignCandidatePage.class.getName());
	public void dropdownClient(String client)
	{
		click(driver.findElement(By.xpath("//div[@id='drpClient_chosen']/a/span")));
		List<WebElement> wb=driver.findElements(By.xpath("//div[@id='drpClient_chosen']/div/ul/li"));
		for(WebElement e:wb)
		{
			if(e.getText().equals(client))
			{
				click(e);
				break;
			}
		}
	}
	
	public WebElement chekboxRequirement(String requirement)
	{
		return driver.findElement(By.xpath("//div[contains(text(),'"+requirement+"')]/preceding-sibling::div/input[@id='chkselect']"));
		
	}
	public void clickAssessment(String requirement)
	{
		if(requirement.equalsIgnoreCase("Assessment"))
		{
			click(driver.findElement(By.xpath("//a[@id='btnAssessment']")));
		}
		else if(requirement.equalsIgnoreCase("Assessment & Set SA Log"))
		{
			click(driver.findElement(By.xpath("//input[@id='btnAssessmentAndSALog']")));
		}
		else if(requirement.equalsIgnoreCase("Assessment & Send Mail"))
		{
			click(driver.findElement(By.xpath("//input[@id='btnAssessmentSendMail']")));	
		}
		else if(requirement.equalsIgnoreCase("Close"))
		{
			click(driver.findElement(By.xpath("//a[contains(text(),'Close')]")));		
		}
		else
		{
			log.info("Element not present");
		}
		//driver.findElement(By.xpath("//input[@value='AllAsigned']")).click();
	}
	
	public void selectListRequirement(String ListRequirement)
	{
		if(ListRequirement.equalsIgnoreCase("All Open"))
		{
		click(driver.findElement(By.xpath("//input[@value='AllOpen']")));
		}
		else if(ListRequirement.equalsIgnoreCase("My-Assigned"))
		{
		click(driver.findElement(By.xpath("//input[@value='MyAssigned']")));
		}
		else if(ListRequirement.equalsIgnoreCase("All-Asigned"))
		{
			click(driver.findElement(By.xpath("//input[@value='AllAsigned']")));
		}
		else if(ListRequirement.equalsIgnoreCase("All"))
		{
			click(driver.findElement(By.xpath("//input[@value='All']")));		
		}
		else if(ListRequirement.equalsIgnoreCase("Pipelined"))
		{
			click(driver.findElement(By.xpath("//input[@value='Pipelined']")));		
		}
		else
		{
			log.info("Element not present");
		}
		//;
		
	}
}
