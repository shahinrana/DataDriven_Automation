package com.test.automation.UIAutomation.uiActions.Candidates;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class NewCandidatePage extends TestBase 
{
	public static Logger log=Logger.getLogger(NewCandidatePage.class.getName());

	
	public static List<WebElement> findHeaderMenu()
	{
		List<WebElement> HeaderMenu=null;
		/*log.info("*******************************");
		driver.getTitle();
		log.info(driver.getTitle());*/
		 //List<WebElement> HeaderMenu = driver.findElements(By.xpath("//*[@id='content']/div/div/div/ul/li"));
		try {
			HeaderMenu=	ElementLoaderObj.getWebElements("HeaderMenuDetails", CandidateDetailsPropertyFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// log.info(HeaderMenu.size());
		 return HeaderMenu;
		
	}
	public static String findHeaderMenuTitle()
	{
		String headerTitle = null;
		try {			
			//log.info("HeaderMenu"+findHeaderMenu().size());
			 for(int i=0;i<findHeaderMenu().size();i++)
			 {			 
				 headerTitle=  findHeaderMenu().get(i).getText();
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return headerTitle;
	}
	
	public static List<WebElement> findSideHeaderButton()
	{
		List<WebElement> findHeaderSiedButton=null;
		/*log.info("*******************************");
		driver.getTitle();
		log.info(driver.getTitle());*/
		 //List<WebElement> HeaderMenu = driver.findElements(By.xpath("//*[@id='content']/div/div/div/ul/li"));
		try {
			findHeaderSiedButton=	ElementLoaderObj.getWebElements("HeaderSubmenuDetails", CandidateDetailsPropertyFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// log.info(HeaderMenu.size());
		 return findHeaderSiedButton;
		
	}
	public static String findSideHeaderButtonitle()
	{
		String findSideHeaderTitle = null;
		try {			
			//log.info("HeaderMenu"+findHeaderMenu().size());
			 for(int i=0;i<findHeaderMenu().size();i++)
			 {			 
				 findSideHeaderTitle=  findSideHeaderButton().get(i).getText();
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findSideHeaderTitle;
	}

}
