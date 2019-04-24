package com.test.automation.UIAutomation.uiActions.Dashboard;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class SubDashboardPage extends TestBase
{
	public static Logger log = Logger.getLogger(SubDashboardPage.class.getName());
	
	public WebElement selectLocation(String location)
	{
		return driver.findElement(By.xpath("//select[@id='ddlLocation']/option[contains(text(),'"+location+"')]"));
	}
	public WebElement selectDaybtn(String Day)
	{
		return driver.findElement(By.xpath("//a[contains(text(),'"+Day+"')]"));
	}	
	public WebElement selectExportbtn()
	{
		return driver.findElement(By.xpath("//a[@id='export']"));
	}
	
	public static WebElement getCount(String dashboardItem)
	{
		return driver.findElement(By.xpath("//span[contains(text(),'"+dashboardItem+"')]/preceding-sibling::span"));
	}
}
