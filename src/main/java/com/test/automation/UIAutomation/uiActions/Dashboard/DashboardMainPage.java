package com.test.automation.UIAutomation.uiActions.Dashboard;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class DashboardMainPage extends TestBase
{
	public static Logger log = Logger.getLogger(DashboardMainPage.class.getName());
		
	public WebElement HeaderSelect(String Header)
	{
		WebElement element=driver.findElement(By.xpath("//div[@id='content']//following-sibling::div/a[contains(text(),'"+Header+"')]"));
		return element;
	}
	
	
	
	
}
