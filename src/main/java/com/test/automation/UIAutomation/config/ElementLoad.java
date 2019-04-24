package com.test.automation.UIAutomation.config;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.test.automation.UIAutomation.testBase.TestBase;

public class ElementLoad extends TestBase {
	public static Logger log = Logger.getLogger(ElementLoad.class.getName());

	public static WebElement getLocator(String locator) throws Exception {
		WebElement homepageload = null;
		// System.out.println(locator);
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		// System.out.println("locatorType:-" + locatorType);
		// System.out.println("locatorValue:-" + locatorValue);
		try {
			if (locatorType.toLowerCase().equals("id"))
				homepageload = driver.findElement(By.id(locatorValue));
			else if (locatorType.toLowerCase().equals("name"))
				homepageload = driver.findElement(By.name(locatorValue));
			else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
				homepageload = driver.findElement(By.className(locatorValue));
			else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
				homepageload = driver.findElement(By.tagName(locatorValue));
			else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
				homepageload = driver.findElement(By.linkText(locatorValue));
			else if (locatorType.toLowerCase().equals("partiallinktext"))
				homepageload = driver.findElement(By.partialLinkText(locatorValue));
			else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
				homepageload = driver.findElement(By.cssSelector(locatorValue));
			else if (locatorType.toLowerCase().equals("xpath"))
				homepageload = driver.findElement(By.xpath(locatorValue));
			else if(locatorType.toLowerCase().equals("text"))
					homepageload = driver.findElement(By.xpath(locatorValue));
			
			else
				throw new Exception("Unknown locator type '" + locatorType + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return homepageload;
	}

	public static List<WebElement> getLocators(String locator) throws Exception {
		List<WebElement> homepageload = null;
		// System.out.println(locator);
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		//log.info("locatorType:-" + locatorType);
		//log.info("locatorValue:-" + locatorValue);
		// System.out.println("locatorType:-" + locatorType);
		// System.out.println("locatorValue:-" + locatorValue);
		try {
			if (locatorType.toLowerCase().equals("id")) {
				homepageload = driver.findElements(By.id(locatorValue));
				log.info(homepageload.toString());
			} else if (locatorType.toLowerCase().equals("name")) {
				homepageload = driver.findElements(By.name(locatorValue));
				log.info(homepageload.toString());
			} else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class"))) {
				homepageload = driver.findElements(By.className(locatorValue));
				log.info(homepageload.toString());
			} else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag"))) {
				homepageload = driver.findElements(By.tagName(locatorValue));
				log.info(homepageload.toString());
			} else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link"))) {
				homepageload = driver.findElements(By.linkText(locatorValue));
				log.info(homepageload.toString());
			} else if (locatorType.toLowerCase().equals("partiallinktext"))
			{
				homepageload = driver.findElements(By.partialLinkText(locatorValue));
				log.info(homepageload.toString());
			} else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css"))) {
				homepageload = driver.findElements(By.cssSelector(locatorValue));
				log.info(homepageload.toString());
			} else if (locatorType.toLowerCase().equals("xpath")) {
				homepageload = driver.findElements(By.xpath(locatorValue));
				log.info(homepageload.toString());
			} else
			{
				throw new Exception("Unknown locator type '" + locatorType + "'");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return homepageload;
	}

	public static WebElement getWebElement(String locator, Properties fileName) throws Exception {
		WebElement elementlocator = null;
		if (elementlocator == null) {
			try {
				elementlocator = getLocator(fileName.getProperty(locator));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return elementlocator;
	}

	public static List<WebElement> getWebElements(String locator, Properties fileName) throws Exception {
		List<WebElement> elementlocator = null;
		// fileName = loginPropertyFile;
		if (elementlocator == null) {

			try {
				elementlocator = getLocators(fileName.getProperty(locator));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return elementlocator;
	}
	
	public static WebElement waitElement(String element) {
		String s = element;
		By t1 = By.xpath(s);
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(t1));
		return ele;
	}

	public static List<WebElement> waitElements(String element) {
		String s = element;
		By t1 = By.xpath(s);
		List<WebElement> t = driver.findElements(t1);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		List<WebElement> foo = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(t1));
		//.presenceOfAllElementsLocatedBy(t1));
		System.out.println("size="+foo.size());
		return foo;
	}
	
}
